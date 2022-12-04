#include <mongoc.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc,
         char *argv[])
{
    mongoc_collection_t *collection;
    mongoc_client_t *client;
    bson_error_t error;
    int64_t count;
    bson_t query;
    bool r;

    /* get a handle to our collection */
    client = mongoc_client_new("mongodb://<$user>:<$password>@<$hostname>:<$port>/");
    collection = mongoc_client_get_collection(client, "<$database>", "test");

    /* count all documents matching {hello: "world!"} */
    bson_init(&query);
    BSON_APPEND_UTF8(&query, "hello", "world!");
    count = mongoc_collection_count(collection, MONGOC_QUERY_NONE, &query, 0, 0, NULL, &error);
    if (count < 0)
    {
        fprintf(stderr, "%s\n", error.message);
        return EXIT_FAILURE;
    }

    printf("Found %" PRId64 " documents in %s\n",
           count,
           mongoc_collection_get_name(collection));

    /* release everything */
    mongoc_collection_destroy(collection);
    mongoc_client_destroy(client);
    bson_destroy(&query);

    return 0;
}