package com.company;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Ship> list = new ArrayList<>();
        createList(list);
        gacha(list);
    }

   public static void createList(List<Ship> list) {
        list.add(new Ship("Laffey", "Elite", "Destroyer", "USA", "LaffeyShip.jpg"));
        list.add(new Ship("Warspite", "Ultra Rare", "Battleship", "Great Britain", "WarspiteShip.jpg"));
        list.add(new Ship("Enterprise", "Super Rare", "Aircraft Carrier", "USA", "EnterpriseShip.jpg"));
        list.add(new Ship("Southampton", "Rare", "Light Cruiser", "Great Britain", "SouthamptonShip.jpg"));
        list.add(new Ship("Pensacola", "Common", "Heavy Cruiser", "USA", "PensacolaShip.jpg"));
        list.add(new Ship("Vittorio Veneto", "Super Rare", "Battleship", "Italy", "VenetoShip.jpg"));
        list.add(new Ship("Yat Sen", "Elite", "Light Crusader", "China", "YatSenShip.jpg"));
        list.add(new Ship("Kisaragi", "Common", "Destroyer", "Japan", "KisaragiShip.jpg"));
        list.add(new Ship("Shinano", "Ultra Rare", "Aircraft Carrier", "Japan", "ShinanoShip.jpg"));
        list.add(new Ship("Spence", "Common", "Destroyer", "USA", "SpenceShip.jpg"));
        list.add(new Ship("New Castle", "Elite", "Light Cruiser", "Great Britain", "NewCastleShip.jpg"));
        list.add(new Ship("Friedrich Der Grosse", "Ultra Rare", "Battleship", "Germany", "FriedrichShip.jpg"));
        list.add(new Ship("Curacoa", "Rare", "Light Cruiser", "Great Britain", "CuracoaShip.jpg"));
        list.add(new Ship("Trento", "", "Heavy Cruiser", "Italy", "TrentoShip.jpg"));
        list.add(new Ship("Hunter", "Rare", "Destroyer", "Great Britain", "HunterShip.jpg"));
        list.add(new Ship("Hardy", "Elite", "Destroyer", "Great Britain", "HardyShip.jpg"));
        list.add(new Ship("Jean Bart", "Super Rare", "BattleShip", "France", "JeanBartShip.jpg"));
        list.add(new Ship("Saint Louis", "Super Rare", "Heavy Cruiser", "France", "SaintLouisShip.jpg"));
        list.add(new Ship("Omaha", "Common", "Light Cruiser", "USA", "OmahaShip.jpg"));
        list.add(new Ship("Eagle", "Elite", "Aircraft Carrier", "USA", "EagleShip.jpg"));
        System.out.println(list);
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
