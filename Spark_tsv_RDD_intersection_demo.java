import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Spark_tsv_RDD_intersection_demo {

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("collect").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // textFile 1 
        JavaRDD<String> worldcupplayerinfo1 = sc.textFile("spark_learning/data/worldcupplayerinfo_20140701_1.tsv");
        // textFile 2 
        JavaRDD<String> worldcupplayerinfo2 = sc.textFile("spark_learning/data/worldcupplayerinfo_20140701_2.tsv");

        // Get "Position", "Club" column from RDD 
        JavaRDD <String> worldcupPosition1 = worldcupplayerinfo1.map( line -> line.split("\t")[4]); 
        JavaRDD <String> worldcupClub1 = worldcupplayerinfo1.map( line -> line.split("\t")[7]); 
        JavaRDD <String> worldcupPosition2 = worldcupplayerinfo2.map( line -> line.split("\t")[4]); 
        JavaRDD <String> worldcupClub2 = worldcupplayerinfo2.map( line -> line.split("\t")[7]); 

        // get the intersection 

        JavaRDD <String> intersection_position = worldcupPosition1.intersection(worldcupPosition2); 
        JavaRDD <String> intersection_club = worldcupClub1.intersection(worldcupClub2); 


        // print the output
        //System.out.println("worldcupplayerinfo1:\n" + worldcupplayerinfo1.take(100) );
        System.out.println("*** worldcupPosition1:\n" + worldcupPosition1.take(100) );
        System.out.println("*** worldcupClub1:\n" + worldcupClub1.take(100) );

        System.out.println("*** intersection_position:\n" + intersection_position.collect() );
        System.out.println("*** intersection_club:\n" + intersection_club.collect() );




    }
}
