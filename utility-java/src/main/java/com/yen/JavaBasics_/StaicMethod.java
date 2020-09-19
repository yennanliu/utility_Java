class Person{
    public static void say(){
        System.out.println("hello !!!!!!!!!");
    }
}

public class StaicMethod{
    public static void main(String[] args){
        // call the method via "class.method"
        Person.say();
        // call by instantiate
        Person p = new Person();
        p.say();
    }
}