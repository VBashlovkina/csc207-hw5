package skipLists;

public class ListObject
{
  /*
  * ListObjects can be used as nodes of SkipListsOfStrings
  */
  
  //Fileds
  int level;
  ListObject[] pointers; //array of pointers to the next node at each level
  String val; // the string contained by the node
  ListObject next; //pointer to the immeadiate next node
  
   //Constructors
  /**
   * Used for subunits of ListObjects
   * @papam str
   */
  public ListObject(String str)
  {
    this.val = str;
    this.next = null;
  }//ListObject(String)
  
  /**
   * Constructor for multi-level ListObjects
   * @param lvl, the desired level of the node
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
