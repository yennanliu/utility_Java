# utility_Java
- //dev 
- `learning Java from scratch`


### Quick start

```bash
# --- run the simplist app --- 
# compile 
$ javac HelloWorld.java
# run java script 
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


### Reference 

- http://www.runoob.com/sqlite/sqlite-java.html
- https://github.com/OSE-Lab/learning-spark/tree/master/examples-java

### Packages

- https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.11/2.3.0








