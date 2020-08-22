
/*

credit 
http://www.runoob.com/java/java-exceptions.html
https://zh.wikibooks.org/wiki/Java/%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86

*/


import java.io.*;
public class Except_demo{
 
   public static void main(String args[]){
      try{
         int a[] = new int[2];
         //System.out.println("Access element three :" + a[1]);
         System.out.println("Access element three :" + a[3]);

      }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Exception thrown  :" + e);
      }
      System.out.println("Out of the block");
   }

   //-------------


   
}