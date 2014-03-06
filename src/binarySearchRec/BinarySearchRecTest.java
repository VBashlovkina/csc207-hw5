package binarySearchRec;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * @author Graeme Boy
 * @author Vasilisa Bashlovkina
 *  
 * Some testing methods and comments were provided by SamR
 * http://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014
 * S/assignments/current.html
 * 
 * The testing methods were found in a book by John Bentley, called Programming Pearls 
 * ISBN-10: 8177588583
 */
public class BinarySearchRecTest
{

  /*
   * createTestArray is a simple helper to build an array of a given size, that
   * contains incrementing even values up to twice the value of the given size.
   * 
   * @pre i < Integer.MAX_VALUE
   * 
   * @returns testArray, an array of incrementing even integers
   * 
   * @post testArray contains even incrementing integers, starting at 0 and
   * ending at the size of the array multiplied by 2
   */
  public int[]
    createTestArray (int i)
  {
    int[] testArray = new int[i + 1];
    // for all i from 0 to s - 1 inclusive
    for (int x = 0; x <= i; x++)
      {
        // value at x is 2 * x
        testArray[x] = x * 2;
      }
    return testArray;
  }

  /*
   * Test the search algorithm when element is contained.
   */
  @Test
  public void
    testContained ()
      throws Exception
  {

    int[] testArray;
    int s = 32;
    // for each s from 1 to 32
    for (int i = 1; i < s; i++)
      {
        // Create an array of size s, containing the values 0, 2, 4, ... 2*(s-1)
        testArray = createTestArray (i);
        // Make sure that value 2*i is in position i
        assertEquals (i, BinarySearchRec.binarySearch (2 * i, testArray));
      }

  }

  /*
   * Using this testing method, check if there are odd numbers in the arrays
   * used above.
   * 
   * I didn't know how to test exceptions, so I read a tutorial online at:
   * http://www.mkyong.com/unittest/junit-4-tutorial-2-expected-exception-test/
   */
  @Test(expected = Exception.class)
  public void
    notContained ()
      throws Exception
  {
    int[] testArray;
    int s = 32;
    // for each s from 1 to 32
    for (int i = 1; i < s; i++)
      {
        testArray = createTestArray (i);
        // Make sure than no odd values are contained
        assertEquals (i, BinarySearchRec.binarySearch (2 * i + 1, testArray));
      }
  }

}
