package kind.time.tz;


import kind.time.cal.CalendarMonth;
import kind.time.cal.DayOfWeek;
import kind.time.cal.Months;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeZones {
    /**
     * The UTC time zone  (often referred to as GMT).
     */
    public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");

    public static final TimeZone EASTERN_STANDARD;

    public static final TimeZone EASTERN_STANDARD_DAYLIGHT_SAVINGS;

    public static final TimeZone ATLANTIC_STANDARD;

    public static final TimeZone ATLANTIC_STANDARD_DAYLIGHT_SAVINGS;

    public static final TimeZone ALASKA_STANDARD;

    public static final TimeZone CENTRAL_STANDARD_DAYLIGHT_SAVINGS;

    public static final TimeZone MOUNTAIN_STANDARD;

    public static final TimeZone MOUNTAIN_STANDARD_DAYLIGHT_SAVINGS;

    public static final TimeZone PACIFIC_STANDARD_DAYLIGHT_SAVINGS;

    public static final TimeZone HAWAII_STANDARD;

    static {
        ALASKA_STANDARD = TimeZone.getTimeZone("AST");
        ATLANTIC_STANDARD = TimeZone.getTimeZone("PRT");
        EASTERN_STANDARD = TimeZone.getTimeZone("EST");
        HAWAII_STANDARD = TimeZone.getTimeZone("HST");
        MOUNTAIN_STANDARD = TimeZone.getTimeZone("MST");

        ATLANTIC_STANDARD_DAYLIGHT_SAVINGS = TimeZone.getTimeZone("SystemV/AST4ADT");
        EASTERN_STANDARD_DAYLIGHT_SAVINGS = TimeZone.getTimeZone("EST5EDT");
        CENTRAL_STANDARD_DAYLIGHT_SAVINGS = TimeZone.getTimeZone("CST6CDT");
        MOUNTAIN_STANDARD_DAYLIGHT_SAVINGS = TimeZone.getTimeZone("MST7MDT");
        PACIFIC_STANDARD_DAYLIGHT_SAVINGS = TimeZone.getTimeZone("PST8PDT");
    }

    private TimeZones() {
    }

    /**
     * Returns the U.S. Daylight savings start relative to the given year. As of
     * the year 2007 the DST start will be the second Sunday in the month of
     * March. Prior to the year 2007 this value will be the first Sunday in the
     * month of April.
     *
     * @param timeZone
     * @param year     Year to find DST start.
     * @return The U.S. Daylight savings start relative to the current year.
     */
    public static Calendar getDaylightSavingsStart(TimeZone timeZone, int year) {
        CalendarMonth month = null;
        if (year >= 2007) {
            month = CalendarMonth.of(year, Months.MARCH);
            return month.get(DayOfWeek.SUNDAY, 2);
        } else {
            month = CalendarMonth.of(year, Months.APRIL);
            return month.get(DayOfWeek.SUNDAY, 1);
        }

    }

    /**
     * Returns the U.S. Daylight savings end relative to the given year. As of
     * the year 2007 the DST end will be the first Sunday in the month of
     * November. Prior to the year 2007 this value will be the last Sunday in
     * the month of October.
     *
     * @param timeZone
     * @param year     Year to find DST end.
     * @return The U.S. Daylight savings end relative to the current year.
     */
    public static Calendar getDaylightSavingsEnd(TimeZone timeZone, int year) {

        CalendarMonth month = null;
        if (year >= 2007) {
            month = CalendarMonth.of(year, Months.NOVEMBER);
            return month.getFirst(DayOfWeek.SUNDAY);
        } else {
            month = CalendarMonth.of(year, Months.OCTOBER);
            return month.getLast(DayOfWeek.SUNDAY);
        }
    }
}
