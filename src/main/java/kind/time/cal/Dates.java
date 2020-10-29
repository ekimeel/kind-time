package kind.time.cal;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael J. Lee
 */
public class Dates {

    private Dates() {
    }


    public static class US {

        public static final Map<String, CalendarDate> dstFlyweight;
        private static char START_OF_DST_FLYWEIGHT_ID = 'S';
        private static char END_OF_DST_FLYWEIGHT_ID = 'E';


        static {
            dstFlyweight = new HashMap<String, CalendarDate>();
        }

        public static Calendar[] of(final int year) {
            Calendar[] dates = {
                    getDaylightSavingsStart(year), getDaylightSavingsEnd(year)
            };

            return dates;
        }

        /**
         * Returns if the given <code>Calendar</code> is in the standard U.S.
         * Daylight Savings Time start or end.
         *
         * @param date The date to check
         * @return True of the given <code>Calendar</code> is in the standard
         * U.S. Daylight Savings Time start or end.
         */
        public static boolean isDaylightSavings(Calendar date) {

            if (isDaylightSavingsStart(date)) {
                return true;
            }

            if (isDaylightSavingsEnd(date)) {
                return true;
            }

            return false;
        }

        public static boolean isDaylightSavingsStart(Calendar date) {
            //TODO:JavaDoc
            final int year = date.get(Calendar.YEAR);

            Calendar dstStart = getDaylightSavingsStart(year);

            if (CalendarDate.areEqualDates(date, dstStart)) {
                return true;
            }

            return false;
        }

        public static boolean isDaylightSavingsEnd(Calendar date) {
            //TODO:JavaDoc
            final int year = date.get(Calendar.YEAR);

            Calendar dstEnd = getDaylightSavingsEnd(year);

            if (CalendarDate.areEqualDates(date, dstEnd)) {
                return true;
            }

            return false;
        }

        /**
         * Returns the U.S. Daylight savings start relative to the given year. As of
         * the year 2007 the DST start will be the second Sunday in the month of
         * March. Prior to the year 2007 this value will be the first Sunday in the
         * month of April.
         *
         * @param year Year to find DST start.
         * @return The U.S. Daylight savings start relative to the current year.
         */
        public static Calendar getDaylightSavingsStart(final int year) {

            final String dstCode = START_OF_DST_FLYWEIGHT_ID + String.valueOf(year);

            if (dstFlyweight.containsKey(dstCode)) {
                return dstFlyweight.get(dstCode);
            }

            CalendarMonth month = null;
            CalendarDate date = null;
            if (year >= 2007) {
                month = CalendarMonth.of(year, Months.MARCH);
                date = month.get(DayOfWeek.SUNDAY, 2);
            } else {
                month = CalendarMonth.of(year, Months.APRIL);
                date = month.get(DayOfWeek.SUNDAY, 1);
            }

            dstFlyweight.put(dstCode, date);
            return date;
        }

        /**
         * Returns the U.S. Daylight savings end relative to the given year. As of
         * the year 2007 the DST end will be the first Sunday in the month of
         * November. Prior to the year 2007 this value will be the last Sunday in
         * the month of October.
         *
         * @param year Year to find DST end.
         * @return The U.S. Daylight savings end relative to the current year.
         */
        public static Calendar getDaylightSavingsEnd(final int year) {

            final String dstCode = END_OF_DST_FLYWEIGHT_ID + String.valueOf(year);

            if (dstFlyweight.containsKey(dstCode)) {
                return dstFlyweight.get(dstCode);
            }

            CalendarMonth month = null;
            CalendarDate date = null;
            if (year >= 2007) {
                month = CalendarMonth.of(year, Months.NOVEMBER);
                date = month.getFirst(DayOfWeek.SUNDAY);
            } else {
                month = CalendarMonth.of(year, Months.OCTOBER);
                date = month.getLast(DayOfWeek.SUNDAY);
            }

            dstFlyweight.put(dstCode, date);
            return date;
        }

        /**
         * Class use the flyweight pattern to improve preformance of multiple lookups.
         * This method will clear all the flyweights that are currently registered.
         */
        public static void clearFlyweights() {
            dstFlyweight.clear();
        }

        private US() {
        }
    }
}

