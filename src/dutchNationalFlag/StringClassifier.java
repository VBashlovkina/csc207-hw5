package dutchNationalFlag;

/**
 * @author Graeme Boy
 * @author Vasilisa Bashlovkina
 */
public interface StringClassifier
{

  /**
   * Classify val into one of three categories, which we call "red", "white",
   * and "blue" for convenience. If val is red, returns a negative number. If
   * val is white, returns zero. If val is blue, returns a positive number.
   * 
   * @throws Exception
   * @returns -1 if val is in "red" category, 0 if in "white," and 1 if in
   *          "blue"
   * 
   */
  public int
    classify (String val)
      throws Exception;
} // interface Classifier