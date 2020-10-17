import java.io.*;
import java.util.Arrays;

public class ListDirectoryFiles2{

    public static void main (String[] args){

        // the directory need to delte
        File file = new File("."); 

        if (file.isDirectory()){
            String[] fileNames = file.list();

        // go through all files under directory via static method (Arrays.stream.forEach)
        Arrays.stream(fileNames)
              .forEach(f -> System.out.println(f));
        }
    } 
}