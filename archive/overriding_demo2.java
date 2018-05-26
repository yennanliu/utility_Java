/* credit https://zh.wikibooks.org/wiki/Java/%E7%BB%A7%E6%89%BF */

class myclass_1{
public void move(){
System.out.println("this is calss 1 ");
}
}
class myclass_2 extends myclass_1{
public void move(){
System.out.println("this is *** extended *** class1 ");
}
}
public class overriding_demo2{
public static void main(String args[]){
myclass_1 a = new myclass_1(); 
myclass_1 b = new myclass_2(); 
a.move();
b.move();
}
}