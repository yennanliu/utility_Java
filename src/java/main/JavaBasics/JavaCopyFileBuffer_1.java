import java.io.*;

public class JavaCopyFileBuffer_1{
    public static void main(String[] args) throws Exception{
        
    FileInputStream in = new FileInputStream("../../../../data/example.txt");

    FileOutputStream out = new FileOutputStream("example_copy.txt");

    int len = 0;

    // ****** define 1024 byte size (as buffer) //
    byte [] buff = new byte[1024];

    long beginTime = System.currentTimeMillis();

    // ****** use buffer load the data // 
    while ( (len = in.read(buff)) != -1 ){
        // out.write(len);
        out.write(buff, 0, len);
    }

    long endTime = System.currentTimeMillis();

    System.out.println("Totcal Cost Time = " + (endTime - beginTime) + " millls second (with buffer)");

    // close stream
    in.close();
    out.close();
    }
}