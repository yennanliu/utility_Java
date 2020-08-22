public class Test {

   public static void main(String args[]) {
      Integer x = 5; // boxes int to an Integer object
      x =  x + 10;   // unboxes the Integer to a int
      System.out.println(x); 

       int [] numbers = {10, 20, 30, 40, 50,60};
       for(int y : numbers ) {
       	 x =  y + 1 ; 
         System.out.print( x );
         System.out.print(",");
      }
   }
}