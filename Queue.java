/**
Creates a Queue class, that allows Objects to be added to the Queue,
or removed and returned. Can check if a Queue is either full, or
empty, and adds and removes Objects to the rear of the Queue.

@author Shane Hendricks
*/
public class Queue // Student must properly comment

{
   private Node queue;
   
   /**
   Creates a Queue Object, with a size of SIZE.
   */
   public Queue()
   {
   }
   
   /**
   Adds an element to the rear of the Queue.
   @param x is the object to add.
   */
   public void add ( Object x )
   {
      if ( queue == null )
         queue = new Node( x, null );
      else
      {
         Node p = queue;
         while ( p.next != null )
            p = p.next;
         p.next = new Node( x, null );
      }

   }
   
   /**
   Removes the Object at the rear of the Queue.
   @return the Object at the rear.
   */
   public Object remove()
   {
      if ( queue == null )
         return queue.info;
      else
      {
         Node p = queue;
         Object x;
         while ( p.next != null )
            p = p.next;
         x = p.info;
         
         if ( queue.next == null )
            queue = null;
         else
         {       
            Node q = queue;
            while ( q.next.next != null )  
               q = q.next;
            q.next = null;  
         }
         return x;
      }
   }

   public boolean isEmpty()
   {
      return queue == null;
   }
   
   public void clear()
   {
      queue = null;
   }
   
   /**
   Creates a test-bed main for the Queue class.
   @param args is unused.
   */
   public static void main(String [] args)
   {
      Queue queue = new Queue();
      
      queue.add("Hello");
      queue.add("Goodbye");
      System.out.println(queue.remove().toString());
      System.out.println(queue.remove().toString());
   }
}
