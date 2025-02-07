/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 16 19:39:22 GMT 2020
 */

package carros;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import carros.Coordinate;
import carros.CoordinateManager;
import java.util.HashMap;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CoordinateManager_ESTest extends CoordinateManager_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      HashMap<String, Coordinate> hashMap0 = CoordinateManager.getBoundingBox(1, 2.0, 1);
      assertEquals(4, hashMap0.size());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.getBoundingBox(0.0, 2.0, 0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceWest(0.0, 0.0, (-1729));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceSouth((-90.0), (-90.0), 0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceNorth(0.0, 0.0, (-3665));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceEast((-74.95), 180.0, 0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceNorth(1.0, (-180.0), 1004);
      assertEquals((-180.0), coordinate0.getLongitude(), 0.01);
      assertEquals(1.00901908545256, coordinate0.getLatitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceWest(0.0, 2.0, 2);
      assertEquals(0.0, coordinate0.getLatitude(), 0.01);
      assertEquals(1.9820336943176096, coordinate0.getLongitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceWest(3.141592653589793, 3.141592653589793, 2362);
      assertEquals(3.141592653589793, coordinate0.getLatitude(), 0.01);
      assertEquals((-18.076614357313304), coordinate0.getLongitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceWest((-1.0), (-89.0), 2560);
      assertEquals((-1.0), coordinate0.getLatitude(), 0.01);
      assertEquals((-131.56297081040427), coordinate0.getLongitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceSouth(1.0, 1.0, 758);
      assertEquals(1.0, coordinate0.getLongitude(), 0.01);
      assertEquals(0.993190770146374, coordinate0.getLatitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceSouth(2.0, (-90.0), 1);
      assertEquals(1.9999910168471589, coordinate0.getLatitude(), 0.01);
      assertEquals((-90.0), coordinate0.getLongitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceNorth(3.141592653589793, 22.884198070270262, 126);
      assertEquals(22.884198070270262, coordinate0.getLongitude(), 0.01);
      assertEquals(3.142724530847784, coordinate0.getLatitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceNorth((-0.8810290427793983), (-0.8810290427793983), 2560);
      assertEquals((-0.8810290427793983), coordinate0.getLongitude(), 0.01);
      assertEquals((-0.8580321715059386), coordinate0.getLatitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceEast((-90.0), (-90.0), 565);
      assertEquals((-90.0), coordinate0.getLatitude(), 0.01);
      assertEquals((-78.67266187390926), coordinate0.getLongitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceEast(0.0, 0.0, 530);
      assertEquals(0.0, coordinate0.getLatitude(), 0.01);
      assertEquals(4.761071005833464, coordinate0.getLongitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceEast(22.88419807027181, 111.31949079327356, 1860);
      assertEquals(137.96640255239134, coordinate0.getLongitude(), 0.01);
      assertEquals(22.88419807027181, coordinate0.getLatitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceSouth(0.0, 0.0, 3);
      assertEquals((-2.6949458523585646E-5), coordinate0.getLatitude(), 0.01);
      assertEquals(0.0, coordinate0.getLongitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Coordinate coordinate0 = CoordinateManager.addDistanceNorth(0.0, 0.0, 403);
      assertEquals(0.0, coordinate0.getLongitude(), 0.01);
      assertEquals(0.003620210595001672, coordinate0.getLatitude(), 0.01);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      boolean boolean0 = CoordinateManager.isValidLongitude((-786.009423364997));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      boolean boolean0 = CoordinateManager.isValidLongitude(1317.4179399819013);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      boolean boolean0 = CoordinateManager.isValidLongitude(0.0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      boolean boolean0 = CoordinateManager.isValidLatitude(1133.280295);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      boolean boolean0 = CoordinateManager.isValidLatitude((-180.0));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      boolean boolean0 = CoordinateManager.isValidLatitude(90.0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      double double0 = CoordinateManager.longitudeConstant(2031.707001323);
      assertEquals(68.8964446024887, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      double double0 = CoordinateManager.latitudeConstant();
      assertEquals(111.31949079327356, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.getBoundingBox(3.141592653589793, 3.141592653589793, (-1196));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.getBoundingBox(0.0, (-1161.58), 1311);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.getBoundingBox(12756.274, (-1739.170066404856), 0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceWest(0.0, 0.0, 0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceEast(22.884198070270262, 111.31949079327357, (-2846));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceEast(75.88049932, 921.34574355668, 403);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceEast((-725.2937010222772), (-283), (-283));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceSouth((-13), (-13), (-13));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceNorth(25.610932508883685, 25.610932508883685, 0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceNorth(0.0, (-2035.0), (-4));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceNorth(111.31949079327356, 111.31949079327356, 1);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceWest((-1.0), 1755.125, 2472);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceSouth(0.0, (-1324.844878259), (-2372));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceWest(146.612382451, 0.0, 2037);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      // Undeclared exception!
      try { 
        CoordinateManager.addDistanceSouth((-3178.611), 0.0, 2754);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // All parameters are required and must be valid
         //
         verifyException("carros.CoordinateManager", e);
      }
  }
}
