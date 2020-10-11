import java.io.*;

public class JavaIO_5{
    public static void main(String[] args) throws Exception{
    // create FileReader for loding file
    FileWriter fileWriter = new FileWriter("example_copy.txt");

    fileWriter.write("this is header");
    fileWriter.write("hey how r you ?");
    fileWriter.write("nice to meet u");
    fileWriter.write("end");

    fileWriter.close();
    }
}