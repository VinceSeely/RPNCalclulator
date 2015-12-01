/**
Creates a RpnEvaluator class, to evaluate post fix Fraction operations.
Allows a user to input a post fix formated Fraction operation, then 
solves the problem, using a Stack and a Queue, then outputs the answer,
and the intermediate results.

@author Shane Hendricks
*/

import java.util.Scanner;

public class RpnEvaluator 
{
   private Scanner stdin;
   private final Stack myStack = new Stack();
   private final Queue myQueue = new Queue();
   private String myStringTok;
   private Fraction answer;
   private int num;
   private boolean validInput, opDone;
   
   public RpnEvaluator()
   {
      // Does Nothing
   }
   
   public RpnEvaluator(String initStr)
   {
      myStringTok = initStr;
      processToken(myStringTok);
   }
   
   /**
   Runs the program, taking a user inputed Fraction expression. 
   Reads in each String token, and preform appropriate action.
   @throws java.io.IOException
   */
   public void run() throws java.io.IOException
   {
      stdin = new Scanner(System.in);
      processToken();
      
   }
   
   public void processToken()
   {
      String input;
      int numExpressions = 1;
      while(stdin.hasNext())
      {
         validInput = true;
         input = stdin.next();
         System.out.print("Expression " + numExpressions + " is: ");
         while(!input.equals("#"))
         {
            opDone = false;
            if(validInput)
               processToken(input);
            input = stdin.next();
            num++;
         }
         output();
         numExpressions++;
         num = 0;
         myStack.clear();
         myQueue.clear();
      }
      System.out.println("Normal Termination of Program 3.");
   }
   
   /**
   Evaluates the user inputed Token and determines if it is
   a Fraction or a operator.
   @param input is the Token to evaluate.
   */
   public void processToken(String input)
   {
      Object one, two;
      if(isOperator(input))
      {
         if(!myStack.isEmpty())
         {
            one = myStack.pop();
            if(!myStack.isEmpty())
            {
               two = myStack.pop();
               evalOperator(input.charAt(0), one, two);
            }
            else 
               validInput = false;
         }
         else
            validInput = false;
         System.out.print(input);
         
      }
      else if(input.charAt(0) == '(')
      {
         myStack.push(new Fraction(input));
         System.out.print(new Fraction(input).toString());
         validInput = true;
      }
      else
      {
         System.out.print(input);
         validInput = false;
      }
   }
   
   
   public Queue getQueue()
   {
      return myQueue;
   }
   
   public Stack getStack()
   {
      return myStack;
   }
   
   
   /**
   Outputs the expression after all Tokens were evaluated.
   Outputs the value and the intermediate results.
   */
   private void output()
   {
      if(validInput && (opDone || num == 1))
         System.out.print("\nThe value is: " + myStack.pop());
      else
         System.out.print("\nInvalid Expression");
         
      System.out.print("\nIntermediate results: ");
      while(!myQueue.isEmpty())
         System.out.print(myQueue.remove().toString());
      System.out.print("\n");
      
   }
   
   /**
   Determines if the Token is an operator.
   @param token to check if operator.
   @return whether the Token is an operator(true) or not(false).
   */
   private boolean isOperator(String token)
   {
      return (token.equals("+") || token.equals("-") || token.equals("*")); 
   }
   
   /**
   Evaluates the Fractions in the Stack, based on what Operator
   the user inputs, then adds that value to the Queue.
   @param operation is what operation to preform on the Fractions.
   @param one is the first Object.
   @param two is the second Object.
   */
   private void evalOperator(char operation, Object one, Object two)
   {
      Object result = null;
      if(operation == '+')
         result = ((Fraction)one).plus((Fraction)two);
      else if(operation == '-')
         result = ((Fraction)two).minus((Fraction)one);
      else if(operation == '*')
          result = ((Fraction)one).times((Fraction)two);
      myQueue.add(new Fraction((Fraction)result));
      myStack.push(new Fraction((Fraction)result));
      opDone = true;
   }
}
