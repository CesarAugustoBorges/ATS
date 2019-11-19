import Test.QuickCheck

---------- PROP ----------
data Prop = Prop Nome Nif Email Morada
     deriving Show 

genProp :: Gen Prop
genProp = undefined

type Nome = String
type Nif = String
type Email = String
type Morada = String

genNome ::Gen Nome
genNome = undefined

genNif ::Gen Nif
genNif = undefined

genEmail ::Gen Email
genEmail = undefined

genMorada ::Gen Morada
genMorada = undefined

---------- Cliente -------
data Cliente = Cliente Nome Nif Email Morada X Y

genCliente ::Gen Cliente
genCliente = undefined

type X = Float
type Y = Float

genX ::Gen X
genX = undefined

genY ::Gen Y
genY = undefined

---------- Carro ---------

data Carro = Carro Tipo Marca Matricula Nif VelocidadeMedia PrecoKM ConsumoKM Autonomia X Y

genCarro ::Gen Carro
genCarro = undefined

type Tipo = String
type Marca = String
type Matricula = String
type VelocidadeMedia = Int
type PrecoKM = Float
type ConsumoKM = Float
type Autonomia = Int

genTipo ::Gen Tipo
genTipo = undefined

genMarca ::Gen Marca
genMarca = undefined

genMatricula ::Gen Matricula
genMatricula = undefined

genVelocidadeMedia ::Gen VelocidadeMedia
genVelocidadeMedia = undefined

genPrecoKM ::Gen PrecoKM
genPrecoKM = undefined

genConsumoKM ::Gen ConsumoKM
genConsumoKM = undefined

genAutonomia ::Gen Autonomia
genAutonomia = undefined

----------- Aluguer -------

data Aluguer = Aluguer Nif X Y Tipo Preferencia

genAluguer ::Gen Aluguer
genAluguer = undefined

data Preferencia = MaisPerto
                 | MaisBarato

genPreferencia ::Gen Preferencia
genPreferencia = undefined

------------ Classificar

data Classificar = Classificar MatriculaOuNif Nota

genClassificar ::Gen Classificar
genClassificar = undefined

data MatriculaOuNif = Matricula
                    | Nif

genMatriculaOuNif ::Gen MatriculaOuNif
genMatriculaOuNif = undefined

type Nota = Int

genNota ::Gen Nota
genNota = undefined