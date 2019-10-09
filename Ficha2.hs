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
test = R (items)

items :: [It]
items = [
    Decl "x",
    Decl "y",
    Block [
        Use "y",
        Decl "x",
        Use "z"
    ],
    Decl "x",
    Use "x"
 ]

type Decl = String
type Use = String
type DeclUse = ([Decl], [Use])

analisador :: P -> [It]
analisador (R its) = analisadorItems its (getDeclUses its) []

analisadorItems :: [It] -> DeclUse -> [Decl] -> [It]
analisadorItems [] _ _ = []
analisadorItems ((Block x):xs) declsUses decls = analisadorItems x (declsUses <+> getDeclUses x) [] ++ analisadorItems xs declsUses decls
analisadorItems ((Decl x):xs) declsUses decls = if isItemValid declsUses decls (Decl x) then analisadorItems xs declsUses (x:decls)  else [(Decl x)] ++ (analisadorItems xs declsUses (x:decls)) 
analisadorItems ((Use x):xs) declsUses decls = if isItemValid declsUses decls (Use x) then analisadorItems xs declsUses decls  else [(Use x)] ++ analisadorItems xs declsUses decls 

isItemValid :: DeclUse -> [Decl] ->  It -> Bool 
isItemValid (decl, uses) decls (Use x) | elem x decl = True
                                       | elem x decls = True
                                       | otherwise = False
isItemValid (decl, uses) decls (Decl x) = not (elem x decls)
isItemValid (decl, uses) decls (Block x) = True

getDeclUses :: Its -> ([String],[String])
getDeclUses [] = ([], [])
getDeclUses ((Decl x):xs) = ([x], []) <+> getDeclUses xs
getDeclUses ((Use x):xs) =  ([], [x]) <+> getDeclUses xs 
getDeclUses ((Block x): xs) = getDeclUses xs

(<+>) :: DeclUse -> DeclUse -> DeclUse
(x1,y1) <+> (x2, y2) = (x1 ++ x2 , y1 ++ y2)

