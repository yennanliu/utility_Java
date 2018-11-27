
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;


public class Spark_RDD_filter_map_csv_demo {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("collect").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // --------------------------
        //  textFile 1  
        JavaRDD <String> uk_postcode = sc.textFile("spark_learning/data/uk-postcode.csv");

        // --------------------------
        // Get "Postcode" column from RDD 
        JavaRDD <String> postcode = uk_postcode.map( line -> line.split(",")[0]); 

        // Get "Latitude" column from RDD 
        JavaRDD <String> latitude = uk_postcode.map( line -> line.split(",")[1]);
        //  Latitude without csv header 
        JavaRDD <String> latitude_without_header =  latitude.filter(latitude_ -> !latitude_.equals("Latitude"));

        // --------------------------
        // filter latitude > 52 
        //JavaRDD<String> latitude_large = latitude_without_header.filter(line -> Float.valueOf(line.split(",")[1]) > 52);
        // dev 


        // --------------------------
        // print out 
        System.out.println("*** uk_postcode:\n" + uk_postcode.take(10) );

        System.out.println("*** postcode:\n" + postcode.take(10) );

        System.out.println("*** latitude:\n" + latitude.take(10) );

        System.out.println("*** latitude_without_header:\n" + latitude_without_header.take(10) );

        //System.out.println("*** latitude_large:\n" + latitude_large.take(10) );

    }
}


