package com.axtrm.jsp3.model;

public class Civilisations {
    private int id;
    private String name;
    private int homePlanetID;
    private int type;


    public Civilisations(int id, String name, int homePlanetID, int type) {
        this.id = id;

        this.name = name;

        this.homePlanetID = homePlanetID;

        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHomePlanetID() {
        return homePlanetID;
    }

    public void setHomePlanetID(int homePlanetID) {
        this.homePlanetID = homePlanetID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
