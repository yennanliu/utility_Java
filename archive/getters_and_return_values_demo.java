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

    int calculateYearleft(){

    	int yearsleft = 100 - age;
    	return yearsleft; 
    }

    int getAge(){

    	return age; 
    }

    String getName(){

    	return name; 
    }

}
 
public class getters_and_return_values_demo {

	public static void main(String[] arg){

	// create the 1st object 
	Car car1 = new Car();
	car1.name = "tesla";
	car1.age = 3; 
	// run the func get year
	int years =  car1.calculateYearleft();
	System.out.println("Years left : " +  years); 

	int age = car1.getAge();
	String name = car1.getName();

	System.out.println("NAME IS : " +  name); 
	System.out.println("AGE IS : " +  age); 

	// print the object data 
	//System.print(car1);
	//System.out.println(car1.name);
	//System.out.println(car1.age);
	}

}