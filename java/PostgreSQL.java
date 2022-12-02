import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class PostgreSQL {
   public static void main(String args[]) {
      String hostname = "<$hostname>";
      String database = "<$database>";
      String port = "<$port>";
      String username = "<$user>";
      String password = "<$password>";

      Connection cconn = null;
      try {
         Class.forName("org.postgresql.Driver");
         Connection conn = DriverManager
               .getConnection("jdbc:postgresql://" + hostname + ":" + port + "/" + database,
                     username, password);
         System.out.println("Opened database successfully");

         // select 1+1
         ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1+1");
         if (resultSet.next())
            System.out.println(String.format("Result of query: %s", resultSet.getInt("1+1")));

      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}