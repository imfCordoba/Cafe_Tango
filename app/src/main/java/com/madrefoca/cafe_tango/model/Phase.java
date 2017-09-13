package com.madrefoca.cafe_tango.model;

import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Mauro on 17/08/2017.
 */
@DatabaseTable
public enum Phase {

    INITIAL,
    MONITOR,
    CONTROL;
}
