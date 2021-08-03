package com.company;

import java.sql.*;

public class JDBC {

    private static final String url = "jdbc:mysql://localhost:3306/testinga";
    private static final String user = "root";
    private  static final String password = "";

    public static Connection dbInit() throws SQLException {

        Connection dbConnection = DriverManager.getConnection(url, user, password);

        if (dbConnection != null) {
            System.out.println("Successfully connected to MySQL database test!");
        }
        return dbConnection;
    }
}
