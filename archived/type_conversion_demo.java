/*

credit 
https://www.geeksforgeeks.org/type-conversion-java-examples/

*/


class type_conversion_demo
{
    public static void main(String[] args)
    {   

        // -----------  demo 1  -----------
        System.out.println("-----------  demo 1  -----------");
        int i = 100; 
         
        //automatic type conversion
        long l = i; 
         
        //automatic type conversion
        float f = l; 
        System.out.println("Int value "+i);
        System.out.println("Long value "+l);
        System.out.println("Float value "+f);


        // -----------  demo 2  -----------
        System.out.println("-----------  demo 2  -----------");
        double d = 100.04; 
         
        //explicit type casting
        long j = (long)d;
         
        //explicit type casting 
        int k = (int)j; 
        System.out.println("Double value "+d);
         
        //fractional part lost
        System.out.println("Long value "+j); 
         
        //fractional part lost
        System.out.println("Int value "+k); 

        // -----------  demo 3  -----------
        System.out.println("-----------  demo 3  -----------");
        byte b = 42; 
        char c = 'a'; 
        short s = 1024;
        int x = 50000;
        float y = 5.67f;
        double z = .1234;
         
        // The Expression
        double result = (y * b) + (x / c) - (z * s);
         
        //Result after all the promotions are done
        System.out.println("result = " + result);






    }


}
