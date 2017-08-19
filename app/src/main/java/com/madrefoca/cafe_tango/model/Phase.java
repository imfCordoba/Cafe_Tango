package com.madrefoca.cafe_tango.model;

import java.util.List;

/**
 * Created by Mauro on 17/08/2017.
 */

public class Phase {

    private PhasesEnum phase;
    private String description;
    private List<Indication> indications;

    public Phase() {
    }

    public Phase(PhasesEnum phase, String description, List<Indication> indications) {
        this.phase = phase;
        this.description = description;
        this.indications = indications;
    }

    public PhasesEnum getPhase() {
        return phase;
    }

    public void setPhase(PhasesEnum phase) {
        this.phase = phase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Indication> getIndications() {
        return indications;
    }

    public void setIndications(List<Indication> indications) {
        this.indications = indications;
    }
}
