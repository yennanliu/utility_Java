class Student{
    static String schoolName;
}

public class StaicVar{
    public static void main(String[] args){
        Student stu1 = new Student();
        Student stu2 = new Student();
        // since schoolName is a STATIC var, so this var 
        // will be used by both stu1 and stu2
        Student.schoolName = "UCLA";

        System.out.println("i am Student from " + stu1.schoolName);
        System.out.println("i am Student from " + stu2.schoolName);
    }

}