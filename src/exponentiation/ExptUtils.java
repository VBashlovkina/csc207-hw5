package exponentiation;

public class ExptUtils
{
  /**
   * Compute x^n.
   * 
   * @pre n >= 1.
   */
  public static double expt(double x, int n)
  {
    //double result = x;
    int i = n;
    boolean odd = (n % 2 == 1);
    double temp = x;
    //deal with special cases
    if (n == 0)
      return 1;
    if (n == 1)
      return x;
    if (odd)
      i--;
    
    while (i > 1)
      {
        if (i % 2 == 0)// double the power
          {
            temp *= temp;
            i /= 2;
          }// if even
        else /*if (i % 2 == 1 && i - 1 >= 0)*/ // increment the power
          {
            temp *= x;
            i--;// decrement i
          }// if odd
      }// while i > 0
    if (odd)
      temp *= x;
    return temp;
  } // expt(double, int)

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
