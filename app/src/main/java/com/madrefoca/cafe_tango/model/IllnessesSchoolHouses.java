package com.madrefoca.cafe_tango.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by fernando on 26/08/17.
 */
@DatabaseTable(tableName = "Illnesses_SchoolHouses")
public class IllnessesSchoolHouses {

    @DatabaseField(generatedId = true, columnName = "Illnesses_schoolHouseId")
    private Integer id;

    // This is a foreign object which just stores the id from the Illness object in this table.
    @DatabaseField(foreign = true, columnName = "illnessId")
    private Illness illness;

    // This is a foreign object which just stores the id from the SchoolHouse object in this table.
    @DatabaseField(foreign = true, columnName = "schoolHouseId")
    private SchoolHouse schoolHouse;

    public IllnessesSchoolHouses() {

    }

    public IllnessesSchoolHouses(Illness illness, SchoolHouse schoolHouse) {
        this.illness = illness;
        this.schoolHouse = schoolHouse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public SchoolHouse getSchoolHouse() {
        return schoolHouse;
    }

    public void setSchoolHouse(SchoolHouse schoolHouse) {
        this.schoolHouse = schoolHouse;
    }
}
