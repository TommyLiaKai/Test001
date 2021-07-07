package com.company;

public class Ship {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Ship(String name, String rarity, String type, String nationality, String image) {
        this.name = name;
        this.rarity = rarity;
        this.type = type;
        this.nationality = nationality;
        this.image = image;
    }

    private String name;
    private String rarity;
    private String type;
    private String nationality;
    private String image;


    public String toString() {
        return "Name: " + name + ", Rarity: " + rarity + ", Type: " + type + ", Nationality: " + nationality + "\n";
    }
}
