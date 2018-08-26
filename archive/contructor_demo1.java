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







    }
}








