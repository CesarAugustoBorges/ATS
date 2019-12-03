import Test.QuickCheck
import Dados
import Localidades

---------- PROP ----------
data Prop = Prop Nome Nif Email Morada

instance Show (Prop) where
    show (Prop nome nif email morada) = "NovoProp:"++ nome ++ "," ++ show(nif) ++ "," ++ email ++ "," ++ morada


genProp :: Nif -> Gen Prop
genProp nif = do 
             nome <- genNome
             email <- genEmail nif
             morada <- genMorada
             return (Prop nome nif email morada)

genProps :: Int -> [Nif] -> Gen [Prop]
genProps 1 (h:t) = do
                     prop <- genProp h
                     return [prop]
genProps n (h:t) = do
                      let props = genProps (n-1) t
                      lista <- props
                      prop <- genProp h
                      return ([prop] ++ lista)  

type Nome = String
type Nif = Int
type Email = String
type Morada = String

genNome :: Gen Nome
genNome = do nome <- elements nomes
             return nome

genNif :: Gen Nif
genNif = do nif <- choose(100000000,999999999)
            return nif

genNifs :: Int -> Gen [Nif]
genNifs n = genNifsAux n [] 

genNifsAux :: Int -> [Nif] -> Gen [Nif]
genNifsAux 0 l = return l
genNifsAux n l = do 
               nif <- genNif
               if elem nif l then genNifsAux n l else genNifsAux (n-1) (nif:l)

genEmail :: Nif -> Gen Email
genEmail nif = return (show (nif) ++ "@gmail.com")

genMorada :: Gen Morada
genMorada = frequency localidades

---------- Cliente -------
data Cliente = Cliente Nome Nif Email Morada X Y

instance Show (Cliente) where
    show (Cliente nome nif email morada x y) = "NovoCliente:"++ nome ++ "," ++ show(nif) ++ "," ++ email ++ "," ++ 
                                               morada ++ "," ++ show(x) ++ "," ++ show(y)


genCliente :: Nif -> Gen Cliente
genCliente nif = do nome <- genNome
                    email <- genEmail nif
                    morada <- genMorada
                    x <- genX
                    y <- genY
                    return (Cliente nome nif email morada x y)

genClientes :: Int -> [Nif] -> Gen [Cliente]
genClientes 1 (h:t) = do 
                        cliente <- genCliente h
                        return [cliente]
genClientes n (h:t) = do 
                         let clientes = genClientes (n-1) t
                         lista <- clientes
                         cliente <- genCliente h
                         return ([cliente] ++ lista)

type X = Float
type Y = Float

genX :: Gen X
genX = do x <- choose(-180,180)
          return x

genY ::Gen Y
genY = do y <- choose(-90,90)
          return y

---------- Carro ---------

data Carro = Carro Tipo Marca Matricula Nif VelocidadeMedia PrecoKM ConsumoKM Autonomia X Y

instance Show (Carro) where
    show (Carro tipo marca matricula nif velocidadeMedia precoKM consumoKM autonomia x y) = 
        "NovoCarro:" ++ show(tipo) ++ "," ++ marca ++ "," ++ matricula ++ "," ++ show(nif) ++ "," ++ show(velocidadeMedia) ++ "," ++ 
        show(precoKM) ++ "," ++ show(consumoKM) ++ "," ++ show(autonomia) ++ "," ++ show(x) ++ "," ++ show(y)


genCarro :: Nif -> Gen Carro
genCarro nif = do tipo <- genTipo
                  marca <- genMarca
                  matricula <- genMatricula
                  velocidadeMedia <- genVelocidadeMedia
                  precoKM <- genPrecoKM
                  consumoKM <- genConsumoKM
                  autonomia <- genAutonomia tipo
                  x <- genX
                  y <- genY
                  return (Carro tipo marca matricula nif velocidadeMedia precoKM consumoKM autonomia x y)

genCarros :: Int -> [Nif] -> Gen [Carro]
genCarros 1 l = do 
                    nif <- elements l
                    carro <- genCarro nif
                    return [carro]
genCarros n l = do 
                    let carros = genCarros (n-1) l
                    lista <- carros
                    nif <- elements l
                    carro <- genCarro nif
                    return ([carro] ++ lista)


data Tipo = Eletrico | Hibrido | Gasolina
          deriving Show

