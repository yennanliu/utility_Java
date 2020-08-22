public class StringDemo {

   public static void main(String args[]) {
      char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
      char[] worldArray = { 'w', 'o', 'r', 'l', 'd', '~' };
      String helloString = new String(helloArray);  
      String worldString = new String(worldArray);  
      System.out.println( helloString );
      System.out.print( " ");
      System.out.println( worldString );
   }
}