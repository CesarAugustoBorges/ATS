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


genCarro :: [Nif] -> Matricula -> Gen Carro
genCarro nifs matricula = do tipo <- genTipo
                             nif <- elements nifs
                             marca <- genMarca
                             velocidadeMedia <- genVelocidadeMedia
                             precoKM <- genPrecoKM
                             consumoKM <- genConsumoKM
                             autonomia <- genAutonomia tipo
                             x <- genX
                             y <- genY
                             return (Carro tipo marca matricula nif velocidadeMedia precoKM consumoKM autonomia x y)

genCarros :: Int -> [Nif] -> [Matricula] -> Gen [Carro]
genCarros 0 _ _ = return []
genCarros n nifs (hm:tm) = do carro <- genCarro nifs hm
                              carros <- genCarros (n-1) nifs tm
                              return ([carro] ++ carros)



                            
data Tipo = Electrico | Hibrido | Gasolina

instance Show (Tipo) where
    show Electrico = "Electrico"
    show Hibrido = "Hibrido"
    show Gasolina = "Gasolina"

type Marca = String
type Matricula = String
type VelocidadeMedia = Int
type PrecoKM = Float
type ConsumoKM = Float
type Autonomia = Int

genTipo :: Gen Tipo
genTipo = do t <- frequency [(70,return Gasolina),(25,return Hibrido),(5,return Electrico)]
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

genMatriculas :: Int -> Gen [Matricula]
genMatriculas n = genMatriculasAux n []

genMatriculasAux :: Int -> [Matricula] -> Gen [Matricula]
genMatriculasAux 0 l = return l
genMatriculasAux n l = do 
                        matricula <- genMatricula
                        if elem matricula l then genMatriculasAux n l else genMatriculasAux (n-1) (matricula:l)

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
genAutonomia Electrico = do a <- elements [100..130] 
                            return a
genAutonomia Hibrido = do a <- elements [120..160]
                          return a

----------- Aluguer -------

data Aluguer = Aluguer Nif X Y Tipo Preferencia

instance Show (Aluguer) where
    show (Aluguer nif x y tipo preferencia) = 
        "Aluguer:" ++ show(nif) ++ "," ++ show(x) ++ "," ++ show(y) ++ "," ++ show(tipo) ++ "," ++ show(preferencia)

genAluguer :: [Nif] -> Gen Aluguer
genAluguer nifs = do nif <- elements nifs
                     x <- genX
                     y <- genY
                     tipo <- genTipo
                     pref <- genPreferencia
                     return (Aluguer nif x y tipo pref)

genAlugueres :: Int -> [Nif] -> Gen [Aluguer]
genAlugueres n nifs = vectorOf n (genAluguer nifs)


data Preferencia = MaisPerto
                 | MaisBarato
    deriving Show


genPreferencia :: Gen Preferencia
genPreferencia = do p <- frequency [(65,return MaisBarato),(35,return MaisPerto)]
                    return p

------------ Classificar

data Classificar = Classificar MatriculaOuNif Nota

instance Show Classificar where
    show (Classificar matriculaOuNif nota) = 
        "Classificar:" ++ matriculaOuNif ++ "," ++ show(nota)


genClassificar :: [Nif] -> [Matricula] -> Gen Classificar
genClassificar nifs matriculas = do matriculaounif <- genMatriculaOuNif nifs matriculas
                                    nota <- genNota
                                    return (Classificar matriculaounif nota)

type MatriculaOuNif = String

genMatriculaOuNif :: [Nif] -> [Matricula] -> Gen MatriculaOuNif
genMatriculaOuNif nifs matriculas = do  nif <- elements nifs 
                                        m <- frequency [(50,elements matriculas),(50, return (show(nif)))]
                                        return m

genClassificacoes :: Int -> [Nif] -> [Matricula] -> Gen [Classificar]
genClassificacoes n nifs matriculas = vectorOf n (genClassificar nifs matriculas) 

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

--NProprietario -> NClientes -> NCarros -> NClassificacoes
-- Numero de alugures tem de ser menor que o numero de carros, visto que, assume-se que o aluguer é instantaneo,
--     deste modo, garante-se que cada cliente consiga encontrar um carro
generator :: Int -> Int -> Int -> Int ->Int -> IO()
generator nProp nCli nCar nAlu nClas = do
                                        matriculas <- generate(genMatriculas nCar)
                                        nifs <- generate(genNifs (nProp + nCli))
                                        let nifsClients = drop nProp nifs
                                        let nifsProps = take nProp nifs
                                        props <- generate(genProps nProp nifsProps)
                                        clientes <- generate(genClientes nCli nifsClients)
                                        carros <- generate(genCarros nCar nifsProps matriculas )
                                        alugueres <- generate(genAlugueres nAlu nifsClients)
                                        classificacoes <- generate(genClassificacoes nClas nifsProps matriculas)
                                        printAll props
                                        printAll clientes
                                        printAll carros
                                        printAll alugueres
                                        printAll classificacoes

main = generator 100 500 130 30 600
