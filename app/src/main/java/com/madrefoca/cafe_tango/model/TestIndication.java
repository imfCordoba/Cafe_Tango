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
        StringBuilder finalIndication = new StringBuilder();

        finalIndication.append(name);
        finalIndication.append(COLON);
        finalIndication.append(indication);
        finalIndication.append(PERIOD);

        return finalIndication.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }
}
