package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
//                "root", ""); // getting the db connection
//        Statement statement = connection.createStatement(); // creating an empty statement
//        statement.execute("create table person_3 (id int, name varchar(30))"); // filling statement obj with a query and then executing it

//        Thread.sleep(20000);


    }
}
