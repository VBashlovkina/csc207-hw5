package skipLists;

import java.util.Arrays;
import java.util.Random;

public class SkipListOfStrings
    implements
      SetOfStrings
{
  public static final int MIN_SIZE = 16;
  public static final StringComparator sC = new StringComparator();

  // Fields
  ListObject head;
  ListObject tail;
  int size;
  int maxLevel;

  // Constructor
  /**
   * Create an empty SkipList
   * 
   * @param n
   */
  public SkipListOfStrings()
  {
    this.size = 0;
    this.maxLevel = 1;
    // this.maxLevel = (int) Math.log((double) n / (int) Math.log(2));
    head = new ListObject(maxLevel, "LIN");
    tail = new ListObject(maxLevel, "NIL");
    head.next = tail;
    head.pointers[0].next = tail.pointers[0];
  }// SkipListOfStrings()

  public SkipListOfStrings(int n)
  {
    this.size = n;
    this.maxLevel = (int) Math.log((double) n / (int) Math.log(2));
    head = new ListObject(maxLevel, "LIN");
    tail = new ListObject(maxLevel, "NIL");
    for (int i = 0; i < maxLevel; i++)
      head.pointers[i].next = tail.pointers[i];
  }// SkipListOfStrings()

  /*
   * public void forward() { this.head = this.head.next; }//forward()
   */
  public boolean empty()
  {
    return this.head.next.val.equals(this.tail.val);

  }// empty()

  public int pickLevel()
  {
    Random gen = new Random();
    for (int i = 0; i < this.maxLevel; i++)
      {
        if (gen.nextInt(this.maxLevel) < this.maxLevel / 2)
          return i;
      }// for iterating through levels
    return this.maxLevel;
  }// pickLevel()

  /**
   * make a findPlace
   * 
   * @param str
   * @return list of this.maxLevel objects such that o.val<str but
   *         o.next.val>=str
   */
  public ListObject[] findPlace(String str)
  {
    ListObject x = this.head;
    ListObject[] previous = new ListObject[this.maxLevel];
    for (int i = this.maxLevel - 1; i >= 0; i--)
      {

        // as long as it doesn't overshoot, move on
        while (sC.compare(x.next.pointers[i].val, str) < 0)
          x = x.next;
        // when the next element overshoots, the current element potentially
        // precedes the str we are looking for
        previous[i] = x.pointers[i];
      }// for iterating through levels
    return previous;
  }

  public String toString()
  {
    String result = "";
    ListObject x = this.head.next;
    int i = 0;
    while (sC.compare(x.val, "NIL") < 0)
      {
        result = result + ", " + i + ": " + x.val;
        i++;
      }// while
    return result;
  }// toString()

  @Override
  public boolean contains(String str)
  {
    ListObject x = this.head;
    // check if empty
    if (this.empty())
      return false;

    for (int i = this.maxLevel - 1; i >= 0; i--)
      {
        if (sC.compare(str, x.next.pointers[i].val) == 0)
          return true;
        while (sC.compare(x.next.pointers[i].val, str) < 0)
          x = x.next;
      }// for iterating levels

    return false;
  }// contains(String)

  @Override
  public void add(String str)
  {
    this.size += 1;
    // the optimal maxLevel is log(base 2) of size
    this.maxLevel = (int) (Math.log(this.size) / Math.log(2));

    if (this.maxLevel == 0)// max level has to at least 1
      this.maxLevel++;

    this.head.pointers = new ListObject[this.maxLevel];
    Arrays.fill(this.head.pointers, new ListObject("LIN"));

    this.tail.pointers = new ListObject[this.maxLevel];
    Arrays.fill(this.tail.pointers, new ListObject("NIL"));

    ListObject[] prev = findPlace(str);

    int newLevel = this.pickLevel();

    ListObject toAdd = new ListObject(newLevel, str);
    if (this.empty())
      {
        this.head.pointers[0].next = toAdd.pointers[0];
        toAdd.pointers[0].next = this.tail.pointers[0];
        toAdd.next = this.tail;
        this.head.next = toAdd;
      }// the initial list is empty
    else
      {

        int prevLen = prev.length - 1;
        for (int i = newLevel - 1; i >= 0; i--)
          {
            System.out.println(prevLen - i);
            System.out.println(prev[0].val);
            toAdd.pointers[i].next = prev[prevLen - i].pointers[i].next;
            prev[prevLen - i].pointers[i].next = toAdd.pointers[i];
          }// for reassigning pointers
        toAdd.next = prev[prevLen - 1].pointers[0];
        prev[prevLen - 1].next = toAdd.pointers[0];
      }
  }// add(String)

  @Override
  public void remove(String str)
  {
    this.maxLevel =
        (int) Math.log((double) (this.size - 1) / (int) Math.log(2));
    ListObject x = this.head;
    for (int i = this.maxLevel; i > 0; i--)
      {
        while (sC.compare(x.next.pointers[i].val, str) < 0)
          x = x.next;
      }// for iterating levels
    x = x.next;
    // if (sC.compare(x.val, str) == 0)
    // nvm refer to article
  }
}
