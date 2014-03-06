package dutchNationalFlag;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Some simple test for the DNF problem.
 * @author Graeme Boy
 * @author Vasilisa Bashlovkina
 */
public class DutchFlagTest
{
  /*
   * Prints a readable list of each item in an array. Useful for printing our
   * color arrays if we are confused by a failure.
   */
  public void
    printArray (String[] vals)
  {
    for (int i = 0; i < vals.length; i++)
      {
        System.out.println ("[" + i + "]" + vals[i]);
      }
  }

  /*
   * Creates a new array that contains a given number of the same values.
   */
  public String[]
    createSameValues (String val, int i)
  {
    String[] sameArray = new String[i];
    for (int x = 0; x < i; x++)
      {
        sameArray[x] = val;
      }
    return sameArray;
  }

  @Test
  public void
    alreadySorted ()
  {
    // Create a sorted array.
    String[] sortedArray = { "red", "white", "blue" };
    // Sort it using our dnf sorter.
    DutchFlag.dnf (sortedArray, new ColorClassifier ());
    // Test that it is still correctly sorted.
    assertArrayEquals (sortedArray, sortedArray);

    // Try this again with a more challenging array (more values).
    String[] greaterSortedArray = { "red", "red", "red", "white", "white",
                                   "white", "white", "blue", "blue" };
    // Sort it using our dnf sorter.
    DutchFlag.dnf (greaterSortedArray, new ColorClassifier ());
    // Test that it is still correctly sorted.
    assertArrayEquals (greaterSortedArray, greaterSortedArray);
  }

  @Test
  public void
    simpleTests ()
  {
    // A few simple tests.
    String[] testArray = { "blou", "rooi", "wit" };
    String[] sorted = { "rooi", "wit", "blou" };
    DutchFlag.dnf (testArray, new ColorClassifier ());
    assertArrayEquals (testArray, sorted);

    testArray = new String[] { "blue", "red", "blue", "white" };
    sorted = new String[] { "red", "white", "blue", "blue" };
    DutchFlag.dnf (testArray, new ColorClassifier ());
    assertArrayEquals (testArray, sorted);
    
  }
  
  @Test 
  public void singleValues ()
  {
    String[] testArray;
    String[] sorted;
    testArray = new String[] { "white" };
    sorted = new String[] { "white" };
    DutchFlag.dnf (testArray, new ColorClassifier ());
    assertArrayEquals (testArray, sorted);
    
    testArray = new String[] { "red" };
    sorted = new String[] { "red" };
    DutchFlag.dnf (testArray, new ColorClassifier ());
    assertArrayEquals (testArray, sorted);
    
    testArray = new String[] { "blue" };
    sorted = new String[] { "blue" };
    DutchFlag.dnf (testArray, new ColorClassifier ());
    assertArrayEquals (testArray, sorted);
  }

  @Test
  public void
    sameValues ()
  {
    String[] sameValues;

    sameValues = createSameValues ("red", 5);
    DutchFlag.dnf (sameValues, new ColorClassifier ());
    assertArrayEquals (sameValues, sameValues);

    sameValues = createSameValues ("white", 5);
    DutchFlag.dnf (sameValues, new ColorClassifier ());
    assertArrayEquals (sameValues, sameValues);

    sameValues = createSameValues ("blue", 5);
    DutchFlag.dnf (sameValues, new ColorClassifier ());
    assertArrayEquals (sameValues, sameValues);
  }

  @Test
  public void
    multilingualTest ()
  {
    // Create a multilingual array of colors.
    String[] testArray = { "red", "white", "white", "blue", "red", "blue",
                          "red", "white", "white", "red", "blue", "white",
                          "white", "ruber", "bomvu" };
    // Create a multilingual sorted array of colors.
    String[] ansArray = { "red", "bomvu", "red", "ruber", "red", "red",
                         "white", "white", "white", "white", "white", "white",
                         "blue", "blue", "blue", };
    // Use our algorithm to sort the original array.
    DutchFlag.dnf (testArray, new ColorClassifier ());
    // Asser that the original array, now presumable sorted, is equivalent to
    // the sort array.
    assertArrayEquals (testArray, ansArray);
  }
}
