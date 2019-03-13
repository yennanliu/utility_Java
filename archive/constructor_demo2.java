// Main.java
import java.io.*;

class Test {
   int i;
   Test t;
   boolean b;
   byte bt;
   float ft;
}

class Test2 {
   int i;
   Test t;
   boolean b;
   byte bt;
   float ft;
   String str = String.format(" this is test 2 " );
   String str2 = String.format(" hello wotld " );
}

public class constructor_demo2 {
    public static void main(String args[]) {
      // cnstructors 1 
      System.out.println("---------- cnstructors 1  ----------"); 
      Test t = new Test(); // default constructor is called.
      System.out.println(t.i);
      System.out.println(t.t);
      System.out.println(t.b);
      System.out.println(t.bt);
      System.out.println(t.ft);

      // cnstructors 2 
      System.out.println("---------- cnstructors 2 ----------"); 
      Test2 t2 = new Test2();
      System.out.println(t2.i);
      System.out.println(t2.str);
      System.out.println(t2.str2);

    }
}
