# utility_Java
- //dev 
- `learning Java from scratch`


### Quick start

```bash
# --- run the simplist app --- 
# compile 
$ javac HelloWorld.java
# run java application  
$ java HelloWorld


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
# --- work with spark --- 
#### set up mysql ####
$ mysql.server start  (mysql server should start at local://127.0.0.1 default )
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


### Reference 

- http://www.runoob.com/sqlite/sqlite-java.html
- https://github.com/OSE-Lab/learning-spark/tree/master/examples-java
- https://stackoverflow.com/questions/22252534/how-to-run-a-spark-java-program-from-command-line
- https://stackoverflow.com/questions/23308493/how-to-download-mysql-jdbc-jar-file-on-centos

### Packages

- https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.11/2.3.0








