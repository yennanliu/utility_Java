// Java Program to illustrate calling a
// no-argument constructor

/*

credit 
https://www.geeksforgeeks.org/constructors-in-java/

*/

import java.io.*;

class Geek
{
    int num;
    String name;
 
    // this would be invoked while object
    // of that class created.
    Geek()
    {
        System.out.println("Constructor called");
    }
}

class Geek2
{
    int id;
    String name;
 
    // this would be invoked while object
    // of that class created.
    Geek2(String name, int id)
    {
        System.out.println("Constructor2 called");
        this.name = name; 
        this.id = id; 
    }
}

class Geek3
{
    // constructor with one argument
    Geek3(String name)
    {
        System.out.println(" * Constructor with one " +
                      "argument - String : " + name);
    }
 
    // constructor with two arguments
    Geek3(String name, int age)
    {
 
        System.out.print("* Constructor with two arguments : " +
                " String and Integer : " + name + " "+ age);
        System.out.print(" "); 
 
    } 
    // Constructor with one argument but with different
    // type than previous..
    Geek3(long id)
    {
        System.out.println(" * Constructor with one argument : " +
                                            "Long : " + id);
    }
}

class contructor_demo1
{
    public static void main (String[] args)
    {

        // cnstructors 1 
        System.out.println("---------- cnstructors 1  ----------"); 
        // this would invoke default constructor.
        Geek geek1 = new Geek();
        // Default constructor provides the default
        // values to the object like 0, null
        System.out.println(geek1.name);
        System.out.println(geek1.num);

        // cnstructors 2 
        System.out.println("---------- cnstructors 2  ----------"); 
         // this would invoke parameterized constructor.
        Geek2 geek2 = new Geek2("adam", 1);
        System.out.println("GeekName :" + geek2.name );
        System.out.println("GeekId :" + geek2.id);

        // cnstructors 3 
        System.out.println("---------- cnstructors 3  ----------"); 
        // Constructor Overloading
        // Creating the objects of the class named 'Geek'
        // by passing different arguments
 
        // Invoke the constructor with one argument of
        // type 'String'.
        Geek3 geek3_a = new Geek3("Shikhar");
 
        // Invoke the constructor with two arguments
        Geek3 geek3_b = new Geek3("Dharmesh", 26);
 
        // Invoke the constructor with one argument of
        // type 'Long'.
        Geek3 geek3_c = new Geek3(325614567);

    }
}
