import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


// credit : https://gist.github.com/madan712/8683348

public class method_demo2 {

	public static final String delimiter = ",";
	public static void main(String[] args) {
	// step 1 : csv operation
	String csvFile = "/Users/yennanliu/utility_java/df_test.csv";
	CSVReader.read(csvFile);
	// step 2 : integer operation 
	int integer = 100; 
	square(integer);
	print_(integer);
	plus(integer);
}
	
	// ---------------- method 


	public static int print_ (int input)

	{
	System.out.println(input) ; 
	return input; 

	}

	public static int plus (int input)

	{
	System.out.println(input+9) ; 
	return input+9; 

	}


	public static int square (int input)

	{
	System.out.println(input*input ) ; 
	return input*input ; 

	}


	public static void read(String csvFile) {
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";

			String[] tempArr;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				for (String tempStr : tempArr) {
					System.out.print(tempStr + " ");
				}
				System.out.println();
			}
			br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	// ---------------- method 


}

