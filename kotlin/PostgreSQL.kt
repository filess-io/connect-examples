import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import kotlin.system.exitProcess

const val driver = "org.postgresql.Driver"

class PostgreSQL(
    hostname: String,
    database: String,
    port: String,
    private val username: String,
    private val password: String
) {
    private val url: String = "jdbc:mysql://$hostname:$port/$database"
    private lateinit var conn: Connection

    fun connect(): Connection {
        Class.forName(driver)
        conn = DriverManager.getConnection(url, username, password)
        return conn
    }
}

fun main(args: Array<String>) {
    val hostname = "<$hostname>"
    val database = "<$database>"
    val port = "<$port>"
    val username = "<$user>"
    val password = "<$password>"
    val mysql = PostgreSQL(hostname, database, port, username, password)
    mysql.connect().use { conn ->
        println(String.format("Conected: %b", !conn.isClosed))
        if (conn.isClosed) {
            println("Terminating as the connection is closed.")
            exitProcess(1)
        }
        conn.createStatement().executeQuery("SELECT 1+1").use {resultSet ->
            if (resultSet.next()) {
                println("Result of query ${resultSet.getInt("1+1")}: %s")
            }
        }
    }
}
