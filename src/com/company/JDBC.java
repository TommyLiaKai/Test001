package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

    private static final String url = "jdbc:mysql://localhost:3306/shipstest";
    private static final String user = "root";
    private static final String password = "";

    private static Connection dbInit() throws SQLException {

        Connection dbConnection = DriverManager.getConnection(url, user, password);

        if (dbConnection != null) {
            System.out.println("Successfully connected to MySQL database!");
        }
        return dbConnection;
    }

    public static void post(List<Ship> ships) throws SQLException {
        Connection connection = dbInit();
        System.out.println("Writing to database...");
        PreparedStatement posted = connection.prepareStatement("INSERT INTO ships (id, name, rarity, type, nationality, image) VALUES (?,?,?,?,?,?)");
        int i = 0;

        for (Ship n: ships) {
            posted.setInt(1, i);
            posted.setString(2, n.getName());
            posted.setString(3, n.getRarity());
            posted.setString(4, n.getType());
            posted.setString(5, n.getNationality());
            posted.setString(6, n.getImage());
            posted.executeUpdate();
            i++;
        }
        posted.close();
        connection.close();
    }

    public static List<Ship> retrieveShipList() throws SQLException {
        Connection connection = dbInit();
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
        connection.close();
        return ships;
    }
}
