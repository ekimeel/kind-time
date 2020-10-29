package kind.time.cal;

import java.util.Calendar;


public class CalendarCalculator {

    public static int calculateDaysDifference(Calendar startDate, Calendar endDate) {

        //TODO javaDoc: 
        long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
        int offset = endDate.get(Calendar.DST_OFFSET) - startDate.get(Calendar.DST_OFFSET);

        diff += offset;
        int days = (int) (diff / (1000 * 60 * 60 * 24));

        return days;

    }

    /**
     * Calculates the differance in hours between two <code>Calendar</code>'s.
     * The result is allowed to be negitive.
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int calculateHoursDifference(Calendar startDate, Calendar endDate) {

        long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
        int offset = endDate.get(Calendar.DST_OFFSET) - startDate.get(Calendar.DST_OFFSET);

        diff += offset;
        int hours = (int) (diff / (1000 * 60 * 60));

        return hours;

    }

    private CalendarCalculator() {
    }
}
