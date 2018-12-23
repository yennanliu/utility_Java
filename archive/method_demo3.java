import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;



// credit : https://gist.github.com/madan712/8683348

public class method_demo3 {

  public static final String delimiter = ",";
  public static void main(String[] args) {
  // step 1 : csv operation
  String csvFile = "/Users/yennanliu/utility_java/df_test.csv";
  CSVReader.read(csvFile);
  // step 2 : integer operation 
  int integer = 100; 
  square(integer);
  // step 3 sqlite 
  String arg = "some arg";
  parse_sqlite(arg);
}
  
  // ---------------- method 


  public static int print_ (int input)

  {
  System.out.println(input) ; 
  return input; 

  }

  public static int plus (int input)

  {
  System.out.println(input+9) ; 
  return input+9; 

  }


  public static int square (int input)

  {
  System.out.println(input*input ) ; 
  return input*input ; 

  }


  public static void read(String csvFile) {
    try {
      File file = new File(csvFile);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);

      String line = "";

      String[] tempArr;
      while ((line = br.readLine()) != null) {
        tempArr = line.split(delimiter);
        for (String tempStr : tempArr) {
          System.out.print(tempStr + " ");
        }
        System.out.println();
      }
      br.close();

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }


  public static void parse_sqlite( String args )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  name = rs.getString("name");
         int age  = rs.getInt("age");
         String  address = rs.getString("address");
         float salary = rs.getFloat("salary");
         System.out.println( "ID = " + id );
         System.out.println( "NAME = " + name );
         System.out.println( "AGE = " + age );
         System.out.println( "ADDRESS = " + address );
         System.out.println( "SALARY = " + salary );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }


  // ---------------- method 


}

