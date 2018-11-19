import commons.Utils;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AirportsByLatitude {

 public static void main(String[] args) throws Exception {


  SparkConf conf = new SparkConf().setAppName("airportsbylatitude").setMaster("local[2]");

  JavaSparkContext sc = new JavaSparkContext(conf);

  JavaRDD < String > airports = sc.textFile("data/airports.text");

  JavaRDD < String > airports_latitude_bigger_40 = airports.filter(line -> Float.valueOf(line.split(Utils.COMMA_DELIMITER)[6]) > 40);

  JavaRDD < String > airports_name_and_latitude = airports_latitude_bigger_40.map(line -> {
    String[] splits = line.split(Utils.COMMA_DELIMITER);
    return StringUtils.join(new String[] {
     splits[1], splits[6] }, ",");
              }
        );
  airports_name_and_latitude.saveAsTextFile("out/airports_name_and_latitude.text");

    }
}