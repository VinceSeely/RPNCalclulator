package RPNCalclulator;
/**
 * this is an implementation of a stack
 * @author vince
 */
public class Stack 
{
   
   private Node list;
   private int count;
   
   /**
    * constructor that initializes the stack to a size of 50
    */
   public Stack ()
   {
      list = new Node (null, null);
      count = 0;
   }
   
   /**
    * checks to see if the Stack is empty
    * @return true if is empty false if it is not empty
    */
   public boolean isEmpty()
   {
      return count == 0;
   }
   
   /**
    * adds an Object to the stack
    * @param x Object that is being added to the stack
    */
   public void push(Object x)
   {
      list = new Node(x, list);
      count ++;
   }
   /**
    * removes an Object from the stack
    * @return the most recently added object on the stack so the user can use 
    *    this element 
    */
   public Object pop()
   {
      Object retval = list.info;
      list = list.next;
      count --;
      return retval;
   }
   
   /**
    * clears out the stack and sets all elements equal to null and resets the 
    * count to 0
    */
   public void clear()
   {
      list = null;
      count = 0;
   }
   
   /**
    * test bed main
    * @param args not used
    */
   public static void main (String[] args)
   {
      Stack test = new Stack();
      String input1 = "a";
      String input2 = "b";
      String input3 = "c";
      String input4 = "d";
      String input5 = "e";
      String input6 = "f";
      System.out.println(test.isEmpty());
      test.push(input1);
      test.push(input2);
      test.push(input3);
      test.push(input4);
      test.push(input5);
      System.out.println(test.isEmpty());
      System.out.println(test.pop());
      System.out.println(test.pop());
      test.push(input6);
      test.clear();
      System.out.println(test.isEmpty());
      
   }
}