type Marca = String
type Matricula = String
type VelocidadeMedia = Int
type PrecoKM = Float
type ConsumoKM = Float
type Autonomia = Int

genTipo :: Gen Tipo
genTipo = do t <- frequency [(70,return Gasolina),(25,return Hibrido),(5,return Eletrico)]
             return t


genMarca :: Gen String
genMarca = do m <- elements marcas
              return m

genMatricula :: Gen Matricula
genMatricula = do a1 <- elements ['A'..'Z']
                  a2 <- elements ['A'..'Z']
                  n1 <- elements ['0'..'9']
                  n2 <- elements ['0'..'9']
                  n3 <- elements ['0'..'9']
                  n4 <- elements ['0'..'9']
                  return [a1,a2,'-',n1,n2,'-',n3,n4]

genVelocidadeMedia :: Gen VelocidadeMedia
genVelocidadeMedia = do vm <- choose(20,200)
                        return vm 

genPrecoKM :: Gen PrecoKM
genPrecoKM = do p <- choose(1.5,12.0)
                return p

genConsumoKM :: Gen ConsumoKM
genConsumoKM = do k <- choose (0.1,2.0)
                  return k

genAutonomia :: Tipo -> Gen Autonomia
genAutonomia Gasolina = do a <- elements [70..100]
                           return a
genAutonomia Eletrico = do a <- elements [100..130] 
                           return a
genAutonomia Hibrido = do a <- elements [120..160]
                          return a

----------- Aluguer -------

data Aluguer = Aluguer Nif X Y Tipo Preferencia

instance Show (Aluguer) where
    show (Aluguer nif x y tipo preferencia) = 
        "Aluguer:" ++ show(nif) ++ "," ++ show(x) ++ "," ++ show(y) ++ "," ++ show(tipo) ++ "," ++ show(preferencia)

genAluguer :: Gen Aluguer
genAluguer = do nif <- genNif
                x <- genX
                y <- genY
                tipo <- genTipo
                pref <- genPreferencia
                return (Aluguer nif x y tipo pref)

data Preferencia = MaisPerto
                 | MaisBarato
    deriving Show


genPreferencia :: Gen Preferencia
genPreferencia = do p <- frequency [(65,return MaisBarato),(35,return MaisPerto)]
                    return p

------------ Classificar

data Classificar = Classificar MatriculaOuNif Nota

instance Show (Classificar) where
    show (Classificar matriculaOuNif nota) = 
        "Classificar:" ++ show(matriculaOuNif) ++ "," ++ show(nota)


genClassificar :: Gen Classificar
genClassificar = do matriculaounif <- genMatriculaOuNif
                    nota <- genNota
                    return (Classificar matriculaounif nota)

data MatriculaOuNif = Matricula
                    | Nif
                    deriving Show

genMatriculaOuNif :: Gen MatriculaOuNif
genMatriculaOuNif = do m <- frequency [(50,return Matricula),(50,return Nif)]
                       return m

type Nota = Int

genNota :: Gen Nota
genNota = do n <- choose(0,100)
             return n

generateMany' :: Show a => Int -> Gen a -> Gen [a]
generateMany' n g = vectorOf n g

generateMany'' :: Show a => Int -> Gen a -> [Gen a]
generateMany'' 0 g = []
generateMany'' n g = g: (generateMany'' (n-1) g)

printMany :: Show a => Gen [a] -> IO()
printMany g = do
                 list <- generate g
                 printAll list

printAll :: Show a => [a] -> IO()
printAll [x] = print x
printAll (h:t) = do
                    print h
                    printAll t 

generateMany :: Show a => Int -> Gen a -> IO ()
generateMany 1 g = do pr <- generate g
                      print pr
generateMany n g = do pr <- generate g
                      print pr
                      generateMany(n-1) g

main = do 
          nifs <- generate(genNifs 500)
          props <- generate(genProps 2 nifs)
          clientes <- generate(genClientes 2 nifs)
          let nifsUsados = take 2 nifs
          carros <- generate(genCarros 2 nifsUsados)
          --printAll nifs
          printAll props
          printAll clientes
          printAll carros
          --generateMany 100 genCliente
          --generateMany 100 genCarro
          --generateMany 100 genAluguer
          --generateMany 100 genClassificar
