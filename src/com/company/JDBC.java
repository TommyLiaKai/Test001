package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

    final private String url = "jdbc:mysql://localhost:3306/shipstest";
    final private String user = "root";
    final private String password = "";

    private Connection dbInit() throws SQLException {

        Connection dbConnection = DriverManager.getConnection(url, user, password);

        if (dbConnection != null) {
            System.out.println("Successfully connected to MySQL database!");
        }
        return dbConnection;
    }

    public static void post(List<Ship> ships) throws SQLException {
        Connection connection = new JDBC().dbInit();
        System.out.println("Writing to database...");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ships (name, rarity, type, nationality, image) VALUES (?,?,?,?,?)");

        for (Ship n: ships) {
            preparedStatement.setString(1, n.getName());
            preparedStatement.setString(2, n.getRarity());
            preparedStatement.setString(3, n.getType());
            preparedStatement.setString(4, n.getNationality());
            preparedStatement.setString(5, n.getImage());
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
        connection.close();
    }

    public static List<Ship> retrieveShipList() throws SQLException {
        Connection connection = new JDBC().dbInit();
        System.out.println("Getting from database...");
        List<Ship> ships = new ArrayList<>();
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = connection.prepareStatement("Select * from ships");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Ship ship = new Ship(resultSet.getString("name"),resultSet.getString("rarity"),
                    resultSet.getString("type"),resultSet.getString("nationality"),resultSet.getString("image"));
            ships.add(ship);
        }
        preparedStatement.close();
        connection.close();
        return ships;
    }

    public static void deleteAllRows() throws SQLException {
        Connection connection = new JDBC().dbInit();
        PreparedStatement preparedStatement = connection.prepareStatement("truncate ships");
        preparedStatement.executeUpdate();
        System.out.println("Deleting all rows from database...");
        preparedStatement.close();
        connection.close();
    }
}
