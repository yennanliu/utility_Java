import java.io.*;

public class DeleteDirectoryFiles{

    public static void main (String[] args){

    // the directory need to delte
    File files = new File("test"); 

    // run the delete method
    deleteDir(files);
    } 

    // delte method
    public static void deleteDir(File files){
    // get the lists of file under files and save it in array
    File[] listFiles = files.listFiles();

    // go through array
    for (File file: listFiles){
        // if is directory, then run the delete method recursively
        if (file.isDirectory()){
            deleteDir(file);
        }

        // if is file, delete it directly
        file.delete();
     }
        // after deleting all files under directory, delete the directory as final step
        files.delete();

  }

}