package exponentiation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ExptTest
{

  @Test
  public void simpleTests()
  {
    assertEquals("2^2 = 4", 4.0, ExptUtils.expt(2, 2), .0000001);
  } // simpleTests()

  @Test
  public void cornerCases()
  {
    // Some corner cases:
    assertEquals("0^15 = 0", 0.0, ExptUtils.expt(0, 15), .0000001);
    assertEquals("0^0 = 1", 1.0, ExptUtils.expt(0, 0), .0000001);
    assertEquals("18^0 = 1", 1.0, ExptUtils.expt(18, 0), .0000001);
    assertEquals("22^1 = 22", 22.0, ExptUtils.expt(22, 1), .0000001);
    assertEquals("-22^1 = -22", -22.0, ExptUtils.expt(-22, 1), .0000001);
  } // cornerCases()

  @Test
  public void iterativeTesting()
  {
    double[] expected = new double[11 * 5];
    double[] test = new double[11 * 5];
    for (int i = 0; i < 11; i++)
      {
        for (int j = 1; j < 5; j++)
          {
            expected[j] = Math.pow(-5 + i, j);
            test[j] = ExptUtils.expt(-5 + i, j);
          }// for iterating powers
        assertArrayEquals(expected, test, .0000001);
      }// for iterating numbers

  }// iterativeTesting()

  @Test
  public void doubleTesting()
  {
    double [] expected = new double[11 * 5];
    double [] test = new double[11 * 5];
    for (int i = 0; i < 11; i++)
      {
        for (int j = 1; j < 5; j++)
          {
            expected[j] = Math.pow((-5 + i) / 22, j);
            test[j] = ExptUtils.expt((-5 + i) / 22, j);
          }// for iterating powers
        assertArrayEquals(expected, test, .0000001);
      }// for iterating numbers
  } // doubleTesting()

}
