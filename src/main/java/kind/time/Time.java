package kind.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class Time {

    /**
     * returns the current time in UTC milliseconds from the epoch.
     *
     * @return the current time in UTC milliseconds from the epoch.
     * @see GregorianCalendar
     */
    public static long now() {
        return GregorianCalendar.getInstance().getTimeInMillis();
    }

    /**
     * Returns the current time with the given pattern
     * <pre>
     * now("MM/dd/yyyy")    = 01/15/2008
     * </pre>
     *
     * @param pattern
     * @return
     */
    public static String now(String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(now());
    }

    /**
     * Returns the current year
     *
     * @return the current year
     * @see GregorianCalendar
     * @see Calendar#YEAR
     */
    public static int currentYear() {
        return GregorianCalendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Returns the current month
     *
     * @return
     * @see GregorianCalendar
     * @see Calendar#MONTH
     */
    public static int currentMonth() {
        return GregorianCalendar.getInstance().get(Calendar.MONTH);
    }

    /**
     * Returns the current day of the month
     *
     * @return
     * @see GregorianCalendar
     * @see Calendar#MONTH
     */
    public static int currentDayOfMonth() {
        return GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }


    /**
     * Returns the current date as a <code>Calendar</code>
     *
     * @return
     * @see GregorianCalendar
     */
    public static Calendar currentDate() {
        return GregorianCalendar.getInstance();
    }

    private Time() {
    }
}

