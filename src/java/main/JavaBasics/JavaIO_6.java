import java.io.*;

public class JavaIO_6{
    public static void main(String[] args) throws Exception{
    // create FileReader for loding file
    FileReader fileReader = new FileReader("../../../../data/example.txt");

    FileWriter fileWriter = new FileWriter("example_copy.txt");

    int len = 0;

    char[] buff = new char[1024];

    while ( (len = fileReader.read(buff)) != -1) {
    	// for getting the str from file, do the type transformation here (char)
        System.out.println((char)len);
        fileWriter.write(buff, 0, len);
        }

    fileReader.close();
    fileWriter.close();
    }
}