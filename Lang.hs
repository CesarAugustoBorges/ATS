import Prelude hiding ((<*>),(<$>))

import Data.Char
import Parser

-------- ENUNCIADO ---------

data Exp = AddExp Exp Exp
         | MulExp Exp Exp
         | SubExp Exp Exp
         | GThen Exp Exp
         | LThen Exp Exp
         | OneExp Exp
         | Var String
         | Const Int

instance Show Exp where
  show = showExp

showExp (AddExp e1 e2) = showExp e1 ++ " + " ++ showExp e2
showExp (SubExp e1 e2) = showExp e1 ++ " - " ++ showExp e2
showExp (MulExp e1 e2) = showExp e1 ++ " * " ++ showExp e2
showExp (GThen e1 e2) = showExp e1 ++ " > " ++ showExp e2
showExp (LThen e1 e2) = showExp e1 ++ " < " ++ showExp e2
showExp (OneExp e)    = "( " ++ showExp e ++ " )"
showExp (Const i)      = show i
showExp (Var a)        = a

-----------------------------

-- 1.2

e :: Exp
e = MulExp (Const 5) (AddExp (Var "var") (Const 3))


-- 1.3

pexp :: Parser Char Exp
pexp =   f <$> pterm
     <|> g <$> pterm <*> symbol' '+' <*> pexp
     <|> h <$> pterm <*> symbol' '-' <*> pexp
   where f a = a
         g a b c = AddExp a c
         h a b c = SubExp a c

pterm :: Parser Char Exp
pterm =  f <$> pfactor
     <|> g <$> pfactor <*> symbol' '*' <*> pterm
   where f a = a
         g a b c = MulExp a c



pfactor :: Parser Char Exp
pfactor =   h <$> symbol' '(' <*> pexp <*> symbol' ')'
       <|>  i <$> pFinal <*> symbol' '<' <*> pFinal
       <|>  j <$> pFinal <*> symbol' '>' <*> pFinal
       <|>  pFinal
  where h a e f = OneExp e
        i e1 s e2 = LThen e1 e2
        j e1 s e2 = GThen e1 e2

pFinal :: Parser Char Exp
pFinal =   f <$> number'
      <|>  g <$> ident'
  where f a = Const (read a)
        g a = Var a

-- 1.4

e1 :: String
e1 =  "2 * 4 - 34" 



-------- ENUNCIADO ---------

data Prog = Prog Stats
data Stats = Stats [Stat]
data Stat = While Exp Stats
          | IfThenElse Exp Stats Stats
          | Assign String Exp

instance Show Prog where
     show = showProg

showProg (Prog sts) = showStats sts

instance Show Stats where
     show = showStats

showStats (Stats l) = showStatsList l
showStatsList [] = ""
showStatsList (st:[]) = showStat st
showStatsList (st:sts) = showStat st ++ ";\n " ++ (showStatsList sts)

instance Show Stat where
     show = showStat

showStat (Assign n e) = n ++ " = " ++ showExp e
showStat (While e sts) = "while (" ++ showExp e ++ ")\n " ++ "{ " ++ showStats sts ++ "}"

-----------------------------

-- 1.8

pProg :: Parser Char Prog
pProg = f <$> pStats
  where f stats = Prog stats 

pStats :: Parser Char Stats
pStats =  f <$> pStat <*> token' ";\n" <*> pStats
      <|> g <$> pStat 
      <|> succeed (Stats [])
  where f stat _ (Stats lstat) = Stats (stat:lstat)
        g stat = Stats [stat]

pStat :: Parser Char Stat
pStat =  f <$> token' "while (" <*> pexp <*> symbol' ')' <*> symbol' '{' <*> pStats <*> symbol' '}'
    <|>  h <$> ident' <*> token' "="  <*> pexp
  where f _ b _ _ d _ = While b d
        h id _ exp = Assign id exp

------ Variaveis usadas para testes ------

progTest :: Prog 
progTest = Prog (Stats [Assign "x" (Const 1), While (LThen (Var "x") (Const 3)) (Stats [Assign "x" (Const 3)])])

progTest2 :: Prog
progTest2 = Prog (Stats [While (LThen (Var "x") (Const 3)) (Stats [Assign "x" (Const 3)])])


progString :: [Char]
progString = "x = 1;\n while (x < 3)\n { x = 3}"


progString2 :: [Char]
progString2 = "x = 2"

-------------------------------------------

-- 1.10


pProg2 :: Parser Char Prog
pProg2 = f <$> pStats2
  where f stats = Prog stats 

pStats2 :: Parser Char Stats
pStats2 =  f <$> separatedBy pStat2 (token' ";\n")
  where f lstat = Stats lstat

pStat2 :: Parser Char Stat
pStat2 =  f <$> token' "while" <*> enclosedBy (symbol' '(') pexp  (symbol' ')') <*> enclosedBy (symbol' '{') pStats2 (symbol' '}')
     <|>  g <$> ident' <*> symbol' '='  <*> pexp
   where f _ b d  = While b d
         g id _ exp = Assign id exp