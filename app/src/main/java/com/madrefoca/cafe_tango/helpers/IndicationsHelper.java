package com.madrefoca.cafe_tango.helpers;

/**
 * Created by iascierto on 10/8/17.
 */

public class IndicationsHelper {

    /**
     * We are treating all time based variables as double and are stored in the DB as milliseconds
     * count. Therefore this method will transform those milliseconds amounts into the corresponding
     * String to be indicated.
     *
     * @param term the time based variable.
     * @return the resulting time String
     */
    public static String formatTerm(long term) {
        StringBuilder formattedTime = new StringBuilder();

        long seconds = (term / 1000);
        long minutes = (seconds / 60);
        long hours = (minutes / 60);
        long days = (hours / 24);

//        seconds = seconds % 60;
//        minutes = minutes % 60;
//        hours = hours % 24;

        if (days > 0) {
            formattedTime.append(days);
            formattedTime.append(" día");
            if (days > 1)
                formattedTime.append("s");
        } else if (hours > 0) {
            formattedTime.append(hours);
            formattedTime.append(" hora");
            if (hours > 1)
                formattedTime.append("s");
        } else if (minutes > 0) {
            formattedTime.append(minutes);
            formattedTime.append(" minuto");
            if (minutes > 1)
                formattedTime.append("s");
        }

        return formattedTime.toString();
    }
}
