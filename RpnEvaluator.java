package RPNCalclulator;

import java.io.File;
import java.util.Scanner;

/**
 * This Class evaluates RPN equations with fractions
 * @author vince
 */
public class RpnEvaluator 
{
   
   private Scanner stdin;
   private Stack fractions;
   private int numEvaluated;
   private Queue intermidiate;
   /**
    * the only public method that is there to allocate where things will be 
    * happening in this class in order to calculate RPN equations
    */
   public void run()
   {
      stdin = new Scanner(System.in);
      String input = "";
      numEvaluated = 0;
      intermidiate = new Queue();
      fractions = new Stack();
      while ( stdin.hasNext() )
      {
         evaluate(stdin.next());    
      } 
      System.out.println("Normal Termination of Program 3. ");

   }
   
   /**
    * this will evaluate the RPN equation and see if the input is invalid
    * @param input is the first part of the input line to be evaluated in this 
    *       method
    */ 
   private void evaluate(String input)
   {
      input = input.replace(" ", "");
      boolean inputGood = true;
      String equation = "";
      while (!input.equals("#") && inputGood)
      {
         if (input.contains("/") && input.contains("("))
         {
            addElement(input);
            equation += fracString(input);
         }
         else
         {
            inputGood = calculateMath(input);
            equation += input;
         }
         input = stdin.next();
      }
      equation = equation.replace("#", "");
      System.out.println("Expression " + ++numEvaluated + " is: " + equation);
      displayOut(inputGood, equation, input);
      fractions.clear();
      intermidiate.clear();
   }
   
   /**
    * this method displays the expected output for correct inputs
    * @param inputGood it double checks to make sure that the input is 
    *          actually good
    * @param equation the equation in RPN as it stands without spaces or #
    * @param input used to make sure that it was the legit end of the string
    */
   private void displayOut(boolean inputGood, String equation, String input)
   {
      if (!inputGood || equation.equals("") && (fractions.isEmpty() || 
              intermidiate.isEmpty()))
         endRun(input);
      else
         if (!fractions.isEmpty())
         {
            Fraction tempFrac = (Fraction) fractions.pop();
            if (!fractions.isEmpty())
            {
               fractions.push(tempFrac);
               endRun("#");
            }
            else
            {
               fractions.push(tempFrac);
               displayResults();
            }
         }
      
         
   }
   
   /**
    * this method reaches the end of the line of the current input
    * @param input most recent string read by the scanner
    */
   private void endRun(String input)
   {
      while(!input.contains("#"))
         input = stdin.nextLine();
      
      System.out.print("Invalid Expression \nIntermediate results: ");
      while (!intermidiate.isEmpty())
      {
         System.out.print(intermidiate.remove());
      }
      System.out.println();
      
   }
   
   /**
    * returns the string of a fraction so that the equation string will be 
    * correct
    * @param frac the string of the fraction that may need to be simplified
    * @return a reduced fraction in the form of a string based on the string 
    *    that was entered into the method
    */
   private String fracString(String frac)
   {
      Fraction temp = new Fraction(frac);
      return temp.toString();
   }
   
   /**
    * displays the results of a valid input string and shows the final result 
    * and intermediate results
    */
   private void displayResults()
   {
      System.out.println("The value is: " + fractions.pop());
      System.out.print("Intermediate results: ");
      while (!intermidiate.isEmpty())
      {
         System.out.print(intermidiate.remove());
      }
      System.out.println();
      
   }
   
   /**
    * adds a fraction to the stack
    * @param input string that will become a fraction that is added to the 
    *    stack
    */
   private void addElement(String input)
   {
     Fraction tempFrac = new Fraction(input);
     fractions.push(tempFrac);
   }
   
   /**
    * figures out which operation is being done for the problem and then 
    * goes and figures out the output
    * @param operator this a non fraction string that is then checked to see 
    *       if it is a valid input
    * @return returns a boolean that says if it was a valid operation true 
    *    means successful and false means that it failed
    */
   private boolean calculateMath(String operator)
   {
      boolean inputGood = true;
      switch(operator)
      {
         case "+":
            inputGood = addTwo();
            break;
         case "-":
            inputGood = subtractTwo();
            break;
         case "*":
            inputGood = multiplyTwo();
            break;
         default:
            inputGood = false;
            break;
      }
      return inputGood;
   }
   
   /**
    * checks to see if all teh fractions are out of the stack except for one 
    * fraction
    * @return false if there is less than one or more than one. returns true 
    *    if there is only 1
    */
   private boolean isComplete()
   {
      boolean retval = false;
      if (fractions.isEmpty())
      {
         Fraction tempFrac = (Fraction) fractions.pop();
         if(fractions.isEmpty())
         {
            retval = true;
         }
         fractions.push(tempFrac);
      }
      return retval;
   }
   
   /**
    * takes the first two items to come off of the stack and subtracts the 
    * first from the second
    * @return true if it was able to complete false if there were not enough 
    *    fractions
    */
   private boolean subtractTwo()
   {
      boolean inputGood = true;
      if(!fractions.isEmpty())
      {
         Fraction num2 = (Fraction) fractions.pop();
         if (!fractions.isEmpty())
         {
            Fraction num1 = (Fraction) fractions.pop();
            Fraction answer = num1.subtract(num2);
            fractions.push(answer);
            intermidiate.add(answer);
         }
         else 
         {
            inputGood = false;
            fractions.push(num2);
         }
      }
      else
         inputGood = false;
      return inputGood;
   }
   
   /**
    * takes the first two items to come off of the stack and adds the 
    * first to the second
    * @return true if it was able to complete false if there were not enough 
    *    fractions
    */
   private boolean addTwo()
   {
      boolean inputGood = true;
      if(!fractions.isEmpty())
      {
         Fraction num2 = (Fraction) fractions.pop();
         if (!fractions.isEmpty())
         {
            Fraction num1 = (Fraction) fractions.pop();
            Fraction answer = num1.add(num2);
            fractions.push(answer);
            intermidiate.add(answer);
         }
         else 
         {
            inputGood = false;
            fractions.push(num2);
         }
      }
      else
         inputGood = false;
      return inputGood;
   }
   
   /**
    * takes the first two items to come off of the stack and multiplies the 
    * first by the second
    * @return true if it was able to complete false if there were not enough 
    *    fractions
    */
   private boolean multiplyTwo()
   {
      boolean inputGood = true;
      if(!fractions.isEmpty())
      {
         Fraction num2 = (Fraction) fractions.pop();
         if (!fractions.isEmpty())
         {
            Fraction num1 = (Fraction) fractions.pop();
            Fraction answer = num1.multiply(num2);
            fractions.push(answer);
            intermidiate.add(answer);
         }
         else 
         {
            inputGood = false;
            fractions.push(num2);
         }
      }
      else
         inputGood = false;
      return inputGood;
   }
}