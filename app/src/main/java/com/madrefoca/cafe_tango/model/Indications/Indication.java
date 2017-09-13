package com.madrefoca.cafe_tango.model.Indications;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.madrefoca.cafe_tango.model.Medicine;
import com.madrefoca.cafe_tango.model.Treatment;

/**
 * Created by iascierto on 10/8/17.
 */

@DatabaseTable(tableName = "Indications")
public abstract class Indication {

    @DatabaseField(generatedId = true)
    private Integer indicationId;

    @DatabaseField(foreign = true, columnName = "treatmentId")
    private Treatment treatment;

    @DatabaseField(foreign = true, dataType = DataType.ENUM_INTEGER, columnName = "indicationTypeId")
    private IndicationType indicationType;

    //This one can will only have a value if IndicationType == MEDICINE_INDICATION
    @DatabaseField(foreign = true, columnName = "medicineId")
    private Medicine medicine;

    public Indication() {
    }

    //Abstract Method to be overwritten
    public abstract String indicate();

    public Integer getIndicationId() {
        return indicationId;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public IndicationType getIndicationType() {
        return indicationType;
    }

    public void setIndicationType(IndicationType indicationType) {
        this.indicationType = indicationType;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
