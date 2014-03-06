package skipLists;

public class ListObject
{
//Fileds
  int level;
  ListObject[] pointers;
  String val;
  ListObject next;
  
 //Constructor
  /**
   * Used for subunits of ListObjects
   * do i need this??
   * 
   */
  public ListObject(String str)
  {
    this.val = str;
    this.next = null;
  }//ListObject(String)
  
  /**
   * Constructor for multi-level ListObjects
   * @param lvl
   * @param str
   */
  public ListObject(int lvl, String str)
  {
    this.level = lvl;
    this.val = str;
    this.pointers = new ListObject[lvl];
    
    for (int i = 0; i < lvl; i++)
      this.pointers[i] = new ListObject(str);
    this.next = null;
  }//ListObject(int, String)
  

}//ListObject class
