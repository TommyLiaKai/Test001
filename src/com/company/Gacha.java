package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Gacha {

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
        list.add(new Ship("Trento", "Rare", "Heavy Cruiser", "Italy", "TrentoShip.jpg"));
        list.add(new Ship("Hunter", "Rare", "Destroyer", "Great Britain", "HunterShip.jpg"));
        list.add(new Ship("Hardy", "Elite", "Destroyer", "Great Britain", "HardyShip.jpg"));
        list.add(new Ship("Jean Bart", "Super Rare", "BattleShip", "France", "JeanBartShip.jpg"));
        list.add(new Ship("Saint Louis", "Super Rare", "Heavy Cruiser", "France", "SaintLouisShip.jpg"));
        list.add(new Ship("Omaha", "Common", "Light Cruiser", "USA", "OmahaShip.jpg"));
        list.add(new Ship("Eagle", "Elite", "Aircraft Carrier", "USA", "EagleShip.jpg"));
    }

    public static void summoning(List<Ship> list) {
        Boolean srurExist = false;
        for (int i=0; i<9; i++) {
           srurExist = summonRates(list, srurExist);
        }
        if (srurExist.equals(false)) {
            choosingFromList(list, "Super Rare");
            System.out.println("Bad luck!!!!");
        }else {
            summonRates(list, true);
            System.out.println("Congrats!!!!");
        }
    }

    private static boolean summonRates(List<Ship> list, boolean srurExist) {
        int number;
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
            srurExist = true;
        }else {
            choosingFromList(list, "Ultra Rare");
            srurExist = true;
        }
        System.out.println("Rolled: " + number + "\n");
        return srurExist;
    }

    private static void choosingFromList(List<Ship> list, String rarityWord) {
        System.out.println(rarityWord);
        List<Ship> newRarityList = getFilteredList(list, rarityWord);
        Ship randShip = pickRandomShip(newRarityList);
        System.out.println(randShip);
        WindowGUI.showImage(randShip.getImage());
    }

    private static List<Ship> getFilteredList(List<Ship> list, String rarityWord) {
        return list.stream()
                .filter(ship -> ship.getRarity().equals(rarityWord))
                .sorted(Comparator.comparing(ship -> ship.getName()))
                .collect(Collectors.toList());
    }

    private static Ship pickRandomShip(List<Ship> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
