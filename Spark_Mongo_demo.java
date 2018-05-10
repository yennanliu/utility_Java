/*
credit 
https://github.com/OSE-Lab/learning-spark/tree/master/examples-java/SparkMongoDBExample
*/

import org.apache.hadoop.conf.Configuration;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.bson.BSONObject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


import scala.Tuple2;

import com.mongodb.hadoop.MongoInputFormat;
import com.mongodb.hadoop.MongoOutputFormat;

public class Spark_Mongo_demo {
    
    public static void main(String[] args) {
        
        Configuration mongodbConfig = new Configuration();
        mongodbConfig.set("mongo.job.input.format",
                          "com.mongodb.hadoop.MongoInputFormat");
        mongodbConfig.set("mongo.input.uri",
                        "mongodb://localhost:27017/test.imac");

        SparkConf conf = new SparkConf().setAppName("Spark_Mongo_demo").setMaster("local[*]").set("spark.executor.memory","1g");
        JavaSparkContext sc = new JavaSparkContext(conf);
        
        JavaPairRDD<Object, BSONObject> documents = sc.newAPIHadoopRDD(
            mongodbConfig,            // Configuration
            MongoInputFormat.class,   // InputFormat: read from a live cluster.
            Object.class,             // Key class
            BSONObject.class          // Value class
        );
        
        documents.foreach(new VoidFunction<Tuple2<Object,BSONObject>>() {
            public void call(Tuple2<Object, BSONObject> arg0) throws Exception {
                System.out.println("~~~~~~~~~~~~~~");
                System.out.println(""+arg0._1+"     "+arg0._2);
                System.out.println("~~~~~~~~~~~~~~");
            }
        });

        Configuration outputConfig = new Configuration();
        outputConfig.set("mongo.output.uri",
                         "mongodb://localhost:27017/test.collection");

        documents.saveAsNewAPIHadoopFile(
            "file:///this-is-completely-unused",
            Object.class,
            BSONObject.class,
            MongoOutputFormat.class,
            outputConfig
        );
    }
    
}
