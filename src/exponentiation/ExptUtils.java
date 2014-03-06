package exponentiation;

public class ExptUtils
{
  /**
   * Compute x^n.
   * 
   * @pre n >= 1.
   * @post n and x are unchanged
   * @returns x^n
   * 
   * Invariance:
   * x^n >= temp >= x
   * n >= i >= 1
   */
  public static double expt(double x, int n)
  {
    int i = n;
    boolean odd = (n % 2 == 1);
    double temp = x;

    // deal with special cases
    if (n == 0)
      return 1;
    if (n == 1)
      return x;
    //if n is odd, cheat:
    //make it even and deal with the consequences later
    if (odd)
      i--;

    while (i > 1)
      {
        if (i % 2 == 0)
          {
            // double the power
            temp *= temp;
            // divide i by 2
            i /= 2;
          }// if even
        else
          // if odd
          {
            // increment the power
            temp *= x;
            // decrement i
            i--;
          }// if odd
      }// while i > 0
    
    //address the cheating
    if (odd)
      temp *= x;
    return temp;
  } // expt(double, int)

}// ExptUtils class
