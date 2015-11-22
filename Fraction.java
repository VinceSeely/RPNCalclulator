package RPNCalclulator;




/**
 * this is a class that creates a fraction that is at a fixed size
 * @author vince
 */

import java.util.StringTokenizer;

public class Fraction
{
   private int numerator, denominator;
   
   /**
    * sets equal to zero with out a zero denominator.
    */
   public Fraction()
   {
      // Set numerator to 0, denominator to 1
      this.numerator = 0;
      this.denominator = 1;
   }
   
   /**
    * takes a string and makes a fraction out of the string
    * @param FractionString is the string that is going to be made a fraction
    */
   public Fraction ( String FractionString )
   {
      FractionString = FractionString.replace("(", "");
      FractionString = FractionString.replace(")", "");
      StringTokenizer st = new StringTokenizer ( FractionString, "/" );
      numerator = Integer.parseInt(st.nextToken());
      denominator = Integer.parseInt(st.nextToken());
      reduce();
   }
   /**
    * sets numerator and denominator to custom values and reduces fraction
    * @param numer set numerator equal to
    * @param denom set denominator equal to
    */
   public Fraction (int numer, int denom)
   {
      this.denominator = denom;
      this.numerator = numer;
      reduce();
   }
   
   /**
    * Copy constructor copies Fraction x to a new class.
    * @param x fraction that will  be copied to this object
    */
   public Fraction(Fraction x)
   {
      this.numerator = x.numerator;
      this.denominator = x.denominator;
   }

   /**
    * checks to see if another object is equal to this one
    * @param x is the object we are comparing against
    * @return true if it is equal false if not equal
    */
   @Override
   public boolean equals(Object x)
   {
      boolean retval = false;
      
      if (x instanceof Fraction)
      {
         Fraction z = (Fraction) x;
         retval = z.numerator == this.numerator &&
                 z.denominator== this.denominator;
      }
      
      return retval;
   }
   
   /**
    * adds fraction x to this fraction
    * @param x fraction that is being added
    * @return the sum is sent back
    */
   public Fraction add(Fraction x)
   {
      int numer1 = this.numerator;
      int numer2 = x.numerator;
      int denom1 = this.denominator;
      int denom2 = x.denominator;
      numer1 *= denom2;
      numer2 *= denom1;
      denom1 *= denom2;
      numer1 += numer2;
      Fraction retval = new Fraction(numer1, denom1);
      return retval;
   }   
   
   /**
    * multiplies this fraction by fraction x
    * @param x fraction that is being multiplied
    * @return the product is sent back
    */
   public Fraction multiply(Fraction x)
   {
      int numer = this.numerator * x.numerator;
      int denom = this.denominator * x.denominator;
      Fraction retval = new Fraction(numer, denom);
      return retval;
   }
   
   /**
    * subtract fraction x from this fraction.
    * @param x fraction that is being taken away from this fraction.
    * @return the total is returned
    */
   public Fraction subtract(Fraction x)
   {
      int numer1 = this.numerator;
      int numer2 = x.numerator;
      int denom1 = this.denominator;
      int denom2 = x.denominator;
      numer1 *= denom2;
      numer2 *= denom1;
      denom1 *= denom2;
      numer1 -= numer2;
      Fraction retval = new Fraction(numer1, denom1);
      return retval;
   }
   
   /**
    * Overrides the toString method of the Object class.
    * @return numerator/denominator
    */
   @Override
   public String toString()
   {
      return "(" + this.numerator + "/" + this.denominator + ")";
   }
   /**
    * reduces the fraction.
    */
   private void reduce()
   {
      int lowest = Math.min(Math.abs(numerator), Math.abs(denominator));
      int highest = Math.max(Math.abs(numerator), Math.abs(denominator));
      
      while (lowest != 0)
      {
         int temp = lowest;
         lowest = highest % lowest;
         highest  = temp;
      }
      
      this.numerator /= highest;
      this.denominator /= highest;
      if (this.denominator < 0)
      {
         this.numerator *= -1;
         this.denominator *=  -1;
      } 
         
   }
   /**
    * this is the testbed main
    * @param args 
    */
   public static void main ( String args[] ) 
   {
      Fraction c1 = new Fraction();
      System.out.println(c1);
      Fraction c2 = new Fraction(4 ,2);
      Fraction c3 = new Fraction(c2);
      Fraction c4 = new Fraction ("40/-50");
      Fraction c2Plusc3 = new Fraction (4,1);
      Fraction c2timesc1 = new Fraction (0,1);
      System.out.println("c3 " + c3);
      System.out.println("c4 " + c4);
      System.out.println("c1 " + c1);
      System.out.println("c2 " + c2);
      System.out.println("c2 * c1 " + c2.multiply(c1) + 
              (c2timesc1.equals(c2.multiply(c1))));
      System.out.println("c2 + c3 "+c2.add(c3) + 
              (c2Plusc3.equals(c2.add(c3))));
      System.out.println("c2 - c4 " + c2.subtract(c4));
   }

}