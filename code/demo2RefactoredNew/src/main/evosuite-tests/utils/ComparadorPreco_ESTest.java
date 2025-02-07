/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 16 19:59:33 GMT 2020
 */

package utils;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import carros.Coordinate;
import carros.Veiculo;
import java.util.LinkedList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import utils.ComparadorPreco;
import utils.ParDatas;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ComparadorPreco_ESTest extends utils.ComparadorPreco_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ComparadorPreco comparadorPreco0 = new ComparadorPreco();
      Veiculo veiculo0 = new Veiculo();
      Coordinate coordinate0 = new Coordinate(0.0, (-3126.93738));
      LinkedList<ParDatas> linkedList0 = new LinkedList<ParDatas>();
      Veiculo veiculo1 = new Veiculo("z=NSluEd,h$f", "z=NSluEd,h$f", "z=NSluEd,h$f", 1167, 1013.652557, (-3126.93738), (-1), coordinate0, true, (-1), linkedList0);
      int int0 = comparadorPreco0.compare(veiculo0, veiculo1);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ComparadorPreco comparadorPreco0 = new ComparadorPreco();
      Veiculo veiculo0 = new Veiculo();
      // Undeclared exception!
      try { 
        comparadorPreco0.compare(veiculo0, (Veiculo) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("utils.ComparadorPreco", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ComparadorPreco comparadorPreco0 = new ComparadorPreco();
      Coordinate coordinate0 = new Coordinate((-2111780593), (-2111780593));
      Veiculo veiculo0 = new Veiculo();
      LinkedList<ParDatas> linkedList0 = new LinkedList<ParDatas>();
      Veiculo veiculo1 = new Veiculo("ZZpGVI+@V", "ZZpGVI+@V", "ZZpGVI+@V", (-2111780593), (-2111780593), (-2111780593), (-1), coordinate0, false, (-1), linkedList0);
      int int0 = comparadorPreco0.compare(veiculo0, veiculo1);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ComparadorPreco comparadorPreco0 = new ComparadorPreco();
      Veiculo veiculo0 = new Veiculo();
      int int0 = comparadorPreco0.compare(veiculo0, veiculo0);
      assertEquals((-1), int0);
  }
}
