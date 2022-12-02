using System;
using MongoDB.Driver;

public class MongoDB
{
    public static void Main()
    {

        uri = "mongodb://<$user>:<$password>@<$hostname>:<$port>/<$database>";
        MongoClient dbClient = new MongoClient(uri);

        // ping
        var ping = dbClient.GetDatabase("admin").RunCommandAsync((Command<BsonDocument>)"{ping:1}").Result;
        Console.WriteLine(ping.ToJson());

        Console.WriteLine("Done.");
        dbClient = null;
    }
}
