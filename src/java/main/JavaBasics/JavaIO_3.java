import java.io.*;

public class JavaIO_3{
    public static void main(String[] args) throws Exception{
    // create a binary output stream load doc
    // set append = true, will append data to the doc, rather than truncate first
    FileOutputStream out = new FileOutputStream("out.txt", true);

    // define a string
    String mystr = "hellooooo";
    String mystr2 = "worldddddd"; 
    out.write(mystr.getBytes());
    out.write(mystr2.getBytes());
    out.close();
    }
}