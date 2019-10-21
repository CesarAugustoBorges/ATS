module Parser where 

import Prelude hiding ((<*>),(<$>))
import Data.Char

infixl 2 <|>
infixl 3 <*>

type Parser s r = [s] -> [(r , [s])]

---------------------------- 1.1 -----------------------------
isDigit' :: Char -> Bool
isDigit' x = x `elem` ['0'..'9']

number :: Parser Char [Char]
number  =   f <$> satisfy isDigit'
       <|>  g <$> satisfy isDigit' <*> number
  where f a = [a]
        g a b = a:b

number' :: Parser Char [Char]
number' = f <$> number <*> spaces
  where f n s = n

ident :: Parser Char [Char]
ident =  oneOrMore (satisfy isAlpha)

ident' :: Parser Char [Char]
ident' =  f <$> ident <*> spaces
   where f a b = a  
--------------------------------------------------------------

symbola :: Parser Char Char
symbola [] = []
symbola (x:xs) = if x == 'a' then [('a',xs)]
                 else []

symbol :: Eq a => a -> Parser a a
symbol s []                 = []
symbol s (x:xs) | s == x    = [(s,xs)]
                | otherwise = []

----------------------------- 1.4 ----------------------------

symbol' :: Char -> Parser Char Char
symbol' a = (\ a b -> a) <$>  symbol a <*> spaces

------------- spaces definido na pŕoxima alínea --------------
--------------------------------------------------------------

satisfy :: (s -> Bool) -> Parser s s
satisfy p []                  = []
satisfy p (x:xs) | p x        = [(x,xs)]
                 | otherwise = []


token :: Eq s => [s] -> Parser s [s]
token t [] = []
token t inp = if   take (length t) inp == t 
              then [(t,drop (length t) inp)]
              else []
      
token' :: [Char] -> Parser Char [Char]
token' t = f <$> token t <*> spaces 
     where f a b = a   

succeed :: r -> Parser s r
succeed r inp = [ ( r , inp) ]

(<|>) :: Parser s a -> Parser s a -> Parser s a
(p <|> q) inp = p inp ++ q inp

pS =   token "while"
  <|>  token "for"

{-
(<*>)::Parser s a-> Parser s b-> Parser s (a,b)
(p <*> r) inp = [ ((x,y),ys)
                | (x,xs)  <- p inp
                , (y,ys)  <- r xs
                ]
-}

(<$>) :: (a -> r) -> Parser s a -> Parser s r
(f <$> p) inp = [ (f v , xs)
                | (v   , xs)  <- p inp
                ]

{-
pS' =   f <$> (symbol 'a' <*> symbol 'b' <*> symbol 'c')
    <|> g <$> (symbol 'd')
  where f ((a,b),c) = [a,b,c]
        g d         = [d]
-}

(<*>) :: Parser s (a -> b) 
      -> Parser s a 
      -> Parser s b
(p <*> r) inp = [ (f v ,ys)
                | (f   ,xs)  <- p inp
                , (  v ,ys)  <- r xs
                ]

pS' =  f <$> symbol 'a' <*> symbol 'b' <*> symbol 'c'
   <|> g <$> symbol 'd'
  where f a b c  = [a,b,c]
        g d      = [d]

{-
oneOrMore p =  sf1 <$> p <*> oneOrMore p
           <|> sf2 <$> p
  where sf1 x xs = x : xs
        sf2 x = [x]
-}

---------------------- 1.5 / 1.6 -----------------------------

zeroOrMore :: Parser s r -> Parser s [r]
zeroOrMore p = sf <$> p <*> zeroOrMore p
             <|> succeed []
  where sf x xs = x : xs

spaces :: Parser Char [Char]
spaces = zeroOrMore 
          (satisfy (\x -> x `elem` [' ','\t','\n']))

--------------------------------------------------------------
------------------------- 1.7 --------------------------------

oneOrMore :: Parser s r -> Parser s [r]
oneOrMore p = f <$> p <*> zeroOrMore p
   where f a b = a : b

--------------------------------------------------------------
------------------------- 1.9 --------------------------------

separatedBy :: Parser s a -> Parser s b -> Parser s [a]
separatedBy pa pb =  f <$> pa <*> pb <*> separatedBy pa pb
                 <|> g <$> pa 
                 <|> succeed []
   where f a b ab = a:ab
         g a      = [a]
         

{-
separatedBy pa pb inp = [(resa : resaa, xxxs)]
    where [(resa ,  xs)] = pa inp
          [(resab, xxs)] = pb xs
          [(resaa,xxxs)] = separatedBy pa pb xxs
-}

enclosedBy :: Parser s a -> Parser s b -> Parser s c -> Parser s b
enclosedBy pa pb pc = f <$> pa <*> pb <*> pc
    where f a b c = b

-------------------------------------------------------------
------------------------- 1.10 -------------------------------

followedBy :: Parser s a -> Parser s b -> Parser s [a]
followedBy pa pb =  f <$> pa <*> pb <*> followedBy pa pb 
                <|> g <$> pa <*> pb
    where f a b ab = a:ab
          g a b    = [a]

block :: Parser s a -- open delimiter
      -> Parser s b -- syntactic symbol that follows statements
      -> Parser s r -- parser of statements
      -> Parser s f -- close delimiter
      -> Parser s [r]
block pa pb pr pf = f <$> pa <*> (followedBy pr pb) <*> pf
    where f a r f = r

--------------------------------------------------------------

list  :: Parser s a -- open delimiter
      -> Parser s b -- syntactic symbol that separats statements
      -> Parser s r -- parser of statements
      -> Parser s f -- close delimiter
      -> Parser s [r]
list pa pb pr pf = f <$> pa <*> (separatedBy pr pb) <*> pf
    where f a r f = r