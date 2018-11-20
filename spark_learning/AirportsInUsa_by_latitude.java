
import commons.Utils;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AirportsInUsa_by_latitude {

    public static void main(String[] args) throws Exception {

        SparkConf conf = new SparkConf().setAppName("airports").setMaster("local[2]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> airports = sc.textFile("data/airports.text");

        JavaRDD<String> airportsInUsabylatitude = airports.filter(line -> line.split(Utils.COMMA_DELIMITER)[3].equals("\"United States\"") & (Float.valueOf(line.split(Utils.COMMA_DELIMITER)[6]) > 40) );

        JavaRDD<String> airportsNameAndCityNames = airportsInUsabylatitude.map(line -> {
                    String[] splits = line.split(Utils.COMMA_DELIMITER);

                    System.out.println("OUTPUT :" + StringUtils.join(new String[]{splits[1], splits[2] , splits[6]}, ","));

                    return StringUtils.join(new String[]{splits[1], splits[2] , splits[6]}, ",");
                }
        );
        airportsNameAndCityNames.saveAsTextFile("out/AirportsInUsa_by_latitude.text");
    }
}
