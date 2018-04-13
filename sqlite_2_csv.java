import java.sql.*;

// credit 
// https://www.tutorialspoint.com/javaexamples/jdbc_executebatch.htm

public class sqlite_2_csv {
   public static void main(String[] args) throws Exception {
      Class.forName("org.sqlite.JDBC");
      Connection con = DriverManager.getConnection("jdbc:sqlite:test.db","name","pass");
      
      //Statement stmt = con.createStatement(
      //   ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      Statement stmt = con.createStatement();
      
      String insertEmp1 = ".mode csv;";
      String insertEmp2 = ".output sqlite_out.csv ;";
      String insertEmp3 = "select * from company;";
      String insertEmp4 = ".output stdout ; ";
      con.setAutoCommit(false);
      
      stmt.addBatch(insertEmp1);
      stmt.addBatch(insertEmp2);
      stmt.addBatch(insertEmp3);
      stmt.addBatch(insertEmp3);
      
      ResultSet rs = stmt.executeQuery("select * from company");
      //rs.last();
      //System.out.println("rows before batch execution= "+ rs.getRow());
      stmt.executeBatch();
      con.commit();
      
   }
} 