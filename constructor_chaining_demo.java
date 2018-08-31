// credit 
// https://www.geeksforgeeks.org/constructor-chaining-java-examples/

// Java program to illustrate Constructor Chaining
// within same class Using this() keyword
// and changing order of constructors
class constructor_chaining_demo
{
    // default constructor 1
    constructor_chaining_demo()
    {
        System.out.println("default");
    }
 
    // parameterized constructor 2
    constructor_chaining_demo(int x)
    {
        // invokes default constructor
        this();
        System.out.println(x);
    }
 
    // parameterized constructor 3
    constructor_chaining_demo(int x, int y)
    {
        // invokes parameterized constructor 2
        this(5);
        System.out.println(x * y);
    }
 
    public static void main(String args[])
    {
        // invokes parameterized constructor 3
        new constructor_chaining_demo(8, 10);
    }
}