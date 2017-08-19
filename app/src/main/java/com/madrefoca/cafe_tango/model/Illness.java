package com.madrefoca.cafe_tango.model;

/**
 * Created by Fernando on 8/6/2017.
 */

public class Illness {
    private int id;
    private String name;
    private String description;

    public Illness(){

    }

    public Illness(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Illness(String name, String description){
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
