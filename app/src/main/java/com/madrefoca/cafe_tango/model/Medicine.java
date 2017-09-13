package com.madrefoca.cafe_tango.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by iascierto on 10/8/17.
 */

@DatabaseTable(tableName = "Medicines")
public class Medicine {

    @DatabaseField(generatedId = true)
    private Integer medicineId;

    @DatabaseField
    private String tradeName;

    @DatabaseField
    private String drugName;

    @DatabaseField
    private String pharmacology;

    @DatabaseField
    private String presentation;

    @DatabaseField
    private String concentration;

    @DatabaseField
    private String indications;

    @DatabaseField
    private String contraindications;

    @DatabaseField
    private String preservation;

    @DatabaseField
    private String interactions;

    public Medicine() {

    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getPharmacology() {
        return pharmacology;
    }

    public void setPharmacology(String pharmacology) {
        this.pharmacology = pharmacology;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getPreservation() {
        return preservation;
    }

    public void setPreservation(String preservation) {
        this.preservation = preservation;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }
}
