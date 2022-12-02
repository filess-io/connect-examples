using System;
using System.Data;

using MySql.Data;
using MySql.Data.MySqlClient;

public class MariaDB
{
    public static void Main()
    {
        string connStr = "server=<$hostname>;user=<$user>;database=<$database>;port=<$port>;password=<$password>";
        MySqlConnection conn = new MySqlConnection(connStr);
        try
        {
            Console.WriteLine("Connecting to MySQL...");
            conn.Open();

            string sql = "SELECT 1+1";
            MySqlCommand cmd = new MySqlCommand(sql, conn);
            MySqlDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                Console.WriteLine(rdr[0]);
            }

            rdr.Close();
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
        }

        conn.Close();
        Console.WriteLine("Done.");
    }
}