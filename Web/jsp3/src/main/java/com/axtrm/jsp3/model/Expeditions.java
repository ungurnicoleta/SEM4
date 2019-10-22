package com.axtrm.jsp3.model;

public class Expeditions {
    private int id;
    private int astronautID;
    private int planetID;
    private float deathProbability;

    public Expeditions(int id, int astronautID, int planetID, float deathProbability) {
        this.id = id;

        this.astronautID = astronautID;

        this.planetID = planetID;

        this.deathProbability = deathProbability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAstronautID() {
        return astronautID;
    }

    public void setAstronautID(int astronautID) {
        this.astronautID = astronautID;
    }

    public int getPlanetID() {
        return planetID;
    }

    public void setPlanetID(int planetID) {
        this.planetID = planetID;
    }


    public float getDeathProbability() {
        return deathProbability;
    }

    public void setDeathProbability(float deathProbability) {
        this.deathProbability = deathProbability;
    }
}
