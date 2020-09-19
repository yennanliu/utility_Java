# [utility_Java](https://github.com/yennanliu/utility_Java/tree/master/src/java/main/JavaBasics)
- `learning Java from scratch`
- Java basics collections
- env
	- Java JDK 1.8
	- maven
	- IntelliJ

### Main Files
1. [Java Basic](https://github.com/yennanliu/utility_Java/tree/master/src/java/main/JavaBasics)
	- [Constructor Overload](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/ConstructorOverload.java) - overload Constructor for cases 
	- [This metod](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/ThisDemo.java) - `this` method examples in java
	- [Staic Var](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/StaicVar.java) - `Staic var` examples in java
	- [Staic method](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/StaicMethod.java) - `Staic Method` examples in java
	- [Extends method](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/Extends.java) - `extends class` examples in java
	- [ReWrite method](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/ReWrite.java) - `ReWrite method` examples in java
	- [Super 1](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/Super_1.java), [Super 2](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/Super_2.java) - `Super method` examples in java
	- [abstract](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/abstractDemo.java) - `abstract method` examples in java
	- [interface](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/interfaceDemo.java), [interface 2](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/interfaceDemo2.java) - `interface method` examples in java
	- [Runtime](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/CheckRuntime.java) - Runtime is JVM running status, can check JVM/process status via it
	- [CheckSystem](https://github.com/yennanliu/utility_Java/blob/master/src/java/main/JavaBasics/CheckSystem.java) - check JVM/system properties

### Build

<details>
<summary>Build</summary>

- dev

</details>


### Development

<details>
<summary>Development</summary>

#### Create the Project
```bash
mvn archetype:generate -DgroupId=com.yen.JavaBasics -DartifactId=utility-java -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```
</details>

### Reference 

<details>
<summary>Reference</summary>

- http://www.runoob.com/sqlite/sqlite-java.html
- https://github.com/OSE-Lab/learning-spark/tree/master/examples-java
- https://stackoverflow.com/questions/22252534/how-to-run-a-spark-java-program-from-command-line
- https://stackoverflow.com/questions/23308493/how-to-download-mysql-jdbc-jar-file-on-centos
- https://github.com/databricks/learning-spark/tree/master/src/main/java/com/oreilly/learningsparkexamples/java
- https://github.com/endymecy/spark-ml-source-analysis

### Spark Java Tutorial 
- https://github.com/jleetutorial/sparkTutorial
- apache-spark-course-with-java
	- https://www.udemy.com/apache-spark-course-with-java/

### Java tutorial in 6 hours 
- http://www.codedata.com.tw/java/java-tutorial-the-1st-class-1-jdk-versions-and-implementations/
- https://github.com/codedata/JavaTutorial

### Packages
- https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.11/2.3.0

### Maven
- https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
- https://maven.apache.org/guides/getting-started/

</details>


### Quick start (lagacy)

<details>
<summary>Quick start (lagacy)</summary>

```bash
# --- run the simplist app --- 
# compile 
$ javac HelloWorld.java
# run java application  
$ java HelloWorld
```

```bash
# --- work with DB ---
# please download SQLiteJDBC and save as current route :
# https://bitbucket.org/xerial/sqlite-jdbc/downloads/ 
$ javac SQLiteJDBC.java
$ javac SQLiteJDBC_creat_table.java
$ javac SQLiteJDBC_insert_to_table.java
$ java -classpath ".:sqlite-jdbc-3.21.0.jar" SQLiteJDBC
$ java -classpath ".:sqlite-jdbc-3.21.0.jar" SQLiteJDBC_creat_table
$ java -classpath ".:sqlite-jdbc-3.21.0.jar" SQLiteJDBC_insert_to_table
$ sqlite3 test.db 'select * from company;'
# output 
# 1|Paul|32|California|20000.0
# 2|Allen|25|Texas|15000.0
# 3|Teddy|23|Norway|20000.0
# 4|Mark|25|Rich-Mond |65000.0

```

```bash
# --- work with package ---
# please check the file structure is as below
#├── package_animals
#   ├── Animal.java
#   └── MammalInt.java
# compile 
$ javac package_animals/MammalInt.java
$ javac package_animals/Animal.java
# run java application under package : package_animals
$ java package_animals/MammalInt
# output 
# Mammal eats
# Mammal travels
```

```bash
# --- work with spark --- 
#### set up mysql ####
$ mysql.server start  (mysql server should start locally at mysql://127.0.0.1 default )
# access local mysql
$ mysql -u root 
# select DB
mysql> use mysql; 
# create table 
mysql> create table testData(name varchar(32) not null , value varchar(32) not null);
# show table data 
mysql> select * from testData;
Empty set (0.00 sec)

#### set up spark ####
# please make sure you've downloaded spark core library via https://spark.apache.org/downloads.html and save that  at : /Users/$USER/spark/
# please download Mysql JDBC jar and put it to the "classpath" location via https://stackoverflow.com/questions/23308493/how-to-download-mysql-jdbc-jar-file-on-centos
# compile 
$ javac -classpath  ".:/Users/$USER/spark/jars/*"  Spark_Mysql_demo.java 
# run java application  
$ java -classpath  ".:/Users/$USER/spark/jars/*"  Spark_Mysql_demo
# back to mysql and query the output 
mysql> select * from testData;
+------+-------+
| name | value |
+------+-------+
| a    | abcd  |
| b    | abcd  |
+------+-------+
2 rows in set (0.00 sec)

mysql> 

```

```bash
# --- work with spark  ML --- 

# compile 
$ javac -classpath  ".:/Users/$USER/spark/jars/*" Spark_LinearRegression_ElasticNet_Demo.java 
# run java application  
$ java -classpath  ".:/Users/$USER/spark/jars/*"  Spark_LinearRegression_ElasticNet_Demo
# output
2018-05-26 07:38:16 INFO  DAGScheduler:54 - Job 6 finished: show at Spark_LinearRegression_ElasticNet_Demo.java:69, took 0.067516 s
+--------------------+
|           residuals|
+--------------------+
|  -9.889232683103197|
|  0.5533794340053554|
|  -5.204019455758823|
| -20.566686715507508|
|    -9.4497405180564|
|  -6.909112502719486|
|  -10.00431602969873|
|   2.062397807050484|
|  3.1117508432954772|
| -15.893608229419382|
|  -5.036284254673026|
|   6.483215876994333|
|  12.429497299109002|
|  -20.32003219007654|
| -2.0049838218725005|
| -17.867901734183793|
|   7.646455887420495|
| -2.2653482182417406|
|-0.10308920436195645|
|  -1.380034070385301|
+--------------------+
only showing top 20 rows

RMSE: 10.189077167598475
r2: 0.022861466913958184

```

#### Quick Start (with Maven)

```bash
# ref 
# https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/

# step 1) set up JAVA project via mvn 
$ mvn archetype:generate -DgroupId=com.yen.javadev -DartifactId=maven-first-java-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

# step 2) Code your APP 
# in this demo : 
# src/main/java/com/yen/javadev/APP.java
# src/test/java/com/yen/javadev/APPTest.java

# step 2') UPDATE POM 
# pom.xml 

# step 3) Maven Build
$ mvn package

# step 4) package  
$ mvn clean package

# step 5) run the APP

$ java -jar target/maven-first-java-project-1.0-SNAPSHOT.jar 123456
# output 
# 8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92

$ java -jar target/maven-first-java-project-1.0-SNAPSHOT.jar 99999
# output 
# fd5f56b40a79a385708428e7b32ab996a681080a166a2206e750eb4819186145

```

</details>
