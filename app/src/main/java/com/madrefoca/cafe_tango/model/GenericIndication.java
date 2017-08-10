package com.madrefoca.cafe_tango.model;

/**
 * Created by iascierto on 10/8/17.
 */

public class GenericIndication extends Indication {

    private String indication;

    @Override
    public String indicate() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }
}
