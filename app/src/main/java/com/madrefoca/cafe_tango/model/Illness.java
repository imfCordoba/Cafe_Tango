package com.madrefoca.cafe_tango.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Fernando on 8/6/2017.
 */
@DatabaseTable(tableName = "Illnesses")
public class Illness {

    @DatabaseField(generatedId = true)
    private Integer illnessId;

    @DatabaseField
    private String illnessName;

    @DatabaseField
    private String description;

    public Illness() {

    }

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
    }

    public Illness(int illnessId, String name, String description) {
        this.illnessName = name;
        this.description = description;
    }

    public Illness(String name, String description) {
        this.illnessName = name;
        this.description = description;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String name) {
        this.illnessName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
