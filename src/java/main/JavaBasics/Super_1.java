// super case 1 : use super call "father class" var, method
// => 
// 1. super.var 
// 2. super.methdo(arg1, arg2...)

class Animal{
    String name = "anaimal";
    void shout(){
        System.out.println("the Animal is shouting");
    }
}

// Dog extends from Animal
class Dog extends Animal{
    String name = "dog";
    // rewrite Animal shout method
    void shout(){
        // use the method from Animal (super.shout())
        super.shout();
    }
    void printName(){
        // use the name from Animal (super.name)
        System.out.println("name = " + super.name);
    }
}

// Cat extends from Animal
class Cat extends Animal{
    void shout(){
        System.out.println("mew mew ....");
    }
    void catShout(){
        super.shout();
    }
    void catName(){
        System.out.println(super.name);
    }
}

public class Super_1{
    public static void main(String[] args){
        // test 1 
        Dog dog = new Dog();
        dog.shout();
        dog.printName();

        // test 2 
        Cat cat = new Cat();
        cat.shout();
        cat.catShout();
        cat.catName();
    }
}