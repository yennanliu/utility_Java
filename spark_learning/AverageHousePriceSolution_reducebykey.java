
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Map;
// UDF 
import commons.AvgCount;

public class AverageHousePriceSolution_reducebykey {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("averageHousePriceSolution").setMaster("local[3]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile("data/RealEstate.csv");
        JavaRDD<String> cleanedLines = lines.filter(line -> !line.contains("Bedrooms"));

        JavaPairRDD<String, AvgCount> housePricePairRdd = cleanedLines.mapToPair(
                line -> new Tuple2<>(line.split(",")[3],
                        new AvgCount(1, Double.parseDouble(line.split(",")[2]))));

        JavaPairRDD<String, AvgCount> housePriceTotal = housePricePairRdd.reduceByKey(
                 (x, y) -> new AvgCount(x.getCount() + y.getCount(), x.getTotal() + y.getTotal()));

        System.out.println("housePriceTotal: ");
        for (Map.Entry<String, AvgCount> housePriceTotalPair : housePriceTotal.collectAsMap().entrySet()) {
            System.out.println(housePriceTotalPair.getKey() + " : " + housePriceTotalPair.getValue());
        }

        JavaPairRDD<String, Double> housePriceAvg = housePriceTotal.mapValues(avgCount -> avgCount.getTotal()/avgCount.getCount());
        System.out.println("housePriceAvg: ");
        for (Map.Entry<String, Double> housePriceAvgPair : housePriceAvg.collectAsMap().entrySet()) {
            System.out.println(housePriceAvgPair.getKey() + " : " + housePriceAvgPair.getValue());
        }

        System.out.println("lines : \n" + lines.take(10));
        System.out.println("cleanedLines :\n " + cleanedLines.take(10));
        System.out.println("housePricePairRdd :\n " + housePricePairRdd.take(10));
        System.out.println("housePriceTotal :\n " + housePriceTotal.take(10));
        System.out.println("housePriceAvg :\n " + housePriceAvg.take(10));


        // ---------------------------------- dev 

        JavaPairRDD<String, AvgCount> houseSizePairRdd = cleanedLines.mapToPair(
        line -> new Tuple2<>(line.split(",")[3],
                new AvgCount(1, Double.parseDouble(line.split(",")[5]))));

        JavaPairRDD<String, AvgCount> houseSizeTotal = houseSizePairRdd.reduceByKey(
        (x, y) -> new AvgCount(x.getCount() + y.getCount(), x.getTotal() + y.getTotal()));

        JavaPairRDD<String, Double> houseSizeAvg = houseSizeTotal.mapValues(avgCount -> avgCount.getTotal()/avgCount.getCount());
        System.out.println("housePriceAvg: ");


        System.out.println("houseSizePairRdd :\n " + houseSizePairRdd.take(10));
        System.out.println("houseSizeTotal :\n " + houseSizeTotal.take(10));
        System.out.println("houseSizeAvg :\n " + houseSizeAvg.take(10));
        
        // ---------------------------------- dev 

    }
}
