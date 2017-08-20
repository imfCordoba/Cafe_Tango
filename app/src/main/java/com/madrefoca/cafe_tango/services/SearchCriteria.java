package com.madrefoca.cafe_tango.services;

import com.madrefoca.cafe_tango.model.Illness;
import com.madrefoca.cafe_tango.model.SchoolHouse;
import com.madrefoca.cafe_tango.model.SubClassification;
import com.madrefoca.cafe_tango.model.Treatment;

import java.util.List;

/**
 * Created by iascierto on 19/8/17.
 */

public class SearchCriteria {

    private List<Illness> illnesses;
    private List<SchoolHouse> schoolHouses;
    private List<SubClassification> subClassifications;

    private Illness searchedIllness;
    private SchoolHouse searchedSchoolHouse;
    private SubClassification searchedSubClassification;

    public Treatment search() {
        //TODO armar el search usando los atributos "searched..."

        return null;
    }

    public List<Illness> getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(List<Illness> illnesses) {
        this.illnesses = illnesses;
    }

    public List<SchoolHouse> getSchoolHouses() {
        return schoolHouses;
    }

    public void setSchoolHouses(List<SchoolHouse> schoolHouses) {
        this.schoolHouses = schoolHouses;
    }

    public List<SubClassification> getSubClassifications() {
        return subClassifications;
    }

    public void setSubClassifications(List<SubClassification> subClassifications) {
        this.subClassifications = subClassifications;
    }

    public Illness getSearchedIllness() {
        return searchedIllness;
    }

    public void setSearchedIllness(Illness searchedIllness) {
        this.searchedIllness = searchedIllness;
    }

    public SchoolHouse getSearchedSchoolHouse() {
        return searchedSchoolHouse;
    }

    public void setSearchedSchoolHouse(SchoolHouse searchedSchoolHouse) {
        this.searchedSchoolHouse = searchedSchoolHouse;
    }

    public SubClassification getSearchedSubClassification() {
        return searchedSubClassification;
    }

    public void setSearchedSubClassification(SubClassification searchedSubClassification) {
        this.searchedSubClassification = searchedSubClassification;
    }
}
