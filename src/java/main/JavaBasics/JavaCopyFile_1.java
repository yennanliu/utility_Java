import java.io.*;

public class JavaCopyFile_1{
    public static void main(String[] args) throws Exception{
        
    FileInputStream in = new FileInputStream("../../../../data/example.txt");

    FileOutputStream out = new FileOutputStream("example_copy.txt");

    int len = 0;
    long beginTime = System.currentTimeMillis();

    while ( (len = in.read()) != -1 ){
        out.write(len);
    }

    long endTime = System.currentTimeMillis();

    System.out.println("Totcal Cost Time = " + (endTime - beginTime) + " millls second");

    // close stream
    in.close();
    out.close();
    }
}