import java.util.Date;
public class currentdate {

   public static void main(String args[]) {
      // Instantiate a Date object
      Date date = new Date();

      // display time and date
      String str = String.format("Current Date/Time : %tc", date );
      System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
      System.out.printf("%n");
	  System.out.printf(str);
	  System.out.printf("%n");
   }
}