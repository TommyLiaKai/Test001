package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GachaTest {

    @Test
    public void summoning() {
        List<Ship> list = new ArrayList<>();
        list.add(new Ship("Eagle", "Elite", "Aircraft Carrier", "USA", "EagleShip.jpg"));
        list.add(new Ship("Jean Bart", "Super Rare", "BattleShip", "France", "JeanBartShip.jpg"));
        list.add(new Ship("Saint Louis", "Super Rare", "Heavy Cruiser", "France", "SaintLouisShip.jpg"));
        list.add(new Ship("Omaha", "Common", "Light Cruiser", "USA", "OmahaShip.jpg"));
        list.add(new Ship("Shinano", "Ultra Rare", "Aircraft Carrier", "Japan", "ShinanoShip.jpg"));
        list.add(new Ship("Curacoa", "Rare", "Light Cruiser", "Great Britain", "CuracoaShip.jpg"));

        Gacha.summoning(list);
    }
}