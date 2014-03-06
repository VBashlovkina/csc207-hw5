package skipLists;
import java.util.Comparator;


public class StringComparator
implements Comparator<String>

{
  /**
   * Custom comparator for strings in SkipListOfStrings
   * 
   * NIL is the biggest string
   * LIN is the smallest string
   * For all String str != "NIL", !="LIN"
   * str<"NIL"
   * str>"LIN"
   */
 
 /**
  * @param s1 and s2, strings to compare
  * @returns
  * 0 if s1==s2
  * -1 if s1<s2
  * 1 if s1>s2
  */ 
  @Override
  public int compare(String s1, String s2)
  {
    if (s1.equals(s2))
      return 0;
    if ((s1.compareTo("NIL") == 0) || (s2.compareTo("LIN") == 0))
      return 1;
    if ((s2.compareTo("NIL") == 0) || (s1.compareTo("LIN") == 0))
     return -1;
    if (s1.compareTo(s2) < 0)
      return -1;
    else return 1;
  }//compare(String, String)

}//StringComparator class
