


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Spark_union_demo {

	public static void  main(String [] args) throws Exception {

		// neglect all log from org library 
		Logger.getLogger("org").setLevel(Level.ERROR);

		SparkConf conf = new SparkConf().setAppName("unionLogs").setMaster("local[*]"); 

		JavaSparkContext sc = new JavaSparkContext(conf); 

		JavaRDD<String> worldcup1 = sc.textFile("data/worldcupplayerinfo_20140701_1.tsv"); 
		JavaRDD<String> worldcup2 = sc.textFile("data/worldcupplayerinfo_20140701_2.tsv"); 

		JavaRDD<String> aggregatedworldcup = worldcup1.union(worldcup2); 

		JavaRDD<String> clean_aggregatedworldcup = aggregatedworldcup.filter(line -> isNotHeader(line));

		// get the sample of output 
		JavaRDD<String> sample =  clean_aggregatedworldcup.sample(true, 0.1); 

		// print the output
		System.out.println("======================"); 
		System.out.println(sample.take(30));  
		System.out.println("======================"); 
	}

	// define a function 
	// the func will filter all line start with Group and contains Captain 
	private static boolean isNotHeader(String line) {
		return !(line.startsWith("Group") && line.contains("Captain")); 
	} 

}

