

import commons.Utils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import scala.Tuple2;


public class Uber_pairRDD_filter_latlon {

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);

        SparkConf conf = new SparkConf().setAppName("UberTrip").setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> uberRDD = sc.textFile("data/uber_sample_data.text");

        JavaPairRDD<String, Float> uberTimeLonPairRDD = uberRDD.mapToPair(getUberTripTimeLon());

        //JavaPairRDD<String, String> airportID_airportLat_PairRDD = airportsRDD.mapToPair(getAirportIDAndLat());

        JavaPairRDD<String, Float> uberfilterTimeLonPairRDD = uberTimeLonPairRDD.filter(keyValue -> keyValue._2() > -74);

        JavaPairRDD<String, Float> uberfilterTimeLonPairRDD2 = uberTimeLonPairRDD.filter(keyValue -> (keyValue._2() > -73.80) & (keyValue._2() < -73.69999999));

        //JavaPairRDD<String, Float> uberfilterTimeLonPairRDD = uberTimeLonPairRDD.filter(keyValue -> keyValue._2().getValue() > -74);

        System.out.println("*** uberTimeLonPairRDD :\n" + uberTimeLonPairRDD.take(30) );

        System.out.println("*** uberfilterTimeLonPairRDD :\n" + uberfilterTimeLonPairRDD.take(30) );

        System.out.println("*** uberfilterTimeLonPairRDD2 :\n" + uberfilterTimeLonPairRDD2.take(30) );


    }

    private static PairFunction<String, String, Float> getUberTripTimeLon() {
        return (PairFunction<String, String, Float>) line -> new Tuple2<>(line.split(Utils.COMMA_DELIMITER)[0],
                                                                           Float.valueOf(line.split(Utils.COMMA_DELIMITER)[2]));
    }

}
