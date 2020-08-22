/* File name : Run.java */

package package_demo1;

public class Run implements Car{
public void move(){
System.out.println("the car moves");
}
public void stop(){
System.out.println("the car stops");
}

public static void main(String args[]){
Run r = new Run();
r.move();
r.stop();
}
}