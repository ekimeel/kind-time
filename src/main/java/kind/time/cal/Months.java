package kind.time.cal;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Months {
    public static final int JANUARY = Calendar.JANUARY;

    public static final int FEBRUARY = Calendar.FEBRUARY;

    public static final int MARCH = Calendar.MARCH;

    public static final int APRIL = Calendar.APRIL;

    public static final int MAY = Calendar.MAY;

    public static final int JUNE = Calendar.JUNE;

    public static final int JULY = Calendar.JULY;

    public static final int AUGUST = Calendar.AUGUST;

    public static final int SEPTEMBER = Calendar.SEPTEMBER;

    public static final int OCTOBER = Calendar.OCTOBER;

    public static final int NOVEMBER = Calendar.NOVEMBER;

    public static final int DECEMBER = Calendar.DECEMBER;

    public static final int MAX_VALUE = 11;

    public static final int MIN_VALUE = 0;

    private Months() {
    }

    /**
     * Returns a number indicating the total number of days in the
     * month.<br/>
     * Example.
     * numberOfDaysInMonth(2000, 0) = 31<br/>
     * numberOfDaysInMonth(2008, 1) = 29<br/>
     * numberOfDaysInMonth(2011, 9) = 31<br/>
     *
     * @param year
     * @param month
     * @return a number indicating the total number of days in the
     * month.
     */
    public static int daysInMonth(int year, int month) {
        GregorianCalendar calendar = new GregorianCalendar(year, month, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
