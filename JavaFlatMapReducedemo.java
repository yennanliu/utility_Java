
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.commons.lang.StringUtils;


import java.util.Arrays;
import java.util.List;

/*


spark_learning/data/prime_nums.text :

  2	  3	  5	  7	 11	 13	 17	 19	 23	 29
 31	 37	 41	 43	 47	 53	 59	 61	 67	 71
 73	 79	 83	 89	 97	101	103	107	109	113
127	131	137	139	149	151	157	163	167	173
179	181	191	193	197	199	211	223	227	229
233	239	241	251	257	263	269	271	277	281
283	293	307	311	313	317	331	337	347	349
353	359	367	373	379	383	389	397	401	409
419	421	431	433	439	443	449	457	461	463
467	479	487	491	499	503	509	521	523	541


*/


public class JavaFlatMapReducedemo {

    public static void main(String[] args) throws Exception {

    Logger.getLogger("org").setLevel(Level.OFF);

	SparkConf conf = new SparkConf().setAppName("primeNums").setMaster("local[*]");
	
	JavaSparkContext sc = new JavaSparkContext(conf);

	JavaRDD<String> lines = sc.textFile("spark_learning/data/prime_nums.text");

	JavaRDD<String> numbers = lines.flatMap(line -> Arrays.asList(line.split("\\s+")).iterator());

	JavaRDD<String> numbers2 = lines.map(line -> {
		String[] splits = line.split("\\s+");
		return StringUtils.join(new String[]{splits[0],splits[1]}, ",");
		}
	);

	JavaRDD<String> validNumbers = numbers.filter(number -> !number.isEmpty());

	JavaRDD<Integer> intNumbers = validNumbers.map(number -> Integer.valueOf(number));

	Integer sum = intNumbers.reduce((x, y) -> x + y);

	Integer product = intNumbers.reduce((x, y) -> x * y);

	System.out.println("sample numbers is  (flatMap):" + numbers.take(20));

	System.out.println("sample numbers2 is (Map) :" + numbers2.take(20));

	System.out.println("sample validNumbers is :" + validNumbers.take(20));

	System.out.println("sample intNumbers is :" + intNumbers.take(20));

	System.out.println("product is :" + product);

	System.out.println("sum is :" + sum);
      
	/* 
	Create a Spark program to read the first 100 prime numbers from in/prime_nums.text,
	print the sum of those numbers to console.

	Each row of the input file contains 10 prime numbers separated by spaces.
	*/

    }
}
