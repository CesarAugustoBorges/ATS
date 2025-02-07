/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 16 19:58:02 GMT 2020
 */

package utils;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import carros.Coordinate;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.junit.runner.RunWith;
import utilizadores.Cliente;
import utils.ComparadorNAluguer;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ComparadorNAluguer_ESTest extends utils.ComparadorNAluguer_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ComparadorNAluguer comparadorNAluguer0 = new ComparadorNAluguer();
      Cliente cliente0 = new Cliente();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-1), 844, 844);
      Coordinate coordinate0 = new Coordinate((-1380.0), 0.0);
      Cliente cliente1 = new Cliente("", "", "", "", "", mockGregorianCalendar0, coordinate0, (-1), (-1), 0.0);
      int int0 = comparadorNAluguer0.compare(cliente0, cliente1);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ComparadorNAluguer comparadorNAluguer0 = new ComparadorNAluguer();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-971), (-971), 0);
      Coordinate coordinate0 = new Coordinate(0.0, (-971));
      Cliente cliente0 = new Cliente("", "", "", "", "Email: ", mockGregorianCalendar0, coordinate0, 0, 0, 0.0);
      // Undeclared exception!
      try { 
        comparadorNAluguer0.compare(cliente0, (Cliente) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("utils.ComparadorNAluguer", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ComparadorNAluguer comparadorNAluguer0 = new ComparadorNAluguer();
      Cliente cliente0 = new Cliente();
      Cliente cliente1 = new Cliente();
      cliente0.setNAlugueres((-1));
      int int0 = comparadorNAluguer0.compare(cliente0, cliente1);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ComparadorNAluguer comparadorNAluguer0 = new ComparadorNAluguer();
      Cliente cliente0 = new Cliente();
      int int0 = comparadorNAluguer0.compare(cliente0, cliente0);
      assertEquals((-1), int0);
  }
}
