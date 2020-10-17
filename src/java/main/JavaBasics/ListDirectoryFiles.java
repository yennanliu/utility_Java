import java.io.*;

public class ListDirectoryFiles{

    public static void main (String[] args){

        // the directory need to delte
        File files = new File("test"); 

        // run the delete method
        fileDir(files);
    } 

    // delte method
    public static void fileDir(File files){
        // get the lists of file under files and save it in array
        File[] listFiles = files.listFiles();

        // go through array
        for (File file: listFiles){
            // if is directory, then run the fileDir method recursively
            if (file.isDirectory()){
                fileDir(file);
            }
         }
        // print result
        System.out.println("file name : " + files);
      }
}