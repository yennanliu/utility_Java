import java.io.*;

public class JavaCopyFileBuffer_2{
    public static void main(String[] args) throws Exception{
    
    // notice here !!!!
    // put FileInputStream inside BufferedInputStream method
    BufferedInputStream bis = new BufferedInputStream( 
                new FileInputStream("../../../../data/example.txt"));

    BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("example_copy.txt"));

    int len = 0;

    long beginTime = System.currentTimeMillis();

    // ****** use buffer load the data // 
    while ( (bis.read()) != -1 ){
        // out.write(len);
        //out.write(buff, 0, len);
        bos.write(len);
    }

    long endTime = System.currentTimeMillis();

    System.out.println("Totcal Cost Time = " + (endTime - beginTime) + " millls second (with buffer)");

    // close stream
    bis.close();
    bos.close();
    }
}