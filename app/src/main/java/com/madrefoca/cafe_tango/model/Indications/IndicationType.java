package com.madrefoca.cafe_tango.model.Indications;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by iascierto on 12/9/17.
 */

@DatabaseTable(tableName = "IndicationTypes")
public enum IndicationType {

    MEDICINE_INDICATION,
    TEST_INDICATION,
    GENERIC_INDICATION,
    EXCERCISE_INDICATION;
}
