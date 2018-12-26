// UDF 
import commons.Response2;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.avg;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.max;


public class Spark_TypedDataset_demo_RealEstatedata {
    private static final String PRICE = "price";
    private static final String SIZE = "size";
    private static final String REALESTATE_MIDPOINT_BUCKET = "realestateMidpointBucket";

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession session = SparkSession.builder().appName("RealEstateDataAnalysis").master("local[*]").getOrCreate();

        DataFrameReader dataFrameReader = session.read();

        Dataset<Row> responses = dataFrameReader.option("header","true").csv("data/RealEstate.csv");

        Dataset<Row> responseWithSelectedColumns = responses.select(
                col("Location"),
                col("Price").as("price").cast("float"),
                col("Size").as("size").cast("float"),
                col("Status").as("status"));

        Dataset<Response2> typedDataset = responseWithSelectedColumns.as(Encoders.bean(Response2.class));

        System.out.println("=== Print 20 records of responses  ===");
        responseWithSelectedColumns.show(20);


        System.out.println("=== Print out schema ===");
        typedDataset.printSchema();

        System.out.println("=== Print 20 records of responses table ===");
        typedDataset.show(20);

        System.out.println("=== Print the responses from Afghanistan ===");
        typedDataset.filter((FilterFunction<Response2>) response -> response.getLocation().equals("Santa Maria-Orcutt")).show();

        System.out.println("=== Print the count of country ===");
        typedDataset.groupBy(typedDataset.col("location")).count().show();

        System.out.println("=== Print responses with price less than 150000 ===");
        typedDataset.filter((FilterFunction<Response2>)response -> response.getprce() !=null &&
                                                                  response.getprce() < 150000)
                    .show();

        System.out.println("=== Print the result by price in descending order ===");
        typedDataset.orderBy(typedDataset.col(PRICE).desc()).show();

        System.out.println("=== Group by location and aggregate by average price middle point and max age middle point ===");
        typedDataset.filter((FilterFunction<Response2>) response -> response.getLocation() != null)
                    .groupBy("location")
                    .agg(avg(PRICE), max(PRICE))
                    .show();
        /*
        System.out.println("=== Group by salary bucket ===");
        typedDataset.map((MapFunction<Response, Integer>) response -> response.getprce() == null ?
                                                                      null :
                                                                      Math.round(response.getprce()/20000) * 20000, Encoders.INT())
                    .withColumnRenamed("value", PRICE)
                    .groupBy(SALARY_MIDPOINT_BUCKET)
                    .count()
                    .orderBy(SALARY_MIDPOINT_BUCKET).show();
        */
    }
}
