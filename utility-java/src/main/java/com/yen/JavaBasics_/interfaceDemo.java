// define interface : Animal
interface Animal{
    int ID = 1;
    void breathe();
    // define a default method 
    default void getType(String type){
        System.out.println("this is Animal is type : " + type);
    }

    // define a static method
    static int getID(){
        return Animal.ID;
    }
}

// class Dog implement interface Animal
class Dog implements Animal{
    // implement breathe method
    public void breathe(){
        System.out.println("the dog is breathing");
    }
}

public class interfaceDemo{
    public static void main(String[] args){
        // run
        // via interface call method 
        System.out.println(Animal.getID());
        Dog dog = new Dog();
        System.out.println(dog.ID);
        dog.breathe();
        dog.getType("dog type");
    }
}