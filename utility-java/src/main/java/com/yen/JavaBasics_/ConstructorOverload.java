class Person{
    String name;
    int age;

    // define a method with int var
    public Person(int a){
        age = a;
    }

    // define the other method with String n, int a
    // this method can be THE SAME NAME, 
    // since the "var set" is different
    public Person(String n, int a){
        name = n;
        age = a;
    }

    public void speak(){
        System.out.println("i am " + age + "this year!");
    }

    public void say(){
        System.out.println("my name is " + name + age + "years old!");
    }
}
public class ConstructorOverload {
    public static void main(String[] args){
    // run
    // call the Person(int a) 
    Person p1 = new Person(18);
    // call the public Person(String n, int a)
    Person p2 = new Person("jim", 33);
    p1.speak();
    p2.say();
    }
}