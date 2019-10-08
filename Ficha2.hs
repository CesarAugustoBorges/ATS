import Prelude hiding ((<*>),(<$>))

import Data.Char
import Parser

ident :: Parser Char String
ident =  f <$> oneOrMore (satisfy isAlpha) <*> spaces
   where f a b = a

data P = R Its
type Its = [It]
data It = Block Its
        | Decl String
        | Use String

instance Show P where
    show = pp_P 

instance Show It where
    show = pp_It

pp_P (R its) = "[" ++ pp_Its its ++ "]"
pp_Its [] = ""
pp_Its [it] = pp_It it
pp_Its (it:its) = pp_It it ++ " , " ++ pp_Its its
pp_It (Decl n) = "Decl " ++ n
pp_It (Use n) = "Use " ++ n
pp_It (Block is) = "[" ++ pp_Its is ++ "]"

pP :: Parser Char P
pP = f <$> symbol' '[' <*> pIts <*> symbol' ']' 
    where f _ its _ = R its

pIts :: Parser Char Its
pIts =  f <$> separatedBy pIt (symbol' ',')
    <|> succeed []
    where f its = its
          g it = [it]

pIt :: Parser Char It
pIt  =  f <$> token "Decl " <*> ident
    <|> g <$> token "Use " <*> ident
    <|> h <$> symbol' '[' <*> pIts <*> symbol' ']'
    where f t str = Decl str
          g t str = Use str
          h s1 its s2 = Block its


test :: P
test = R ([
            Decl "x",
            Decl "y",
            Block [
                Use "y"
            ],
            Use "x"
         ])

saveDecl :: P -> ([String],[String])
saveDecl (R x) =  getDeclUses x

getDeclUses :: Its -> ([String],[String])
getDeclUses [] = ([], [])
getDeclUses ((Decl x):xs) = ([x], []) <+> getDeclUses xs
getDeclUses ((Use x):xs) =  ([], [x]) <+> getDeclUses xs 
getDeclUses ((Block x): xs) = getDeclUses xs

(<+>) :: ([String], [String]) -> ([String], [String]) -> ([String], [String])
(x1,y1) <+> (x2, y2) = (x1 ++ x2 , y1 ++ y2)


analisador :: P -> [It]
analisador (R (x:xs)) = undefined

isItemValid :: ([String], [String]) -> It -> Bool 
isItemValid ([decl], [uses]) (Use x) = 