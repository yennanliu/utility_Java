// UDF 
import commons.Response;

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



        System.out.println("=== Print 20 records of responses RDD  ===");
        responseWithSelectedColumns.show(20);

        /*
        System.out.println("=== Print out first  ===");
        typedDataset.printSchema();


        System.out.println("=== Print out schema ===");
        typedDataset.printSchema();

        System.out.println("=== Print 20 records of responses table ===");
        typedDataset.show(20);
        */
        /*

        System.out.println("=== Print the responses from Afghanistan ===");
        typedDataset.filter((FilterFunction<Response>) response -> response.getCountry().equals("Afghanistan")).show();

        System.out.println("=== Print the count of occupations ===");
        typedDataset.groupBy(typedDataset.col("occupation")).count().show();

        System.out.println("=== Print responses with average mid age less than 20 ===");
        typedDataset.filter((FilterFunction<Response>)response -> response.getAgeMidPoint() !=null &&
                                                                  response.getAgeMidPoint() < 20)
                    .show();

        System.out.println("=== Print the result by salary middle point in descending order ===");
        typedDataset.orderBy(typedDataset.col(SALARY_MIDPOINT ).desc()).show();

        System.out.println("=== Group by country and aggregate by average salary middle point and max age middle point ===");
        typedDataset.filter((FilterFunction<Response>) response -> response.getSalaryMidPoint() != null)
                    .groupBy("country")
                    .agg(avg(SALARY_MIDPOINT), max(AGE_MIDPOINT))
                    .show();

        System.out.println("=== Group by salary bucket ===");
        typedDataset.map((MapFunction<Response, Integer>) response -> response.getSalaryMidPoint() == null ?
                                                                      null :
                                                                      Math.round(response.getSalaryMidPoint()/20000) * 20000, Encoders.INT())
                    .withColumnRenamed("value", SALARY_MIDPOINT_BUCKET)
                    .groupBy(SALARY_MIDPOINT_BUCKET)
                    .count()
                    .orderBy(SALARY_MIDPOINT_BUCKET).show();
    */
    }
}
