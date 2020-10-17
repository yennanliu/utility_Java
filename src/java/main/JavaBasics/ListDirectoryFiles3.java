import java.io.*;
import java.util.Arrays;

public class ListDirectoryFiles3{

    public static void main (String[] args){

        // the directory need to delte
        File file = new File("."); 

        if (file.isDirectory()){
        // filter out only .java files via Lambda
        String[] fileNames = file.list(
            (dir, name) -> name.endsWith(".java"));

        // go through all files under directory via static method (Arrays.stream.forEach)
        Arrays.stream(fileNames)
              .forEach(f -> System.out.println(f));
        }
    } 
}