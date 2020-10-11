import java.io.*;

public class JavaIO_2{
    public static void main(String[] args) throws Exception{
    // create a binary output stream load doc
    FileOutputStream out = new FileOutputStream("out.txt");

    // define a string
    String mystr = "hellooooo";

    out.write(mystr.getBytes());
    out.close();
    }
}