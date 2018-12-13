
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Map;

public class WordCount_PairRDD_reduceByKey_demo {

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("wordCounts").setMaster("local[3]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile("data/word_count.text");
        JavaRDD<String> wordRdd = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());


        JavaRDD <String> wordRddMap_0 = lines.map( line -> line.split(" ")[0]);

        //JavaRDD <String> wordRddMap = lines.map( line -> line.split(".")[0]);

        JavaPairRDD<String, Integer> wordPairRdd = wordRdd.mapToPair((PairFunction<String, String, Integer>) word -> new Tuple2<>(word, 1));

        JavaPairRDD<String, Integer> wordCounts = wordPairRdd.reduceByKey((Function2<Integer, Integer, Integer>) (x, y) -> x + y);

        Map<String, Integer> worldCountsMap = wordCounts.collectAsMap();

        System.out.println("lines: " + lines.collect());

        System.out.println("wordRdd: " + wordRdd.collect());

        System.out.println("wordPairRdd: " + wordPairRdd.collect());

        System.out.println("wordCounts: " + wordCounts.collect());

        //System.out.println("worldCountsMap: " + worldCountsMap.collect());

        System.out.println("for loop print wordCounts output: ");
        for (Map.Entry<String, Integer> wordCountPair : worldCountsMap.entrySet()) {
            System.out.println(wordCountPair.getKey() + " : " + wordCountPair.getValue());
        }

        System.out.println("wordRddMap_0: " + wordRddMap_0.collect());

        //System.out.println("wordRddMap: " + wordRddMap.collect());
    }
}
