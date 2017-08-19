package com.madrefoca.cafe_tango.services;

import com.madrefoca.cafe_tango.model.Illness;

import java.util.List;

/**
 * Created by iascierto on 19/8/17.
 */

public class SearchCriteria {

    private List<Illness> illnesses;
    private List<SchoolHouse> schoolHouses;
    private List<SubClasification> subClasifications;

    private Illness searchedIllness;
    private SchoolHouse searchedSchoolHouse;
    private SubClasification searchedSubClasification;

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

    public List<SubClasification> getSubClasifications() {
        return subClasifications;
    }

    public void setSubClasifications(List<SubClasification> subClasifications) {
        this.subClasifications = subClasifications;
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

    public SubClasification getSearchedSubClasification() {
        return searchedSubClasification;
    }

    public void setSearchedSubClasification(SubClasification searchedSubClasification) {
        this.searchedSubClasification = searchedSubClasification;
    }
}
