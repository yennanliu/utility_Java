class Animal{
    void shout(){
        System.out.println("the Animal is shouting");
    }
}

// Dog extends from Animal
class Dog extends Animal{
    // rewrite from shout
    // -> need to have
    // -> 1. same method name
    // -> 2.same arg (var)
    // -> 3. same return type
    void shout(){
        System.out.println("whof whof .....");
    }
    void Dogshout(){
        System.out.println("Dogshout : whof .....");
    }
}

public class ReWrite{
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.shout();
        dog.Dogshout();
    }
}