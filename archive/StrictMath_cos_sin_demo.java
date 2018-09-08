import java.lang.*; 
  
public class StrictMath_cos_sin_demo { 
  
public static void main(String[] args) { 
  
    double num1 = 0.0;
    double num2 = 1.0; 
    double num3 = 64.6; 
    double num4 = -62.0;
    double num5 = 1.0; 
    double num6 = (45*(Math.PI))/180;
      
    /* Returns trigonometric cosine of specified 
    angle in radian*/ 
    System.out.println("----------- part 1 ------------");

    double cosValue = StrictMath.cos(num1);  
    System.out.println("The cosine of "+ 
                           num1+" = " + cosValue); 
  
    cosValue = StrictMath.cos(num2);  
    System.out.println("The cosine of "+ 
                           num2+" = " + cosValue); 
  
    cosValue = StrictMath.cos(num3);  
    System.out.println("The cosine of "+ 
                           num3+" = " + cosValue);

    System.out.println("----------- part 2 ------------");
    // declare new variable 
    double cosValue4 = StrictMath.cos(num4);
    System.out.println("The cosine of "+ 
                           num4+" = " + cosValue4); 
    double cosValue5 = StrictMath.cos(num5);  
    System.out.println("The cosine of "+ 
                           num5+" = " + cosValue5); 
    // use pre-used variable
    cosValue = StrictMath.cos(num6);   
    System.out.println("The cosine of "+ 
                           num6+" = " + cosValue);


  } 
} 




