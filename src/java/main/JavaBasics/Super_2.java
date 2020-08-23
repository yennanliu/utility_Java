// super case 2 : use super call "father class" construct method
// => 
// 1. super([arg1, arg2, ...])

// example 1 : define NO ARG and WITH ARG method in father class 
class Animal{
    // define a NO ARG method
    public Animal(){
        System.out.println("i am an Animal");
    }

    // define a WITH ARG method
    public Animal(String name){
        System.out.println("Who is the " + name + "animal ?");
    }
}

// Dog extends from Animal
class Dog extends Animal{
    // define a NO ARG construct method
    public Dog(){
    }
}

// example 2 : only define WITH ARG method in father class => need super 
class Animal2{
    public Animal2(String name){
        System.out.println("i am a " + name);
    }
}

// Cat extends from Animal
class Cat extends Animal{
    public Cat(){
        // call the "father class" (Animal2) WITH ARG method 
        super("Persian cat");
    }
}

public class Super_2{
    public static void main(String[] args){
        // test 1 
        Dog dog = new Dog();

        // test 2
        Cat cat = new Cat();
    }
}