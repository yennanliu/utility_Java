import java.io.*;

public class JavaIO_7{
    public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader( 
                new FileReader("../../../../data/example.txt"));

    BufferedWriter bw = new BufferedWriter(
                new FileWriter("example_copy.txt"));


    String str = null; 

    while ( (str = br.readLine()) != null) {
    	// for getting the str from file, do the type transformation here (char)
        System.out.println((str));
        bw.write(str);
        bw.newLine();
        }

    br.close();
    bw.close();
    }
}