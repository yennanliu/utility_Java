/* 
credit 
https://www.tutorialspoint.com/sqlite/sqlite_java.htm

set up SQLite JDBC
http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
*/


/*
# download SQLite JDBC
# https://bitbucket.org/xerial/sqlite-jdbc/downloads/
# move downloaded SQLite JDBC to the java route (or to current route and run with "-classpath" command)
# http://jashliao.pixnet.net/blog/post/222225249-sqlite-%E2%80%93%C2%A0java
# compile 
$ javac SQLiteJDBC.java
# run the java script
$ java -classpath ".:sqlite-jdbc-3.21.0.jar" SQLiteJDBC

*/


import java.sql.*;

public class SQLiteJDBC {
  public static void main( String args[] ) {
      Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC"); 
         /*Class.forName("/Users/yennanliu/utility_java/org.sqlite.JDBC");*/
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
}