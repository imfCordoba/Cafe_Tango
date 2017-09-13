package com.madrefoca.cafe_tango.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Mauro on 17/08/2017.
 */
@DatabaseTable(tableName = "SubClassifications")
public class SubClassification {

    @DatabaseField(generatedId = true)
    private Integer subClassificationId;

    @DatabaseField(foreign = true, columnName = "schoolHouseId")
    private SchoolHouse schoolHouse;

    @DatabaseField
    private String name;

    public SubClassification() {
    }

    public Integer getSubClassificationId() {
        return subClassificationId;
    }

    public void setSubClassificationId(Integer subClassificationId) {
        this.subClassificationId = subClassificationId;
    }

    public SchoolHouse getSchoolHouse() {
        return schoolHouse;
    }

    public void setSchoolHouse(SchoolHouse schoolHouse) {
        this.schoolHouse = schoolHouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
