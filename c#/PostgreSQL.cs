using System;
using Npgsql;

public class PostgreSQL
{
    // Obtain connection string information
    //
    private static string Host = "<$hostname>";
    private static string User = "<$user>";
    private static string DBname = "<$database>";
    private static string Password = "<$password>";
    private static string Port = "<$port>";

    static void Main(string[] args)
    {
        // Build connection string using parameters
        //
        string connString =
            String.Format(
                "Server={0};Username={1};Database={2};Port={3};Password={4};SSLMode=Prefer",
                Host,
                User,
                DBname,
                Port,
                Password);


        using (var conn = new NpgsqlConnection(connString))

        {
            Console.Out.WriteLine("Opening connection");
            conn.Open();

            // select version();
            //
            using (var cmd = new NpgsqlCommand("SELECT version();", conn))
            {
                var version = cmd.ExecuteScalar().ToString();
                Console.Out.WriteLine("PostgreSQL version: " + version);
            }

            // close the connection
            conn.Close();
        }

        Console.WriteLine("Press RETURN to exit");
        Console.ReadLine();
    }
}
