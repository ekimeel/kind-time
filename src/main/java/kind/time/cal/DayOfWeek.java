package kind.time.cal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public enum DayOfWeek {

    MONDAY(Calendar.MONDAY, 1, "Monday", "Mon", true),
    TUESDAY(Calendar.TUESDAY, 2, "Tuesday", "Tue", true),
    WEDNESDAY(Calendar.WEDNESDAY, 3, "Wednesday", "Wed", true),
    THURSDAY(Calendar.THURSDAY, 4, "Thursday", "Thr", true),
    FRIDAY(Calendar.FRIDAY, 5, "Friday", "Fri", true),
    SATURDAY(Calendar.SATURDAY, 6, "Saturday", "Sat", false),
    SUNDAY(Calendar.SUNDAY, 7, "Sunday", "Sun", false);

    public static final boolean WEEKDAY = true;

    public static final boolean WEEKEND = false;

    public static final int MAXIMUM_DAY = 6;

    public static final int MINIMUM_DAY = 0;

    /**
     * Contains a list of all the days
     */
    public static final List<DayOfWeek> DAYS;

    static {
        DAYS = new ArrayList<DayOfWeek>();
        DAYS.add(MONDAY);
        DAYS.add(TUESDAY);
        DAYS.add(WEDNESDAY);
        DAYS.add(THURSDAY);
        DAYS.add(FRIDAY);
        DAYS.add(SATURDAY);
        DAYS.add(SUNDAY);
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
    public static DayOfWeek of(int value) {

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
    public static DayOfWeek of(String monthName) {
        for (DayOfWeek day : DAYS) {
            if (day.name.equalsIgnoreCase(monthName))
                return day;
            if (day.shortName.equalsIgnoreCase(monthName))
                return day;
        }
        return null;
    }

    private final int value;

    private final int isoValue;

    private final String name;

    private final String shortName;

    private final boolean weekday;

    DayOfWeek(int value, int isoValue, String name, String shortName, boolean weekday) {
        this.value = value;
        this.isoValue = isoValue;
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

    public int getValue() {
        return value;
    }

    public int getISOValue() {
        return isoValue;
    }

    public boolean isWeekday() {
        return weekday;
    }

    public boolean isWeekend() {
        return weekday == false;
    }

    public static boolean isWeekday(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SATURDAY:
                return false;
            case Calendar.SUNDAY:
                return false;
            default:
                return true;
        }
    }

    public static boolean isWeekend(int dayOfWeek) {
        return isWeekday(dayOfWeek) == false;
    }

    /**
     * Returns the <code>int</code> value of the current <code>Day</code>
     *
     * @return the <code>int</code> value of the current <code>Day</code>
     */
    public int toInt() {
        return value;
    }
}
