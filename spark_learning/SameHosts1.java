
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import org.apache.spark.sql.SQLContext;

import java.util.Arrays;
import java.util.Map;




public class SameHosts1 {

    public static void main(String[] args) throws Exception {

      SparkConf conf = new SparkConf().setAppName("LogWithSameHost").setMaster("local[2]"); 

      JavaSparkContext sc = new JavaSparkContext(conf); 

      SQLContext sqlContext = new SQLContext(sc);


      // read tsv in java spark 
      // https://stackoverflow.com/questions/38751298/best-way-to-read-tsv-file-using-apache-spark-in-java?noredirect=1&lq=1
      //JavaRDD <String> nasalog1 = sc.textFile("data/nasa_19950701.tsv"); 
      //JavaRDD <String> nasalog2 = sc.textFile("data/nasa_19950801.tsv"); 
      DataFrame df1 = sqlContext.read()
                               .format("com.databricks.spark.csv")
                               .option("inferSchema", "true")
                               .option("header", "true")
                               .option("delimiter","  ")
                               .load("data/nasa_19950701.tsv");

      DataFrame df2 = sqlContext.read()
                                .format("com.databricks.spark.csv")
                                .option("inferSchema", "true")
                                .option("header", "true")
                                .option("delimiter","  ")
                                .load("data/nasa_19950801.tsv");


      // inner join spark dataframe to get the "hosts which are accessed on BOTH days"
      // https://stackoverflow.com/questions/43033835/join-in-a-dataframe-spark-java
      Dataset <Row> df_joined  = df1.join(df2, df1.col("host").equalTo(df2.col("host")));
      //Dataset <Row> joined = dfairport.join(dfairport_city_state, dfairport.col("leg_city").equalTo(dfairport_city_state.col("city")));
      System.out.println(" OUTOUT : " + df_joined);




        /* "in/nasa_19950701.tsv" file contains 10000 log lines from one of NASA's apache server for July 1st, 1995.
           "in/nasa_19950801.tsv" file contains 10000 log lines for August 1st, 1995
           Create a Spark program to generate a new RDD which contains the hosts which are accessed on BOTH days.
           Save the resulting RDD to "out/nasa_logs_same_hosts.csv" file.

           Example output:
           vagrant.vf.mmc.com
           www-a1.proxy.aol.com
           .....

           Keep in mind, that the original log files contains the following header lines.
           host	logname	time	method	url	response	bytes

           Make sure the head lines are removed in the resulting RDD.
         */
    }
}
