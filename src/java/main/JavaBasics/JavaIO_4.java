import java.io.*;

public class JavaIO_4{
    public static void main(String[] args) throws Exception{
    // create FileReader for loding file
    FileReader fileReader = new FileReader("../../../../data/example.txt");

    int len = 0;
    while ( (len = fileReader.read()) != -1) {
    	// for getting the str from file, do the type transformation here (char)
        System.out.println((char)len);
        }
    fileReader.close();
    }
}