import java.sql.*;

public class SQLite_method_demo
{

  public static void main( String[] args )
  {
  sqlite_insert(0) ; 
  }


  // ---------------- method 

  public static void sqlite_insert (int input)

  {
  //System.out.println('sqlite_insert' ) ; 
  Connection c = null;
  Statement stmt = null;
  Class.forName("org.sqlite.JDBC");
  c = DriverManager.getConnection("jdbc:sqlite:test.db");
  c.setAutoCommit(false);
  System.out.println("Opened database successfully");
  stmt = c.createStatement();
  String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
               "VALUES (5, 'Paul', 32, 'California', 20000.00 );"; 
  stmt.executeUpdate(sql);

  sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
        "VALUES (6, 'Allen', 25, 'Texas', 15000.00 );"; 
  stmt.executeUpdate(sql);

  sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
        "VALUES (7, 'Teddy', 23, 'Norway', 20000.00 );"; 
  stmt.executeUpdate(sql);

  sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
        "VALUES (8, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
  stmt.executeUpdate(sql);

  stmt.close();
  c.commit();
  c.close();
  System.out.println("Records created successfully");


  }

  // ---------------- method 

}