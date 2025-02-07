/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 16 20:40:42 GMT 2020
 */

package umcarro;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import carros.Aluguer;
import carros.Coordinate;
import carros.Veiculo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.junit.runner.RunWith;
import umcarro.UmCarroJa;
import utilizadores.Cliente;
import utilizadores.Utilizador;
import utils.ParDatas;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UmCarroJa_ESTest extends UmCarroJa_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.iniciarSessao("qdzg`T*p", "\n");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // qdzg`T*p
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      // Undeclared exception!
      try { 
        umCarroJa0.totalFactBDates("OZ", mockGregorianCalendar0, mockGregorianCalendar0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Aluguer aluguer0 = new Aluguer();
      // Undeclared exception!
      try { 
        umCarroJa0.respostaProp(false, aluguer0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      // Undeclared exception!
      try { 
        umCarroJa0.registarVeiculo((Veiculo) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      // Undeclared exception!
      try { 
        umCarroJa0.registarUtilizador((Utilizador) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Aluguer aluguer0 = new Aluguer();
      // Undeclared exception!
      try { 
        umCarroJa0.registaAluguer(aluguer0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Locale locale0 = Locale.TAIWAN;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
      // Undeclared exception!
      try { 
        umCarroJa0.guardarEstado((String) null, mockGregorianCalendar0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.File", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      try { 
        umCarroJa0.guardarEstado("2.agmUi8", mockGregorianCalendar0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Error in writing to file
         //
         verifyException("org.evosuite.runtime.mock.java.io.NativeMockedIO", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      // Undeclared exception!
      try { 
        umCarroJa0.classificarVeiculoJa("", (-2367));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Aluguer aluguer0 = new Aluguer();
      // Undeclared exception!
      try { 
        umCarroJa0.classificarVeiculo(aluguer0, (-1));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Aluguer aluguer0 = new Aluguer();
      // Undeclared exception!
      try { 
        umCarroJa0.classificarCliente(aluguer0, (-109));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      ParDatas parDatas0 = new ParDatas();
      try { 
        umCarroJa0.maisBarato((Coordinate) null, parDatas0, 0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Nao existem veiculos disponiveis para alugar. 1
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      List<Aluguer> list0 = umCarroJa0.getAlugueresProp((String) null);
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.getUtilizador((String) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      String string0 = umCarroJa0.getUserNIF();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      String string0 = umCarroJa0.toStringVeiculo();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      String string0 = umCarroJa0.toStringUser();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      String string0 = umCarroJa0.toStringAlugs();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      int int0 = umCarroJa0.getNAlugs();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Coordinate coordinate0 = new Coordinate(0.0, 0.0);
      ParDatas parDatas0 = new ParDatas((GregorianCalendar) null, (GregorianCalendar) null);
      try { 
        umCarroJa0.maisBaratoJa(coordinate0, parDatas0, "dkh!TqDU");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Nao existem ve\u00EDculos dispon\u00EDveis para alugar.
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.getAlugueresCliente((String) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // N\u00E3o efetuou nenhum aluguer.
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Coordinate coordinate0 = new Coordinate(0.0, (-751.7766755290614));
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone(1403, "Utilizador nao existe");
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(simpleTimeZone0);
      ParDatas parDatas0 = new ParDatas(mockGregorianCalendar0, mockGregorianCalendar0);
      try { 
        umCarroJa0.determinadaAutonomia(coordinate0, parDatas0, 3114, 0, 1403);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // N\u00E3o Existem Ve\u00EDculos Dispon\u00EDveis para Alugar.
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      TimeZone timeZone0 = TimeZone.getDefault();
      Locale locale0 = Locale.SIMPLIFIED_CHINESE;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(timeZone0, locale0);
      Coordinate coordinate0 = new Coordinate(0.0, (-1381.05686485));
      ParDatas parDatas0 = new ParDatas(mockGregorianCalendar0, mockGregorianCalendar0);
      try { 
        umCarroJa0.veiculoEspecifico(coordinate0, parDatas0, (String) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Coordinate coordinate0 = new Coordinate(0, 0.0);
      ParDatas parDatas0 = new ParDatas();
      try { 
        umCarroJa0.maisBaratoNoPerimetro(coordinate0, coordinate0, parDatas0, 0.0, (-1447));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Nao existem veiculos disponiveis para alugar. 1
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Coordinate coordinate0 = new Coordinate(1.0, 1.0);
      ParDatas parDatas0 = new ParDatas();
      try { 
        umCarroJa0.maisProximo(coordinate0, parDatas0, (-1019));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Nao existem veiculos disponiveis para alugar. 1
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-1), 0, (-1));
      umCarroJa0.alugueresEfetuados(mockGregorianCalendar0);
      assertEquals(1, mockGregorianCalendar0.getMinimalDaysInFirstWeek());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      List<Aluguer> list0 = umCarroJa0.alugueresClassificarVeiculo();
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.determinarListaAlugCli("-_!qOe#{nTToRZQQ", "< ]=JOwu2");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // < ]=JOwu2
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.altPrecoKm("?6bI}kYUB%jeGmSf{", 0.0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // ?6bI}kYUB%jeGmSf{
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.abastecerVeiculo("Posi\u00E7\u00E3o (latitude e longitude): ", (-1554.0625));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Posi\u00E7\u00E3o (latitude e longitude): 
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.sinalizarDisponibilidade("", false);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // 
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Veiculo veiculo0 = new Veiculo();
      umCarroJa0.registarVeiculo(veiculo0);
      assertEquals(0, veiculo0.getClassificacao());
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      boolean boolean0 = umCarroJa0.existeVeiculo("");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Cliente cliente0 = new Cliente();
      umCarroJa0.registarUtilizador(cliente0);
      List<Cliente> list0 = umCarroJa0.get10ClientesAlugueres();
      assertTrue(list0.contains(cliente0));
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      Utilizador utilizador0 = new Utilizador("E_~)kdTp[=X,8),[(", "D", "E_~)kdTp[=X,8),[(", "E_~)kdTp[=X,8),[(", "D", mockGregorianCalendar0);
      umCarroJa0.registarUtilizador(utilizador0);
      try { 
        umCarroJa0.get10ClientesAlugueres();
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // N\u00E3o existem clientes a apresentar.
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.get10ClientesKm();
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // N\u00E3o existem clientes a apresentar.
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.getAlugueresVeiculo("cMKt1<7w~~X<");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cMKt1<7w~~X<
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      boolean boolean0 = umCarroJa0.existeUtilizador("Nao existem ve\u00EDculos dispon\u00EDveis para alugar.");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      Utilizador utilizador0 = new Utilizador("E_~)kdTp[=X,8),[(", "D", "E_~)kdTp[=X,8),[(", "E_~)kdTp[=X,8),[(", "D", mockGregorianCalendar0);
      umCarroJa0.registarUtilizador(utilizador0);
      try { 
        umCarroJa0.get10ClientesKm();
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // N\u00E3o existem clientes a apresentar.
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      umCarroJa0.classificarClienteJa("Tempo a p\u00E9 at\u00E9 ao ve\u00EDculo: ", 1);
      assertEquals(0, umCarroJa0.getNVeiculos());
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      try { 
        umCarroJa0.alugueresClassificarCliente();
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // 
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      int int0 = umCarroJa0.getNVeiculos();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      String string0 = umCarroJa0.getEmailUser();
      List<Aluguer> list0 = umCarroJa0.determinarListaEspera(string0);
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Locale locale0 = Locale.ENGLISH;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
      try { 
        umCarroJa0.guardarEstado("", mockGregorianCalendar0);
        fail("Expecting exception: FileNotFoundException");
      
      } catch(FileNotFoundException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.mock.java.io.MockFileOutputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Coordinate coordinate0 = new Coordinate(1128.0, 1374.117256413688);
      // Undeclared exception!
      try { 
        umCarroJa0.alterarPosAutonomiaVeiculo("utilizadores.Cliente", coordinate0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Coordinate coordinate0 = new Coordinate((-4993.8174683383595), (-4993.8174683383595));
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      ParDatas parDatas0 = new ParDatas(mockGregorianCalendar0, mockGregorianCalendar0);
      try { 
        umCarroJa0.maisPertoJa(coordinate0, parDatas0, "");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Nao existem ve\u00EDculos dispon\u00EDveis para alugar.
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      int int0 = umCarroJa0.getNUsers();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      umCarroJa0.logoutUtilizador();
      // Undeclared exception!
      try { 
        umCarroJa0.getEmailUser();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      // Undeclared exception!
      try { 
        umCarroJa0.getPosicaoCliente();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // utilizadores.Utilizador cannot be cast to utilizadores.Cliente
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      Coordinate coordinate0 = new Coordinate(0.0, 0.0);
      // Undeclared exception!
      try { 
        umCarroJa0.alterarPosCliente("I1w!,KG_7vkS'#|Nj%V", coordinate0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      UmCarroJa umCarroJa0 = new UmCarroJa();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-1), 0, (-1));
      Coordinate coordinate0 = new Coordinate((-1000.30229569), (-2200.522));
      Aluguer aluguer0 = new Aluguer("", "", mockGregorianCalendar0, mockGregorianCalendar0, (-1), 0, 60, coordinate0, (-1), true, true, true, true, 578);
      // Undeclared exception!
      try { 
        umCarroJa0.altPrecoAluguer(0.0, aluguer0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("umcarro.UmCarroJa", e);
      }
  }
}
