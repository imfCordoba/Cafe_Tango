package com.madrefoca.cafe_tango.model;

import java.util.List;

/**
 * Created by Mauro on 17/08/2017.
 */

public class Treatment {

    private String name;
    private List<Phase> phases;

    public Treatment() {
    }

    public Treatment(String name, List phases) {
        this.name = name;
        this.phases = phases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }
}
