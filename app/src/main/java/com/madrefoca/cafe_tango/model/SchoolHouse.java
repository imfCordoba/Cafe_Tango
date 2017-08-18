package com.madrefoca.cafe_tango.model;

/**
 * Created by Mauro on 17/08/2017.
 */

public class SchoolHouse {

    private String name;
    private String description;

    public SchoolHouse() {
    }

    public SchoolHouse(String name, String description) {
        this.name = name;
        this.description = description;
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
