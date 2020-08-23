class Animal{
    String name;
    void shout(){
        System.out.println("the Animal is shouting");
    }
}

// Dog extends from Animal
class Dog extends Animal{
    public void printName(){
        System.out.println("name = " + name);
    }
}

public class Extends{
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.name = "Dalmatian";
        // method from Dog
        dog.printName();
        // method from Animal
        dog.shout();
    }
}