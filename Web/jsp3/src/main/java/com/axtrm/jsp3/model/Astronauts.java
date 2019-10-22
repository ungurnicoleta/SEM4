package com.axtrm.jsp3.model;

public class Astronauts {
    private int id;
    private String username;
    private int civilisationID;

    public Astronauts(int id, String name, int civilisationID) {
        this.id = id;

        this.username = username;

        this.civilisationID = civilisationID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public int getCivilisationID() {
        return civilisationID;
    }

    public void setCivilisationID(int civilisationID) {
        this.civilisationID = civilisationID;
    }
}
