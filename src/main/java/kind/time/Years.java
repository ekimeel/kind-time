package kind.time;

import java.util.GregorianCalendar;

/**
 * @author Michael J. Lee
 */
public final class Years {

    public static final int MONTHS_IN_YEAR = 12;
    public static final int WEEKS_IN_YEAR = 52;


    private Years() {
        //Utility class
    }

    public static boolean isLeapYear(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }


}
