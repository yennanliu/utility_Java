// example 1
abstract class Animal {
    // define abstract method : shout 
    public abstract void shout(); 
}

// class Dog inherit abstract class Animal
class Dog extends Animal {
    // implement abstract method : shout
    public void shout(){
        System.out.println("whof whof ....");
    }

}

// example 2 
abstract class Car {
    public abstract void start();
    public abstract void stop();
}

class Benz extends Car {
    // need to implement ALL abstract methods in abstract class
    public void start(){
        System.out.println("car start ....");
    }

    public void stop(){
        System.out.println("car stop ....");
    }
}

public class abstractDemo {
    public static void main(String[] args){
        // run 1 
        Dog dog = new Dog();
        dog.shout();

        // run 2
        Benz benz = new Benz();
        benz.start();
        benz.stop(); 
    }

}