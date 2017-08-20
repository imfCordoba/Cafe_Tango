package com.madrefoca.cafe_tango.model;

import com.madrefoca.cafe_tango.helpers.IndicationsHelper;

/**
 * Created by iascierto on 10/8/17.
 */

public class ExerciseIndication extends Indication {

    private String name;
    private long frequency;

    private static final String COLON = ": ";
    private static final String WEEKLY = " semanales.";

    @Override
    public String indicate() {
        //TODO revisar si queremos indicar ejericio de manera semanal u otra

        return name + COLON + IndicationsHelper.formatTerm(frequency) + WEEKLY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }
}
