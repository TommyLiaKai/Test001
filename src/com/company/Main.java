package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Ship> list = new ArrayList<>();
        //Gacha.createList(list);
        try {
            //JDBC.deleteAllRows();
            //JDBC.post(list);
            //list.clear();
            list = JDBC.retrieveShipList();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting MySQL database!");
            e.printStackTrace();
        }
        Gacha.summoning(list);
    }
}
