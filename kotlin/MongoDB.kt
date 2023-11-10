import com.mongodb.client.MongoClients

fun main() {
    val hostname = "<$hostname>"
    val database = "<$database>"
    val port = "<$port>"
    val username = "<$user>"
    val password = "<$password>"
    val connectionString = String.format("mongodb://%s:%s@%s:%s/%s", username, password, hostname, port, database)
    MongoClients.create(connectionString).use { mongoClient ->
        val databases = mongoClient.listDatabases().into(ArrayList())
        databases.forEach {
            println(it.toJson())
        }
    }
}
