package RPNCalclulator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * this is an implementation of a queue
 * @author vince
 */
public class Queue 
{
   
   private Node list;
   private int front, rear, count;
 
   /**
    * constructor for queue that initializes the queue size to 50
    */
   public Queue ()
   {
      list = new Node (null, null);
      count = 0;
   }
   
   /**
    * checks to see if the queue is empty
    * @return true if it is empty false if it is not empty
    */
   public boolean isEmpty()
   {
      return count == 0;
   }
   
   /**
    * adds an Object to the queue
    * @param x is the Object being added to the queue
    */
   public void add(Object x)
   {
      Node p = list;
      while(p != null && p.next!=null) 
          p = p.next;
      if (p.info == null)
          p.info = x;
      else
         p.next = new Node(x, null);
     
      count++;
   }
   
   /**
    * removes an element from the queue starting at the front
    * @return the element that is being used so the user can use this element
    */
   public Object remove()
   {
      Object retval = list.info;
      count --;
      if (count != 0)
        list = list.next;
      return retval;
   }
   
   /**
    * clears the queue and sets all the values to null and sets the rear and 
    * front values to 0
    */
   public void clear()
   {
      list = new Node (null, null);
   }
   
   /**
    * test bed main
    * @param args not used
    */
   public static void main (String[] args)
   {
      Queue test = new Queue();
      String input1 = "a";
      String input2 = "b";
      String input3 = "c";
      String input4 = "d";
      String input5 = "e";
      String input6 = "f";
      System.out.println(test.isEmpty());
      test.add(input1);
      test.add(input2);
      test.add(input3);
      test.add(input4);
      test.add(input5);
      System.out.println(test.isEmpty());
      System.out.println(test.remove());
      System.out.println(test.remove());
      test.add(input6);
      test.clear();
      System.out.println(test.isEmpty());
      
   }
}
