package com.intexsoft.nikita.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static Connection getMySQLConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/task_tracker",
                            "root",
                            "rVRGAhoi913!");
                System.out.println("Got our connection");
        } catch (SQLException e) {
            System.out.println("Disconnect or bad request");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
