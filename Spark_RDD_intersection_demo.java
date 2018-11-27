
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Spark_RDD_intersection_demo {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("collect").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // collection 1 
        List<String> inputWords = Arrays.asList("spark", "hadoop", "spark", "hive", "pig", "cassandra", "hadoop");
        JavaRDD<String> wordRdd = sc.parallelize(inputWords);

        // collection 2 
        List<String> inputWords2 = Arrays.asList("spark", "keras", "nodeJS","pig", "EMR","DATABRICK");
        JavaRDD<String> wordRdd2 = sc.parallelize(inputWords2);

        // interaction RDD 

        JavaRDD<String> interactionRDD = wordRdd.intersection(wordRdd2); 
        System.out.println("interactionRDD:\n" + interactionRDD.take(100) );

    }
}





