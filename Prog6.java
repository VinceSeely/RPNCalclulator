
public class Prog6
{
   /**
   Runs RpnEvaluator.
   @param args  is unused
   */
   public static void main (String args[])
   {
      Prog6Frame frame = new Prog6Frame();
      frame.setVisible(false);
      try
      {
         RpnEvaluator rpne = new RpnEvaluator();
         if(args.length == 1)
            rpne.run();
         else if(args.length == 0)
            frame.setVisible(true);
      }
      catch (Exception e)
      {
         System.out.println("Program Error!");
      }
   }
}