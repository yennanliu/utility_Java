import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


// credit : https://gist.github.com/madan712/8683348

public class CSVReader {

	public static final String delimiter = ",";

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

	public static void main(String[] args) {
		// csv file to read
		String csvFile = "/Users/yennanliu/utility_java/df_test.csv";
		CSVReader.read(csvFile);
	}

}