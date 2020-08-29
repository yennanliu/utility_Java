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

public class abstractDemo {
    public static void main(String[] args){
        // run
        Dog dog = new Dog();
        dog.shout();
    }

}