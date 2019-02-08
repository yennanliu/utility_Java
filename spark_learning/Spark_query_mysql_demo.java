import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SQLContext; 

import static org.apache.spark.sql.functions.*;

public class Spark_query_mysql_demo {

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);

        SparkConf conf = new SparkConf().setAppName("StackOverFlowSurvey").setMaster("local[1]");
         
        SparkContext sc = new SparkContext("local", "spark-mysql-test", conf);
        
        SQLContext sqlContext = new SQLContext(sc);

        // here you can run sql query
        String sql = "(select * from Soft_Job LIMIT 1000) as test_table";

        String url = "jdbc:mysql://103.29.68.107:3306/PTTData?user=guest&password=123";

        Dataset <Row> df = sqlContext
                      .read()
                      .format("jdbc")
                      .option("url", url)
                      .option("dbtable", sql)
                      .load();
        df.show(30); 

    }
}

