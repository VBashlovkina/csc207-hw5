package binarySearchRec;

/*
 * @author Graeme Boy
 * @author Vasilisa Bashlovkina
 *  
 * Javadoc for binarySearch provided by SamR -
 * http://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014
 * S/assignments/current.html
 */

public class BinarySearchRec
{

  /**
   * Search for val in values, return the index of an instance of val.
   * 
   * @param val
   *          An integer we're searching for
   * @param values
   *          A sorted array of integers
   * @result index, an integer
   * @throws Exception
   *           If there is no i s.t. values[i] == val
   * @pre values is sorted in increasing order. That is, values[i] < values[i+1]
   *      for all reasonable i.
   * @post values[index] == val
   */
  public static int
    binarySearch (int i, int[] vals)
      throws Exception
  {
    /*
     * Because we decided to use a recursive function, we need to use a helper
     * function that will take in more parameters than binarySearch. There is a
     * starting value for the lower bound, which is 0, and a starting value for
     * the upper bound, which is the length of vals - 1.
     * 
     * We will be verbose here for the sake of readibility.
     */
    int lowerInit = 0; // we start searching at the begining of the array,
    int upperInit = vals.length - 1; // and we end at the last item.
    // start the recursive search.
    return helper (i, vals, lowerInit, upperInit);
  }

  public static int
    helper (int i, int[] vals, int lowerBound, int upperBound)
      throws Exception
  {
    /*
     * "Loop" Invariants: lowerBound < upperBound; if this is not the case, then
     * the val is not contained in this array.
     * 
     * Base case:
     */
    if (lowerBound > upperBound)
      {
        throw new Exception ("Item not contained in array."); // item not found
      } // if low > high

    /*
     * Otherwise, we can set the new mid-point, which is halfway between the
     * lower bound and the upper bound.
     */
    int midPoint = (lowerBound + upperBound) / 2;

    /*
     * Then we check to see whether the integer for which we are searching is
     * less than the midpoint, greater than it, or equal to it.
     */
    if (vals[midPoint] < i)
      {
        // Set the lowerbound to midpoint + 1, we discussed this in class
        return helper (i, vals, midPoint + 1, upperBound);
      } // if value at midpoint is less than i
    else if (vals[midPoint] > i)
      {
        // keep the current lowerbound, set the upperbound to the midpoint - 1
        return helper (i, vals, lowerBound, midPoint - 1);
      } // else if the value at midpoint is greater than i
    else
      {
        return midPoint;
      } // else: value at midpoint equals
  } // int helper(int, int [], int, int)
}
