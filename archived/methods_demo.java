class Car {
     
    // Instance variables (data or "state")
    String name;
    int age;   
    // Classes can contain
     
    // 1. Data
    // 2. Subroutines (methods)


    // define void func
    void bark(){
    	for(int i=0; i<3; i++){

    		System.out.println("boooo");
    	}
    }

    void sayhello(){

    	System.out.println("helo!");
    }

}
 
public class methods_demo {

	public static void main(String[] arg){

	// create the 1st object 
	Car car1 = new Car();
	car1.name = "tesla";
	car1.age = 3; 
	// run the void func method 
	car1.bark();
	car1.sayhello();


	// create the 2nd object 
	Car car2 = new Car();
	car2.name = "jeep";
	car2.age = 13; 
	// run the void func method 
	car2.bark();
	car2.sayhello();

	// print the object data 
	//System.print(car1);
	System.out.println(car1.name);
	System.out.println(car1.age);
	}

}