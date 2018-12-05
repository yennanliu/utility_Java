
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class PairRddFromRegularRdd {

    public static void main(String[] args) throws Exception {

        // mute 3rd party log 
        Logger.getLogger("org").setLevel(Level.ERROR);

        SparkConf conf = new SparkConf().setAppName("create").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        List<String> inputStrings = Arrays.asList("Lily 23", "Jack 29", "Mary 29", "James 8");

        JavaRDD<String> regularRDDs = sc.parallelize(inputStrings);

        JavaPairRDD<String, Integer> pairRDD = regularRDDs.mapToPair(getPairFunction());

        // print original RDD 
        System.out.println("*** regularRDDs (RDD of inputStrings ):\n" + regularRDDs.collect() );

        // print PairRDD 
        System.out.println("*** pairRDD (pairRDD of regularRDDs ):\n" + pairRDD.collect() );

        // save to /out 
        pairRDD.coalesce(1).saveAsTextFile("out/pair_rdd_from_regular_rdd");
    }

    private static PairFunction<String, String, Integer> getPairFunction() {
        return s -> new Tuple2<>(s.split(" ")[0], Integer.valueOf(s.split(" ")[1]));
    }
}
