package com.madrefoca.cafe_tango.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.madrefoca.cafe_tango.model.Indications.Indication;

import java.util.List;

/**
 * Created by Mauro on 17/08/2017.
 */

@DatabaseTable(tableName = "Treatments")
public class Treatment {

    @DatabaseField(generatedId = true)
        private Integer treatmentId;

    @DatabaseField
    private String name;

    @DatabaseField
    private String description;

    public Treatment() {
    }

    public Integer getTreatmentId() {
        return treatmentId;
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
