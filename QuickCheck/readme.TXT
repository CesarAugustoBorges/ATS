---- Como gerar o ficheiro de logs para a aplicação UmCarroJá? ----

R: 1.Abrir uma linha de comandos ou bash;
   2.Compilar o ficheiro geradorDeLogs.hs;
   3.Executar o executável.
  OU
   1.Abrir uma linha de comandos ou bash;
   2.Executar o comando "runHaskell ./geradorDeLogs.hs" , sem as aspas(").


--------------- Como guardar os logs num ficheiro ? ---------------

R: Imprimir os logs para a linha de comandos/bash permite uma maior liberdade 
na manipulação destes. Para guardar num ficheiro reencaminhe o output para o
ficheiro desejado com o comando "> ficheiro.bak", sem as aspas(").
   O comando inteiro deverá ser "runHaskell ./geradorDeLogs.hs > ficheiro.bak",
   sem as aspas(")