
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class PairRddFromTupleList {

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);

        SparkConf conf = new SparkConf().setAppName("create").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        List<Tuple2<String, Integer>> tuple = Arrays.asList(new Tuple2<>("Lily", 23),
                                                            new Tuple2<>("Jack", 29),
                                                            new Tuple2<>("Mary", 29),
                                                            new Tuple2<>("James",8));

        JavaPairRDD<String, Integer> pairRDD = sc.parallelizePairs(tuple);

        System.out.println("*** tuple  :\n" + tuple );

        System.out.println("*** pairRDD:\n" + pairRDD.collect() );

        pairRDD.coalesce(1).saveAsTextFile("out/pair_rdd_from_tuple_list");
    }
}
