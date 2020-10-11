import java.io.*;

public class JavaIO_1{
	public static void main(String[] args) throws Exception{
	    // create a binary input stream load doc
        FileInputStream in = new FileInputStream("../../../../data/example.txt");
        int b = 0;
        while ( (b = in.read()) != -1) {
            System.out.println(b);
        }
        in.close();
	}
}