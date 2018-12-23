
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.Arrays;
import java.util.List;
import org.apache.spark.sql.SparkSession;



public class Spark_SQL_csv_demo {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("collect").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SparkSession spark = SparkSession
                              .builder()
                              .appName("Spark_SQL_csv_demo")
                              .config("spark.some.config.option", "some-value")
                              .config("spark.master", "local")
                              .getOrCreate(); 

        // --------------------------
        //  read csv as df 
        // JavaRDD <String> uk_postcode = sc.textFile("spark_learning/data/uk-postcode.csv");
        Dataset<Row> df = spark.read().option("header","true").csv("spark_learning/data/uk-postcode.csv");

        // print df 
        df.show();

        // print query on df output (Spark SQL)
        df.createOrReplaceTempView("uk_postcode");
        Dataset<Row> sqlDF = spark.sql("SELECT Postcode, COUNT(*)  AS COUNT FROM uk_postcod GROUP BY Postcode ORDER BY COUNT DESC LIMIT 20");
        sqlDF.show();   

    }
}


