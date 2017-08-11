package com.madrefoca.cafe_tango.model;

/**
 * Created by iascierto on 10/8/17.
 */

public class MedicineIndication extends Indication {

    private int amount;
    private double frequency;
    private double period;
    private Medicine medicine;

    @Override
    public String indicate() {
        //TODO indicar indicación de Medicamento

        return null;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Medicine getMedicine() {
        return medicine;
    }
}
