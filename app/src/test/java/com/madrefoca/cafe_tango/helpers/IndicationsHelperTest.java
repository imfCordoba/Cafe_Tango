package com.madrefoca.cafe_tango.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by iascierto on 10/8/17.
 */
public class IndicationsHelperTest {

    @Test
    public void formatSingleDay() throws Exception {
        assertEquals("1 día" , IndicationsHelper.formatTerm(86400000));
    }

    @Test
    public void formatSeveralDays() throws Exception {
        assertEquals("5 días" , IndicationsHelper.formatTerm(432000000));
    }

    @Test
    public void formatOneHour() throws Exception {
        assertEquals("1 hora" , IndicationsHelper.formatTerm(3600000));
    }

    @Test
    public void formatSeveralHours() throws Exception {
        assertEquals("6 horas" , IndicationsHelper.formatTerm(21600000));
    }

    @Test
    public void formatSeveralHoursBis() throws Exception {
        assertEquals("8 horas" , IndicationsHelper.formatTerm(28800000));
    }

    @Test
    public void formatOneMinute() throws Exception {
        assertEquals("1 minuto" , IndicationsHelper.formatTerm(60000));
    }

    @Test
    public void formatSeveralMinutes() throws Exception {
        assertEquals("15 minutos" , IndicationsHelper.formatTerm(900000));
    }

    @Test
    public void formatHourAndHalfAsMinutes() throws Exception {
        assertEquals("90 minutos" , IndicationsHelper.formatTerm(5400000));
    }

    @Test
    public void formatDayAndHalfAsHours() throws Exception {
        assertEquals("36 horas" , IndicationsHelper.formatTerm(129600000));
    }
}