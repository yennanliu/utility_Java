/*
credit 
https://github.com/OSE-Lab/learning-spark/blob/master/examples-java/SparkMySQLExample/src/com/imac/TestMySQL.java
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Spark_Mysql_demo {

	public static void main(String[] args) throws SQLException {
		SparkConf conf = new SparkConf().setAppName("Spark_Mysql_demo").setMaster("local[2]").set("spark.executor.memory","1g");
		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> inputData = sc.parallelize(Arrays.asList(new String[] {
				"a", "b" }));

		Connection mcConnect = null;
		PreparedStatement mStatement = null;

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			mcConnect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mysql",
					"root", "");
			mStatement = mcConnect
					.prepareStatement("insert into testData(name,value) values (?,?)");
			
			List<String> list = inputData.collect();
			int i=0;
			for (String v : list) {
				mStatement.setString(1, v);
				mStatement.setString(2, "abcd");
				mStatement.executeUpdate();
			}
			
		} finally {
			if (mcConnect != null) {
				mcConnect.close();
			}
			if (mStatement != null) {
				mStatement.close();
			}
		}
	}

}