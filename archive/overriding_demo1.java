/* credit https://zh.wikibooks.org/wiki/Java/%E7%BB%A7%E6%89%BF */

class Animal{
public void move(){
System.out.println("Animals can move");
}
}
class Dog extends Animal{
public void move(){
System.out.println("Dogs can walk and run");
}
}
public class overriding_demo1{
public static void main(String args[]){
Animal a = new Animal(); 
Animal b = new Dog(); 
a.move();
b.move();
}
}