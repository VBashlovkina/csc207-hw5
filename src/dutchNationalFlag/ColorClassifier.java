package dutchNationalFlag;

/**
 * Classify strings as red (fewer than 5 characters), white (5 characters), or
 * blue (more than 5 characters).
 * 
 * @author Graeme Boy
 * @author Vasilisa Bashlovkina
 */
public class ColorClassifier
    implements
      StringClassifier
{
  
  /*
   * @see DutchNationalFlag.StringClassifier#classify(java.lang.String)
   * 
   * @pre val must be in one of the following languages: English, Dutch,
   *      Afrikaans, German, Latin, Spanish, French, or Xhosa.
   */
  public int
    classify (String val) throws Exception
  {
    String[][] colors = new String[][] { 
    { 
      "red", "rood", "rooi", "rot", // Germanic. English, Dutch, Afrikaans, German.
      "ruber", // Latin
      "rojo", "rouge", // Descending from Latin. Spanish, French
      "bomvu" // African languages. Xhosa.
    },
    { 
      "white", "wit", "weiss", // Dutch = Afrikaans; cannot produce B char for german.
      "albus",
      "blanco", "blanc",
      "mhlophe"
    },
    { 
      "blue", "blauw", "blou", "blau", 
      "caeruleus", // literally meaning sky-like?
      "azul", "bleu",
      "luhlaza"
    } 
  };

    for (int i = 0; i < colors.length; i++)
      { // for all colors (there should be 3, in this instance)
        for (String color : colors[i])
          { // for each language
            if (val.toString ().equalsIgnoreCase (color))
              { // compare the colors
                return i - 1; // return the appropriate integer.
              }  // if val equals the color
          } // for each colors as color
      } // for each i in range the length of colors
    throw new Exception ("Color unknown");
  } // classify
} // class SimpleStringClassifier