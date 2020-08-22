import java.io.File;
public class CreateDir {

   public static void main(String args[]) {
      String dirname = "/Users/yennanliu/utility_java/test_dir";
      File d = new File(dirname);
      
      // Create directory now.
      d.mkdirs();
   }
}