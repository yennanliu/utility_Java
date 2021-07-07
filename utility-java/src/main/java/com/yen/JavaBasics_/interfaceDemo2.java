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

// *** define LandAnimal interface, inherit the Animal interface
interface LandAnimal extends Animal{
    void run();
}

// *** class Dog implement interface LandAnimal
class Dog implements LandAnimal{
    // implement breathe method
    public void breathe(){
        System.out.println("the dog is breathing");
    }
    // implement run method
    public void run(){
        System.out.println("the dog is running");
    }
}

public class interfaceDemo2{
    public static void main(String[] args){
        // run
        // via interface call method 
        System.out.println(Animal.getID());
        Dog dog = new Dog();
        System.out.println(dog.ID);
        dog.breathe();
        dog.getType("dog type");
        dog.run();
    }
}