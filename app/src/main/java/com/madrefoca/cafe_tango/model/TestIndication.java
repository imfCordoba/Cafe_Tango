package com.madrefoca.cafe_tango.model;

/**
 * Created by iascierto on 10/8/17.
 */

public class TestIndication extends Indication {

    private String name;
    private String indication;

    private static final String COLON = ": ";
    public static final String PERIOD = ".";

    @Override
    public String indicate() {
        return name + COLON + indication + PERIOD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }
}
