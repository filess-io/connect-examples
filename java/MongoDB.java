import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    public static void main(String[] args) {
        String hostname = "<$hostname>";
        String database = "<$database>";
        String port = "<$port>";
        String username = "<$user>";
        String password = "<$password>";

        String connectionString = String.format("mongodb://%s:%s@%s:%s/%s", username, password, hostname, port, database);
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}
