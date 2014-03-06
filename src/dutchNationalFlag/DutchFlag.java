package dutchNationalFlag;

/*
 * @author Graeme Boy
 * @author Vasilisa Bashlovkina
 *  
 * Javadoc for dnf provided by SamR -
 * http://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2014
 * S/assignments/current.html
 */
public class DutchFlag
{
  /**
   * Rearrange vals so that red values precede white values and white values
   * precede blue values.
   * 
   * 
   * @post Exist P and Q, 0 <= P <= Q <= vals.length, s.t. For all i, 0 <= i <
   *       P, classifier.classify(vals[i]) < 0 For all i, P <= w < Q,
   *       classifier.classify(vals[i]) == 0 For all i, Q <= i < vals.length,
   *       classifier.classify(vals[i]) > 0 Values have neither been added to
   *       nor removed from vals; the new vals is a permutation of the original.
   */
  public static void
    dnf (String[] vals, StringClassifier classifier)
  {
    /*
     * Sort the array using some tactics we learned during our binary search
     * class discussion.
     * 
     * 
     * As i increases, we can put reds to the front and leave all whites in the
     * center. Therefore, the "r" invariant from our class discussion is
     * redundant.
     * 
     * Invariants: the unknown level, i, is always lower than our upper bound,
     * until we have solved the sort.
     */
    int i = 0; // this is our "unknown" level
    int lowerBound = 0;
    int upperBound = vals.length - 1;
    try
      {
        while (i <= upperBound)
          {
            int color = classifier.classify (vals[i]);
            switch (color)
              {
              // Now we just need to figure out how to switch them.
                case 0: // white; stays in middle.
                  i++;
                  break;
                case -1: // red; goes to beginning.
                  // Take the value at the beginning, and switch it with this
                  // one.
                  switchValues (vals, i, lowerBound);
                  // Increment the appropriate values
                  lowerBound++;
                  i++;
                  break;
                case 1: // blue; goes to end.
                  switchValues (vals, i, upperBound);
                  // Decrement and increment the appropriate values
                  upperBound--;
                  break;
              } // switch (String)
          } // while (i <= upperBound)
      } // try
    catch (Exception e)
      {
        // One of the values was unknown!
        System.err.println ("An unknown color was given as input.");
      }
  } // dnf(String[], StringClassifier)

  /*
   * Switches two values in an array of strings
   * 
   * @pre length of vals > origin and target
   * 
   * @post vals[target] = vals[origin], and vals[origin] = vals[target]
   */
  static void
    switchValues (String[] vals, int origin, int target)
  {
    String temp = vals[target];
    vals[target] = vals[origin];
    vals[origin] = temp;
  }
}
