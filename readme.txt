////////////////////////////////// Combinadores de Parsing ////////////////////////////////

$ ghci Ficha2.hs

*********************** Parser ***********************
-- Para verificar se uma declaração, uso ou bloco colocado em input respeita a sintaxe da linguagem definida

*Main> pIt "Use x"
*Main> pIt "Decl y"
*Main> pIt "[Use x, Decl y, Decl z]"

-- Para verificar se uma frase da linguagem respeita a sintaxe da linguagem definida

*Main> pP "[Decl x,Decl y,Decl x,Block [Use y,Decl x,Use z],Decl y,Use x]"

*********************** Analisador ***********************
-- Para verificar se uma declaração, uso ou bloco está numa posição válida tendo em conta declarações
-- O primeiro túpulo representa as declarações do nível atual e o segundo as declarações dos níveis anteriores
-- Para um bloco o resultado é sempre "True" sendo que pode-se iniciar um bloco em qualquer circunstância

*Main> isItemValid (["x","y","z"],["w","x"]) (Use "x")
*Main> isItemValid (["x","y","z"],["w","x"]) (Decl "x")
*Main> isItemValid (["x","y","z"],["w","x"]) (Block [Use "x"])

-- Para verificar se um conjunto de itens estão numa posição válida tendo em conta declarações já feitas

*Main> analisadorItems [Use "x",Decl "y",Block[Use "w"],Use "y"] ([],["y"])

-- Para efetuar a análise semântica de um input

*Main> analisador (R [Use "x",Decl "y",Block[Use "w"],Use "y"])~

-- Também é possível testar um input "test" já definido com o analisador semântico

*Main> analisador test