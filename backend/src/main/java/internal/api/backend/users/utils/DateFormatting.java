package internal.api.backend.users.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateFormatting {

    public static String toWords(LocalDateTime date){
        return toWords(date.toLocalDate());
    }

    public static String toWords(LocalDate date){
        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int day = date.getDayOfMonth();
        int year = date.getYear();

        String ordinalIndicator = switch (day % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };

        return month + " " + day + ordinalIndicator + ", " + year;
    }
}
