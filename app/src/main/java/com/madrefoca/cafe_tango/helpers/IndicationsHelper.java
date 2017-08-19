package com.madrefoca.cafe_tango.helpers;

import android.support.annotation.NonNull;

/**
 * Created by iascierto on 10/8/17.
 */

public class IndicationsHelper {

    public static final String DAY = " día";
    public static final String HOUR = " hora";
    public static final String MINUTE = " minuto";
    public static final String PLURAL = "s";

    /**
     * We are treating all time based variables as long and are stored in the DB as milliseconds
     * count. Therefore this method will transform those milliseconds amounts into the corresponding
     * String to be indicated.
     *
     * @param term the time based variable.
     * @return the resulting time String
     */
    public static String formatTerm(long term) {
        String formattedTime = null;

        long seconds = (term / 1000);
        long minutes = (seconds / 60);
        long hours = (minutes / 60);
        long days = (hours / 24);

        if (days > 0 && (hours % 24) == 0) {
            formattedTime = indicationAppender(days, DAY);
        } else if (hours > 0 && (minutes % 60) == 0) {
            formattedTime = indicationAppender(hours, HOUR);
        } else if (minutes > 0 && (seconds % 60) == 0) {
            formattedTime = indicationAppender(minutes, MINUTE);
        }

        return formattedTime;
    }

    @NonNull
    private static String indicationAppender(long time, final String elementName) {
        StringBuilder appender = new StringBuilder();
        appender.append(time);
        appender.append(elementName);
        if (time > 1)
            appender.append(PLURAL);

        return appender.toString();
    }
}
