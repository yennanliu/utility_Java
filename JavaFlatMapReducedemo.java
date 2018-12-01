
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class JavaFlatMapReducedemo {

    public static void main(String[] args) throws Exception {

    Logger.getLogger("org").setLevel(Level.OFF);

	SparkConf conf = new SparkConf().setAppName("primeNums").setMaster("local[*]");
	
	JavaSparkContext sc = new JavaSparkContext(conf);

	JavaRDD<String> lines = sc.textFile("spark_learning/data/prime_nums.text");

	JavaRDD<String> numbers = lines.flatMap(line -> Arrays.asList(line.split("\\s+")).iterator());

	JavaRDD<String> validNumbers = numbers.filter(number -> !number.isEmpty());

	JavaRDD<Integer> intNumbers = validNumbers.map(number -> Integer.valueOf(number));

	Integer sum = intNumbers.reduce((x, y) -> x + y);

	Integer product = intNumbers.reduce((x, y) -> x * y);

	System.out.println("sample numbers is :" + numbers.take(20));

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
