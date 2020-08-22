class Cat {

    private String name;
    private int age; 

    // String name;
    // int age;   

    // set up method parameter
    public void setName(String name){
        this.name = name; 
    }

    public void setAge(int age){
        this.age = age; 
    }

    public String getName(){

        return name; 
    }

    public int getAge(){

        return age; 
    }

    // set up method parameter
    public void setInfo(String name, int age){

        setName(name);
        setAge(age);
    }

    // int getAge(){

    // 	return age; 
    // }

    // String getName(){

    // 	return name; 
    // }

}
 
public class methods_parameters_demo {

	public static void main(String[] arg){

        Cat cat1 = new Cat();
        // set up name, age 
        cat1.setName("TOM");
        cat1.setAge(1);

        System.out.println(cat1.getName());
        System.out.println(cat1.getAge());

        // set up name, agg via setInfo
        cat1.setInfo("JERRY", 10);

        System.out.println(cat1.getName());
        System.out.println(cat1.getAge());

	}

}