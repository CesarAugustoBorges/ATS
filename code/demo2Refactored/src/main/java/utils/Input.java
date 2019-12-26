package utils; /**
 * Classe que abstrai a utilização da classe Scanner, escondendo todos os
 * problemas relacionados com excepções, e que oferece métodos simples e
 * robustos para a leitura de valores de tipos simples e String.
 *
 * É uma classe de serviços, como Math e outras de Java, pelo que devem ser
 * usados os métodos de classe implementados.
 *
 * Utilizável em BlueJ, NetBeans, CodeBlocks ou Eclipse.
 * 
 * Utilização típica:  int x = scanner.lerInt();
 *                     String nome = scanner.lerString();
 *
 *
 * @version 1.0 (6/2006)
 */

import static java.lang.System.out;
import static java.lang.System.in;

import java.util.Scanner;
import java.util.InputMismatchException;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Input {

 /**
  * Métodos de Classe
  */

 private static Scanner scanner = new Scanner(in);

 public static String lerString(String invalido, String novo) {
     boolean ok = false;
     String txt = "";
     while(!ok) {
         try {
             txt = scanner.nextLine();
             ok = true;
         }
         catch(InputMismatchException e)
             { out.println(invalido);
               out.print(novo);
               scanner.nextLine();
             }
     }
     //scanner.close();
     return txt;
  }


 public static int lerInt(String invalido, String novo) {
     boolean ok = false;
     int i = 0;
     while(!ok) {
         try {
             i = scanner.nextInt();
             ok = true;
         }
         catch(InputMismatchException e)
             { out.println(invalido);
               out.print(novo);
               scanner.nextLine();
             }
     }
     //scanner.close();
     return i;
  }

  public static double lerDouble(String invalido, String novo) {
     boolean ok = false;
     double d = 0.0;
     while(!ok) {
         try {
             d = scanner.nextDouble();
             ok = true;
         }
         catch(InputMismatchException e)
             { out.println(invalido);
               out.print(novo);
               scanner.nextLine();
             }
     }
     //scanner.close();
     return d;
  }

   public static float lerFloat(String invalido, String novo) {
     boolean ok = false;
     float f = 0.0f;
     while(!ok) {
         try {
             f = scanner.nextFloat();
             ok = true;
         }
         catch(InputMismatchException e)
             { out.println(invalido);
               out.print(novo);
               scanner.nextLine();
             }
     }
     //scanner.close();
     return f;
  }

   public static boolean lerBoolean(String invalido, String novo) {
     boolean ok = false;
     boolean b = false;
     while(!ok) {
         try {
             b = scanner.nextBoolean();
             ok = true;
         }
         catch(InputMismatchException e)
             { out.println(invalido);
               out.print(novo);
               scanner.nextLine();
             }
     }
     //scanner.close();
     return b;
  }

  public static short lerShort(String invalido, String novo) {
     boolean ok = false;
     short s = 0;
     while(!ok) {
         try {
             s = scanner.nextShort();
             ok = true;
         }
         catch(InputMismatchException e)
             { out.println(invalido);
               out.print(novo);
               scanner.nextLine();
             }
     }
     //scanner.close();
     return s;
  }

       public static GregorianCalendar lerData(String errorMessage, String message) {
         boolean ok = false;
         GregorianCalendar date = null;
         SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
         String str = "";
         String[] fields;
         int d = 0;
         int m = 0;
         int y = 0;

         /* enquanto não for inserida uma data válida */
         while (!ok) {
             /* Lê-se a data */
             str = Input.lerString(errorMessage, message);
                
             ft.setLenient(false);
             
             /* Faz-se o parsing da string lida para o tipo SimpleDateFormat. */
             
             try {
                 ft.parse(str);
             }
             
             /* Caso a data não seja válida, é exibida a mensagem de erro e é pedido que se insira uma nova 
              * data. */
             
             catch (ParseException e) {
                 out.println(errorMessage);
                 out.print(message);
                 continue;
             }
             
             /* Separam-se os campos pelo carater "-". */
             
             fields = str.split("-");
             
             /* São lançadas as exceções relativas à leitura de um inteiro para cada um dos três campos. */
             
             try {
                 d = Integer.parseInt(fields[0].trim());
             }
             catch (NumberFormatException | NullPointerException e) {
                 out.println(errorMessage);
                 out.print(message);
                 continue;
             }
             
             try {
                 m = Integer.parseInt(fields[1].trim());
             }
             catch (NumberFormatException | NullPointerException e) {
                 out.println(errorMessage);
                 out.print(message);
                 continue;
             }
             
             try {
                 y = Integer.parseInt(fields[2].trim());
             }
             catch (NumberFormatException | NullPointerException e) {
                 out.println(errorMessage);
                 out.print(message);
                 continue;
             }
             
             /* O boolean ok é posto a true, indicando que foi lida uma data válida. */
             
             ok = true;
         }
         
         /* É criada a variável referente à data que foi lida e é devolvida no return. */
         
         date = new GregorianCalendar(y, --m, d); 

         return date;
     }
}