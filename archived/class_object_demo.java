class Car {
     
    // Instance variables (data or "state")
    String name;
    int age;   
    // Classes can contain
     
    // 1. Data
    // 2. Subroutines (methods)
}
 
public class class_object_demo {

	public static void main(String[] arg){

	// create the 1st object 
	Car car1 = new Car();
	car1.name = "tesla";
	car1.age = 3; 

	// create the 2nd object 
	Car car2 = new Car();
	car2.name = "jeep";
	car2.age = 13; 

	// print the object data 
	//System.print(car1);
	System.out.println(car1.name);
	System.out.println(car1.age);
	}

}