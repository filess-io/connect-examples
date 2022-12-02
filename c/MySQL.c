#include <stdio.h>
#include <mysql.h>

int main()
{
    char *host = "<$hostname>";
    char *user = "<$user>";
    char *password = "<$password>";
    char *database = "<$database>";
    int port = <$port>;

    MYSQL *conn;
    MYSQL_RES *res;
    MYSQL_ROW row;

    conn = mysql_init(NULL);

    if (!mysql_real_connect(conn, host, user, password, database, port, NULL, 0))
    {
        fprintf(stderr, "%s", mysql_error(conn));
        exit(1);
    }

    // Query 1+1

    if (mysql_query(conn, "SELECT 1+1"))
    {
        fprintf(stderr, "%s", mysql_error(conn));
        exit(1);
    }

    res = mysql_use_result(conn);

    printf("Result of 1+1: ");
    while ((row = mysql_fetch_row(res)) != NULL)
        printf("%s", row[0]);
    printf("\n");

    mysql_free_result(res);
    mysql_close(conn);

    return 0;
}