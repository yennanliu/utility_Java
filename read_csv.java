import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class read_csv {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/yennanliu/utility_java/df_test.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }

}