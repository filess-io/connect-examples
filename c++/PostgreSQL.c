#include <stdio.h>
#include <stdlib.h>
#include <libpq-fe.h>

void do_exit(PGconn *conn)
{

    PQfinish(conn);
    exit(1);
}

int main()
{
    PGconn *conn = PQconnectdb("hostaddr=<$hostname> port=<$port> dbname=<$database> user=<$user> password=<$password>");

    if (PQstatus(conn) == CONNECTION_BAD)
    {

        fprintf(stderr, "Connection to database failed: %s\n",
                PQerrorMessage(conn));
        do_exit(conn);
    }

    int ver = PQserverVersion(conn);

    printf("Server version: %d\n", ver);

    PQfinish(conn);

    return 0;
}