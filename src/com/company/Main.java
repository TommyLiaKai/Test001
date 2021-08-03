package com.company;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Ship> list = new ArrayList<>();
        //createList(list);
        try {
            list = JDBC.retrieveShipList();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting MySQL database!");
            e.printStackTrace();
        }
        gacha(list);
    }

   public static void gacha(List<Ship> list) {
       int number;
       Boolean SRUR = false;

       for (int i=0; i<10; i++) {
           Random rate = new Random();
           number = rate.nextInt(100);

           if (number>=45) {
               choosingFromList(list, "Common");
           }else if (number>=19) {
               choosingFromList(list, "Rare");
           }else if (number>=5) {
               choosingFromList(list, "Elite");
           }else if (number>=2) {
               choosingFromList(list, "Super Rare");
               SRUR = true;
           }else {
               choosingFromList(list, "Ultra Rare");
               SRUR = true;
           }
           System.out.println(number);
       }
       if (SRUR.equals(false)) {
           choosingFromList(list, "Super Rare");
           System.out.println("Bad luck!!!!");
       }
    }

    public static void choosingFromList(List<Ship> list, String rarityWord) {
        System.out.println(rarityWord);
        List<Ship> newRarityList = getFilteredList(list, rarityWord);
        Ship randShip = pickRandomShip(newRarityList);
        System.out.println(randShip);
        showImage(randShip.getImage());
    }

    public static List<Ship> getFilteredList(List<Ship> list, String rarityWord) {
       return list.stream().filter(p -> p.getRarity().equals(rarityWord)).collect(Collectors.toList());
    }

    public static Ship pickRandomShip(List<Ship> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    public static void showImage(String picture) {
        ImageIcon image = new ImageIcon(picture);
        JLabel label = new JLabel();
        label.setIcon(image);
        createWindow(label);
    }

    public static void createWindow(JLabel label) {
       JFrame frame = new JFrame("Ships");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1210,630);
        frame.setVisible(true);
        frame.add(label);
        closeWindow(frame);
    }

    public static void closeWindow(JFrame frame) {
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                super.mouseClicked(e);
            }
        });
    }
}
