// package nl.craftsmen.spark.iris;

import org.apache.spark.mllib.tree.RandomForest;
import org.apache.spark.ml.classification.RandomForestClassificationModel;
import org.apache.spark.ml.classification.RandomForestClassifier;
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.when;

/****

credit 

https://craftsmen.nl/an-introduction-to-machine-learning-with-apache-spark/
https://github.com/Silfen66/SparkIris/blob/master/src/main/java/nl/craftsmen/spark/iris/SparkIris.java


**** /



/**
 * Apache Spark MLLib Java algorithm for classifying the Iris Species
 * into three categories using a Random Forest Classification algorithm.
 */
public class Spark_randomforest_iris {

    private static final String PATH = "iris.csv";

    public static void main(String[] args) {

        // initialise Spark session
        SparkSession sparkSession = SparkSession.builder().appName("Spark_randomforest_iris").config("spark.master", "local").getOrCreate();

        // load dataset, which has a header at the first row
        Dataset<Row> rawData = sparkSession.read().option("header", "true").csv(PATH);

        // cast the values of the features to doubles for usage in the feature column vector
        Dataset<Row> transformedDataSet = rawData.withColumn("SepalLengthCm", rawData.col("SepalLengthCm").cast("double"))
                .withColumn("SepalWidthCm", rawData.col("SepalWidthCm").cast("double"))
                .withColumn("PetalLengthCm", rawData.col("PetalLengthCm").cast("double"))
                .withColumn("PetalWidthCm", rawData.col("PetalWidthCm").cast("double"));

        // add a numerical label column for the Random Forest Classifier
        transformedDataSet = transformedDataSet
                .withColumn("label", when(col("Species").equalTo("Iris-setosa"),1)
                .when(col("Species").equalTo("Iris-versicolor"),2)
                .otherwise(3));

        // identify the feature colunms
        String[] inputColumns = {"SepalLengthCm", "SepalWidthCm", "PetalLengthCm", "PetalWidthCm"};
        VectorAssembler assembler = new VectorAssembler().setInputCols(inputColumns).setOutputCol("features");
        Dataset<Row> featureSet = assembler.transform(transformedDataSet);

        // split data random in trainingset (70%) and testset (30%) using a seed so results can be reproduced
        long seed = 5043;
        Dataset<Row>[] trainingAndTestSet = featureSet.randomSplit(new double[]{0.7, 0.3}, seed);
        Dataset<Row> trainingSet = trainingAndTestSet[0];
        Dataset<Row> testSet = trainingAndTestSet[1];

        trainingSet.show();
        // ----------------  add some parameter for RF model ---------------- 
        // https://dzone.com/articles/classification-using-random-forest-with-spark-20 
        //HashMap<Integer, Integer> categoricalFeaturesInfo = new HashMap<>(); // Empty categoricalFeaturesInfo indicates all features are continuous.
        Integer numTrees = 10; // Deafult is 5 but it is better practice to have more trees. If >1 then it is considered as a forest.
        String featureSubsetStrategy = "auto"; // Let the algorithm choose the best feature subset strategy.
        String impurity = "gini"; // For information gain
        Integer maxDepth = 20; //Maximum depth of the tree
        //Integer maxBins = 40; // Number of maximum beans to be used
        //Integer seed = 12345L; // Random seed
        // ----------------  add some parameter for RF model ---------------- 

        // train the algorithm based on a Random Forest Classification Algorithm with default values
        //RandomForestClassifier randomForestClassifier = new RandomForestClassifier().setSeed(seed);
        //RandomForestClassificationModel model = RandomForest.trainClassifier(trainingSet,numTrees,featureSubsetStrategy,impurity,maxDepth); 
        RandomForestClassifier randomForestClassifier = new RandomForestClassifier().setSeed(seed);
        RandomForestClassificationModel model = randomForestClassifier.fit(trainingSet); 
        
        // test the model against the testset and show results
        Dataset<Row> predictions = model.transform(testSet);
        System.out.println("----------------- prediction ----------------- ");
        predictions.select("id", "label", "prediction").show(20);
        System.out.println("----------------- prediction ----------------- ");

        // evaluate the model
        MulticlassClassificationEvaluator evaluator = new MulticlassClassificationEvaluator()
                .setLabelCol("label")
                .setPredictionCol("prediction")
                .setMetricName("accuracy");
        System.out.println("----------------- accuracy ----------------- "); 
        System.out.println("accuracy: " + evaluator.evaluate(predictions));
        System.out.println("----------------- accuracy ----------------- "); 
    }
}




