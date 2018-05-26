
/*
credit 
https://zh.wikibooks.org/wiki/Java/%E5%88%86%E6%94%AF%E7%BB%93%E6%9E%84
*/

public class if_else_demo {
    public static void main(String args[]){
        if( 2 > 3 )                        
            System.out.println("true");	
        else
            System.out.println("false");	

        System.out.println(" end of 1) logic ----------------------  ");   


        //-----------------------

        int num = 9;
        if( num >= 0 )              
            if( num % 2 == 0 )     
                System.out.println( num + "is positive even number or 0");
            else
                System.out.println( num + "is positive odd number");
        else
            if( num % 2 == 0 )      
                System.out.println( num + "is negative even number");
            else
                System.out.println( num + "is negative odd number");

        System.out.println(" end of 2) logic ----------------------  ");   


        //-----------------------


        int A = 1, B = 2, C = 3, D = 4;
        if( D < A )
            System.out.println("D is maximum");
        else if( D < B )
                System.out.println("D is not maximum ");
            else if( D < C )
                    System.out.println("D is not maximum");
                else
                    System.out.println("D is maximum");

        System.out.println(" end of 3) logic ----------------------  ");   


    }




}



