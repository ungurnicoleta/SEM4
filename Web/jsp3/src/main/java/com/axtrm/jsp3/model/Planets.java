package com.axtrm.jsp3.model;

public class Planets {
    private int id;
    private String name;
    private String color;
    private String description;


    public Planets(int id, String name, String color, String description) {
        this.id = id;

        this.name = name;

        this.color = color;

        this.description = description;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descr) {
        this.description = descr;
    }

}
