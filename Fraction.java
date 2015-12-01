/**
Class used to create Fraction objects.
This class is used to create Fractions from user input, 
add, subtract, multiply, and reduce Fractions.
@author Shane Hendricks
 */
import java.util.StringTokenizer;

public class Fraction
{
   private int numerator, denominator;
   
   /**
   Creates a default Fraction with a numerator of zero, and a
   denominator of 1.
   */
   public Fraction()
   {
      numerator = 0;
      denominator = 1;
   }
   
   /**
   Creates a Fraction based on user input for the numerator
   and the denominator.
   @param nu is the numerator value
   @param de is the denominator value
   */
   public Fraction(int nu, int de)
   {
      numerator = nu;
      denominator = de;
      Reduce();
   }
   
   /**
   Creates a Fraction from a String.
   @param FractionString is the String to be made into a fraction.
   */
   public Fraction(String FractionString)
   {
      StringTokenizer st = new StringTokenizer(FractionString, "/()");
      numerator = Integer.parseInt(st.nextToken());
      denominator = Integer.parseInt(st.nextToken());
      Reduce();
   }
   
   /**
   Creates a Fraction that is a copy of another Fraction
   @param f1 is the Fraction to be copied.
   */
   public Fraction(Fraction f1)
   {
      numerator = f1.numerator;
      denominator = f1.denominator;
      Reduce();
   }
   
   /**
   Used to reduce a fraction to its simplest form.
   */
   private void Reduce()
   {
      int lowest;
      int highest;
      int temp;
      if(Math.abs(numerator) > Math.abs(denominator))
      {
         highest = numerator;
         lowest = denominator;
      }
      else
      {
         highest = denominator;
         lowest = numerator;
      }
      while(lowest != 0)
      {
         temp = lowest;
         lowest = highest % lowest;
         highest = temp;
      }
      numerator /= highest;
      denominator /= highest;
      if(denominator < 0)
      {
         numerator *= -1;
         denominator *= -1;
      }
      
   }
   
   /**
   Adds two fractions together, and returns their sum.
   @param f1 is the fraction to be added to the current instance
   @return A Fraction that is the sum of the two Fractions
   */
   public Fraction plus(Fraction f1) 
   {
      Fraction sum = new Fraction();
      sum.denominator = denominator * f1.denominator;
      sum.numerator = numerator * f1.denominator 
         + denominator * f1.numerator;
      sum.Reduce();
      return sum;
   }
   
   /**
   Subtracts two fractions from each other, and returns their 
   difference.
   @param f1 is the fraction to be subtracted to the current instance
   @return A Fraction that is the difference of the two Fractions
   */
   public Fraction minus(Fraction f1)
   {
      Fraction diff = new Fraction();
      diff.denominator = denominator * f1.denominator;
      diff.numerator = numerator * f1.denominator 
            - denominator * f1.numerator;
      return diff;
   }
   
   /**
   Multiplies two fractions together, and returns their product.
   @param f1 is the fraction to be multiplied to the current instance
   @return A Fraction that is the product of the two Fractions
   */
   public Fraction times(Fraction f1)
   {
      Fraction product = new Fraction();
      product.denominator = denominator * f1.denominator;
      product.numerator = numerator * f1.numerator;
      return product;
   }
   
   /**
   Determines if the two Fractions have equal values.
   @param x is the object we want to check
   @return A boolean of if they are equal to one another.
   */
   @Override 
   public boolean equals(Object x)
   {
      if(x instanceof Fraction)
      {
         if(toString().equals(x.toString()))
            return true;
      }
      
      return false;
   }
   
   /**
   Makes the Fraction a String for easy output.
   @return A String representation of the Fraction.
   */
   @Override 
   public String toString()
   {
      return "(" + numerator + "/" + denominator + ")";
   }
   
   /**
   A simple test-bed main for the Fraction class.
   @param args is unused
   */
   public static void main ( String args[] ) 
   {
      Fraction c1 = new Fraction();
      Fraction c2 = new Fraction(c1);
      Fraction c3 = new Fraction(3,6);
      Fraction c4 = new Fraction("(3/4)");
      
      System.out.println("Fraction c1: " + c1.toString());
      System.out.println("Fraction c2: " + c2.toString());
      System.out.println("Fraction c3: " + c3.toString());
      System.out.println("Fraction c4: " + c4.toString());
      
      if(c1.equals(c2))
         System.out.println("Fractions are equal, Test Passed");
      
      if(!c1.equals(c3))
         System.out.println("Fractions not equal, Test Passed");
      
      System.out.println("c3 + c4 = " + c3.plus(c4).toString());
      System.out.println("c3 - c4 = " + c3.minus(c4).toString());
      System.out.println("c3 * c4 = " + c3.times(c4).toString());
   }

}
