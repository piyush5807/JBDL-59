import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        // Task - You need to create a table in a sql db (pg / mysql / oracle)

        // Host, Port - IP address of a machine // localhost 127.0.0.1

        // Mysql - 3306, postgres - 5432
        // jdbc url
        // create table person (id int, name varchar(30));
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", ""); // getting the db connection
        Statement statement = connection.createStatement(); // creating an empty statement
        statement.execute("create table person (id int, name varchar(30))"); // filling statement obj with a query and then executing it
    }
}