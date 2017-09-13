package com.madrefoca.cafe_tango.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.table.DatabaseTable;
import com.madrefoca.cafe_tango.model.Illness;
import com.madrefoca.cafe_tango.model.SchoolHouse;
import com.madrefoca.cafe_tango.model.SubClassification;
import com.madrefoca.cafe_tango.model.Treatment;
import java.util.List;

/**
 * Created by iascierto on 19/8/17.
 */

@DatabaseTable(tableName = "Subclasifications_Phases_Treatment")
public class SearchCriteria {

    @DatabaseField(generatedId = true, columnName = "subclasifications_phaseId")
    private Integer searchCriteriaId;

    @DatabaseField(foreign = true, columnName = "subclasificationId")
    private SubClassification subClassification;

    @DatabaseField(foreign = true, dataType = DataType.ENUM_INTEGER, columnName = "phaseId")
    private Phase phase;

    @DatabaseField(foreign = true, columnName = "treatmentId")
    private Treatment treatment;

    public SearchCriteria() {
    }

    public Integer getSearchCriteriaId() {
        return searchCriteriaId;
    }

    public SubClassification getSubClassification() {
        return subClassification;
    }

    public void setSubClassification(SubClassification subClassification) {
        this.subClassification = subClassification;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
