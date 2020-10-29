package kind.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class Days implements Duration {

    public static final Days MONDAY;
    public static final Days TUESDAY;
    public static final Days WEDNESDAY;
    public static final Days THURSDAY;
    public static final Days FRIDAY;
    public static final Days SATURDAY;
    public static final Days SUNDAY;

    public static final boolean WEEKDAY = true;
    public static final boolean WEEKEND = false;

    private static final int MAXIMUM_DAY = 6;
    private static final int MINIMUM_DAY = 0;

    public static final long MILLIS_IN_A_DAY = 86400000;

    public static final DayCount ONE;
    public static final DayCount TWO;
    public static final DayCount THREE;
    public static final DayCount FOUR;
    public static final DayCount FIVE;
    public static final DayCount SIX;
    public static final DayCount SEVEN;
    public static final DayCount THIRTY;
    public static final DayCount SIXTY;
    public static final DayCount NINETY;

    /**
     * Contains a list of all the days
     */
    public static final List<Days> DAYS;

    static {

        MONDAY = new Days(Calendar.MONDAY, "Monday", "Mon", true);
        TUESDAY = new Days(Calendar.TUESDAY, "Tuesday", "Tue", true);
        WEDNESDAY = new Days(Calendar.WEDNESDAY, "Wednesday", "Wed", true);
        THURSDAY = new Days(Calendar.THURSDAY, "Thursday", "Thr", true);
        FRIDAY = new Days(Calendar.FRIDAY, "Friday", "Fri", true);
        SATURDAY = new Days(Calendar.SATURDAY, "Saturday", "Sat", false);
        SUNDAY = new Days(Calendar.SUNDAY, "Sunday", "Sun", false);

        DAYS = new ArrayList<>();
        DAYS.add(MONDAY);
        DAYS.add(TUESDAY);
        DAYS.add(WEDNESDAY);
        DAYS.add(THURSDAY);
        DAYS.add(FRIDAY);
        DAYS.add(SATURDAY);
        DAYS.add(SUNDAY);

        ONE = new DayCount(1);
        TWO = new DayCount(2);
        THREE = new DayCount(3);
        FOUR = new DayCount(4);
        FIVE = new DayCount(5);
        SIX = new DayCount(6);
        SEVEN = new DayCount(7);

        THIRTY = new DayCount(30);
        SIXTY = new DayCount(60);
        NINETY = new DayCount(90);

    }

    ;

    /**
     * Returns a day based on a gregorian calendar.
     * <br/>
     * <table border="1">
     * <tr>
     * <td>value</td><td>returns</td>
     * </tr>
     * <tr><td>0</td><td>Monday</td></tr>
     * <tr><td>1</td><td>Tuesday</td></tr>
     * <tr><td>2</td><td>Wednesday</td></tr>
     * <tr><td>3</td><td>Thursday</td></tr>
     * <tr><td>4</td><td>Friday</td></tr>
     * <tr><td>5</td><td>Saturday</td></tr>
     * <tr><td>6</td><td>Sunday</td></tr>
     * <tr><td>otherwise</td><td>null</td></tr>
     * </table>
     *
     * @param value zero based index of a day based on a gregorian
     *              calendar.
     * @return a Day if value given can be found, Otherwise null.
     */
    public static Days of(int value) {

        if (value < MINIMUM_DAY)
            return null;

        if (value > MAXIMUM_DAY)
            return null;

        return DAYS.get(value);

    }

    /**
     * Returns the formal name of the current month from a gregorian
     * calendar.
     * <br/>
     * <table border="1">
     * <tr>
     * <td>monthName</td><td>Return Month</td>
     * </tr>
     * <tr><td>Monday | Mon</td><td>Monday</td></tr>
     * <tr><td>Tuesday | Tue</td><td>Tuesday</td></tr>
     * <tr><td>Wednesday | Wed</td><td>Wednesday</td></tr>
     * <tr><td>Thursday | Thr</td><td>Thursday</td></tr>
     * <tr><td>Friday | Fri</td><td>Friday</td></tr>
     * <tr><td>Saturday | Sat</td><td>Saturday</td></tr>
     * <tr><td>Sunday | Sun</td><td>Sunday</td></tr>
     * <tr><td>otherwise</td><td>null</td></tr>
     * </table>
     *
     * @param monthName long or short month name case is ignored.
     * @return a month if the monthName can be found, otherwise null
     */
    public static Days of(String monthName) {
        for (Days day : DAYS) {
            if (day.name.equalsIgnoreCase(monthName))
                return day;

            if (day.shortName.equalsIgnoreCase(monthName))
                return day;

        }
        return null;
    }

    /**
     * Returns the number of milliseconds in the given number of days.
     * 1 day = 86400000 milliseconds
     *
     * @param days the number of days.
     * @return the number of milliseconds in the given number of days.
     */
    public static long toMilliseconds(int days) {
        return days * Days.MILLIS_IN_A_DAY;
    }

    private final int value;
    private final String name;
    private final String shortName;
    private final boolean weekday;

    private Days(int value, String name, String shortName, boolean weekday) {
        this.value = value;
        this.name = name;
        this.shortName = shortName;
        this.weekday = weekday;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public int toInt() {
        return value;
    }

    public boolean isWeekday() {
        return weekday;
    }

    public long getTimeInMillis() {
        return MILLIS_IN_A_DAY;
    }

    public final static class DayCount implements Duration {

        private final int numberOfDays;
        private final long timeInMillis;

        private DayCount(int numberOfDays) {
            this.numberOfDays = numberOfDays;
            timeInMillis = numberOfDays * Days.MILLIS_IN_A_DAY;
        }

        public long getTimeInMillis() {
            return timeInMillis;
        }

        public int getNumberOfDays() {
            return numberOfDays;
        }
    }

    @Override
    public String toString() {
        return getName();
    }


}

