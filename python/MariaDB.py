import mysql.connector
from mysql.connector import Error

hostname = "<$hostname>"
database = "<$database>"
port = "<$port>"
username = "<$user>"
password = "<$password>"

try:
    connection = mysql.connector.connect(host=hostname, database=database, user=username, password=password, port=port)
    if connection.is_connected():
        db_Info = connection.get_server_info()
        print("Connected to MariaDB Server version ", db_Info)
        cursor = connection.cursor()
        cursor.execute("select database();")
        record = cursor.fetchone()
        print("You're connected to database: ", record)

except Error as e:
    print("Error while connecting to MariaDB", e)
finally:
    if connection.is_connected():
        cursor.close()
        connection.close()
        print("MariaDB connection is closed")

