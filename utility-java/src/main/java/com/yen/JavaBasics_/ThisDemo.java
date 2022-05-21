class Person{
    public Person(){
        System.out.println("run the NO VAR method in construtor");
    }

    public Person(int age){
        // *** this() will run the public Person() 
        // which is the "NO VAR" version of method with same name
        this();
        System.out.println("run the WITH VAR method in construtor");
        System.out.println("age : " + age);
    }
}

class Person2{
    public Person2(){
        // *** this() will run the Person2(int age)
        // which is the "WITH VAR" version of method with same name
        this(99);
        System.out.println("run the NO VAR method in construtor");
    }

    public Person2(int age){
        System.out.println("run the WITH VAR method in construtor");
        System.out.println("age : " + age);
    }
}

// Notice : below syntax will cause error : can not use this() in both sides

// class Person3{
//     public Person3(){
//         this(99);
//         System.out.println("run the NO VAR method in construtor");
//     }
//
//     public Person3(int age){
//         this()
//         System.out.println("run the WITH VAR method in construtor");
//         System.out.println("age : " + age);
//     }
// }

public class ThisDemo {
    public static void main(String[] args){
        // example 1 
        System.out.println("example 1");
        Person p = new Person(19);

        // example 2 
        System.out.println("example 2");
        Person2 p2 = new Person2();
    }
}