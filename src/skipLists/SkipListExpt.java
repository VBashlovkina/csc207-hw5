package skipLists;

public class SkipListExpt
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
   SkipListOfStrings list = new SkipListOfStrings();
   System.out.println(list.empty());
   
   list.add("hey");
   System.out.println(list.empty());

   System.out.println(list.head.next.val);
  //System.out.println(list.toString());
   System.out.println(list.size);
   
   list.add(", world");
   System.out.println(list.empty());

   System.out.println(list.head.next.val);
   //System.out.println(list.toString());
   System.out.println(list.size);
  }

}
