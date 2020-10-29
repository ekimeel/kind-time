package kind.time.cal;

import java.util.Calendar;

/**
 * @author Michael J. Lee
 */
public class CalendarDates {
    private CalendarDates() {
    }

    /**
     * Compares the <code>YEAR</code>, <code>MONTH</code> and <code>DAY_OF_MONTH</code> of
     * two <code>Calendar</code>s and returns true if they all equal eachother.
     *
     * @param date1 first <code>Calendar</code>
     * @param date2 second <code>Calendar</code>
     * @return True of the <code>YEAR</code>, <code>MONTH</code> and
     * <code>DAY_OF_MONTH</code> are all equal, otherwise false.
     */
    public static boolean areEqualDates(Calendar date1, Calendar date2) {

        if (date1 == null || date2 == null)
            return false;

        if (date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR))
            return false;

        if (date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH))
            return false;

        if (date1.get(Calendar.DAY_OF_MONTH) != date2.get(Calendar.DAY_OF_MONTH))
            return false;

        return true;

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
