import Prelude hiding ((<*>),(<$>))

import Data.Char
import Parser

------------------------ Enunciado --------------------------

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

--------------------------------------------------------------
--------------------------- Primeira versão ------------------

pP :: Parser Char P
pP = f <$> enclosedBy (symbol' '[') pIts (symbol' ']')   --symbol' '[' <*> pIts <*> symbol' ']' 
    where f its = R its

pIts :: Parser Char Its
pIts = separatedBy pIt (symbol' ',')

pIt :: Parser Char It
pIt  =  f <$> token' "Decl " <*> ident'
    <|> g <$> token' "Use " <*> ident'
    <|> h <$> enclosedBy (symbol' '[') pIts (symbol' ']')  --symbol' '[' <*> pIts <*> symbol' ']' 
    where f t str = Decl str
          g t str = Use str
          h its = Block its

------------------ Versão mais reduzida (2) -------------------

pP2 :: Parser Char P
pP2 = f <$> list (symbol' '[') (symbol' ',') pIt2 (symbol' ']')
    where f its = R its

pIt2 :: Parser Char It
pIt2  =  f <$> token' "Decl " <*> ident'
     <|> g <$> token' "Use " <*> ident'
     <|> h <$> pP2  --symbol' '[' <*> pIts <*> symbol' ']' 
     where f t str = Decl str
           g t str = Use str
           h (R its) = Block its


--------------------- Variáveis de teste ----------------------

test :: P
test = R (items)

items :: [It]
items = [
    Decl "x",
    Decl "y",
    Decl "x",
    Block [
        Block[
            Use "w"
        ],
        Use "y",
        Decl "x",
        Use "z"
    ],
    Decl "y",
    Use "x"
 ]

--------------------------------------------------------------

type Decl = String            -- A variavel declarada
type Decls = ([Decl], [Decl]) -- ([Declaracao anterior], [Declaracao do nivel atual])

analisador :: P -> [It]
analisador (R its) = analisadorItems its (getNextDecl its)

analisadorItems :: [It] -> Decls -> [It]
analisadorItems [] _ = []
analisadorItems ((Block x):xs) decls = analisadorItems x (decls <-> getNextDecl x) ++ analisadorItems xs decls
analisadorItems ((Decl x):xs) decls = if isItemValid decls (Decl x) then restanteAnalise  else [(Decl x)] ++ restanteAnalise
       where restanteAnalise = (analisadorItems xs (decls <+> ([] , [x])))
analisadorItems ((Use x):xs) decls = if isItemValid decls (Use x) then restanteAnalise else [(Use x)] ++ restanteAnalise
       where restanteAnalise = (analisadorItems xs decls)

isItemValid :: Decls -> It -> Bool 
isItemValid (declant, decl) (Use x) | elem x decl = True
                                    | elem x declant = True
                                    | otherwise = False
isItemValid (declant, decl) (Decl x) = not (elem x decl)
isItemValid (declant, decl) (Block x) = True

getNextDecl :: Its -> ([String],[String])
getNextDecl [] = ([], [])
getNextDecl ((Decl x):xs) = ([x], []) <+> getNextDecl xs
getNextDecl ((Use x):xs) =  getNextDecl xs 
getNextDecl ((Block x): xs) = getNextDecl xs

(<+>) :: Decls -> Decls -> Decls
(x1,y1) <+> (x2, y2) = (x1 ++ x2 , y1 ++ y2)

(<->) :: Decls -> Decls -> Decls
(x1,y1) <-> (x2, y2) = (x1 ++ x2 ++ y1 ++ y2 , [])

