/* 
credit 
https://www.tutorialspoint.com/sqlite/sqlite_java.htm

set up SQLite JDBC
http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
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