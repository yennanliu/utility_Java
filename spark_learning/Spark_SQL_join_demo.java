import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class Spark_SQL_join_demo {

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);

        SparkSession session = SparkSession.builder().appName("UkMakerSpaces").master("local[*]").getOrCreate();

        Dataset<Row> makerSpace = session.read().option("header", "true").csv("data/uk-makerspaces-identifiable-data.csv");

        Dataset<Row> postCode = session.read().option("header", "true").csv("data/uk-postcode.csv")
                .withColumn("PostCode", concat_ws("", col("PostCode"), lit(" ")));

        System.out.println("=== Print 20 records of makerspace table ===");
        makerSpace.show();

        System.out.println("=== Print 20 records of postcode table ===");
        postCode.show();

        // ----------------------- SPARK SQL JOIN OP  ----------------------- // 
        // join table "Postcode" with table "makterSpace" ONLY via "startsWith" method 
        // i.e. "AB11" join on  AB11 out of "AB11 5BN"
        // and this is why there is .withColumn("PostCode", concat_ws("", col("PostCode"), lit(" "))); op above
        // e.g. |    AB1|  ->  |    AB1 |   
        Dataset<Row> joined = makerSpace.join(postCode,
                makerSpace.col("Postcode").startsWith(postCode.col("Postcode")), "left_outer");

        System.out.println("=== Group by Region ===");
        joined.groupBy("Region").count().show(200);
    }
}