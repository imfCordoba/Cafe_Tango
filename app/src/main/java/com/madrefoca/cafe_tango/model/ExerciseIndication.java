package com.madrefoca.cafe_tango.model;

import com.madrefoca.cafe_tango.helpers.IndicationsHelper;

/**
 * Created by iascierto on 10/8/17.
 */

public class ExerciseIndication extends Indication {

    private String name;
    private long frequency;

    public static final String COLON = ": ";
    public static final String WEEKLY = " semanales.";

    @Override
    public String indicate() {
        StringBuilder finalIndication = new StringBuilder();

        finalIndication.append(name);
        finalIndication.append(COLON);
        //finalIndication.append(IndicationsHelper.formatTerm(frequency));
        finalIndication.append(WEEKLY);

        return finalIndication.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }
}
