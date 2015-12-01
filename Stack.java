/**
Creates a Stack class, that allows Objects to be added to the Stack,
or removed and returned. Can check if a Stack is either full, or
empty, and adds and removes Objects from the top of the Stack.

@author Shane Hendricks
*/
public class Stack 

{
   private Node stack;
   
   /**
   Creates a Stack Object, with a size of STACK_SIZE.
   */
   public Stack ()
   {
   }
   
   /**
   Adds an Object to the top of the Stack, then increments top.
   @param x is the Object to add to the Stack.
   */
   public void push ( Object x )
   {
      stack = new Node(x, stack);
   }
   
   /**
   Decrements top, then returns the Object at that position.
   @return the Object at top
   */
   public Object pop()
   {
      Object x = stack.info;
      stack = stack.next;
      return x;
   }
   
   public boolean isEmpty()
   {
      return stack == null;
   }
   
   public void clear()
   {
      stack = null;
   }
   
   public static void main(String [] args)
   {
      Stack s = new Stack();
      System.out.println(s.isEmpty());
      s.push("HELLO");
      s.push("No");
      System.out.println(s.pop().toString());
      System.out.println(s.pop().toString());
   }
}
