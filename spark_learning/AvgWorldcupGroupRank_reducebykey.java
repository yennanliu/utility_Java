
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

public class AvgWorldcupGroupRank_reducebykey {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("Avg World Cup Group Rank reducebykey").setMaster("local[3]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile("data/worldcupplayerinfo_20140701_1.tsv");
        JavaRDD<String> cleanedLines = lines.filter(line -> !line.contains("Position"));

        JavaPairRDD<String, AvgCount> grouprankPairRdd = cleanedLines.mapToPair(
                line -> new Tuple2<>(line.split("\t")[0],
                        new AvgCount(1, Double.parseDouble(line.split("\t")[2]))));

        JavaPairRDD<String, AvgCount> grouprankPairTotal = grouprankPairRdd.reduceByKey(
                 (x, y) -> new AvgCount(x.getCount() + y.getCount(), x.getTotal() + y.getTotal()));

        System.out.println("postcodePopulationTotal: ");
        for (Map.Entry<String, AvgCount> grouprankPairTotalPair : grouprankPairTotal.collectAsMap().entrySet()) {
            System.out.println(grouprankPairTotalPair.getKey() + " : " + grouprankPairTotalPair.getValue());
        }

        JavaPairRDD<String, Double> grouprankPairAvg = grouprankPairTotal.mapValues(avgCount -> avgCount.getTotal()/avgCount.getCount());
        System.out.println("housePriceAvg: ");
        for (Map.Entry<String, Double> grouprankPairAvgPair : grouprankPairAvg.collectAsMap().entrySet()) {
            System.out.println(grouprankPairAvgPair.getKey() + " : " + grouprankPairAvgPair.getValue());
        }

        System.out.println("lines : \n" + lines.take(10));
        System.out.println("cleanedLines :\n " + cleanedLines.take(10));
        System.out.println("grouprankPairRdd :\n " + grouprankPairRdd.take(10));
        System.out.println("grouprankPairTotal :\n " + grouprankPairTotal.take(10));
        System.out.println("grouprankPairAvg :\n " + grouprankPairAvg.take(10));


        // ---------------------------------- dev 
        
        // ---------------------------------- dev 

    }
}
