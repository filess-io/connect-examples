import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    public static final String driver = "com.mysql.jdbc.Driver";
    private String url;
    private String username;
    private String password;
    private Connection conn;

    /**
     * Prepares the things for the connection.
     * @param hostname
     * @param database
     * @param port
     * @param username
     * @param password
     */
    public MySQL(String hostname, String database, String port, String username, String password) {
        this.username = username;
        this.password = password;

        this.url = String.format("jdbc:mysql://%s:%s/%s", hostname, port, database);
    }

    public Connection connect() throws ClassNotFoundException, SQLException {

        Class.forName(MySQL.driver);
        conn = DriverManager.getConnection(url, username, password);

        return conn;
    }

    public static void main(String[] args) {
        String hostname = "<$hostname>";
        String database = "<$database>";
        String port = "<$port>";
        String username = "<$username>";
        String password = "<$password>";

        MySQL mysql = new MySQL(hostname, database, port, username, password);
        try {
            Connection conn = mysql.connect();

            System.out.println(String.format("Conected: %b", !conn.isClosed()));
            if (conn.isClosed())
                System.out.println("Terminating as the connection is closed.");
                System.exit(1);

            ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1+1");
            if (resultSet.next()) System.out.println(String.format("Result of query: %s", resultSet.getInt("1+1")));

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de MySQL");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Ha ocurrido un error ajeno a MySQL");
            e.printStackTrace();
        }
    }
}