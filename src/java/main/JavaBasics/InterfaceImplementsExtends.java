
// https://www.youtube.com/watch?v=FybZ9gMFytE&list=PLmOn9nNkQxJEDjzl0iBYZ3WuXUuUStxZl&index=10

public class InterfaceImplementsExtends{

    public static void main (String[] args){

        System.out.println("InterfaceImplementsExtends run ...");

        A a = new B();

        B b = new C();

        A a_ = new C();

        System.out.println(a);
        System.out.println(b);
        System.out.println(a_);
        
        System.out.println(C.class.getInterfaces().length);

    }
}


interface A {

}

class B implements A {

}

class C extends B {

}