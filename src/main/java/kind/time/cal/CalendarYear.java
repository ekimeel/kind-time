package kind.time.cal;

import kind.time.Years;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Michael J. Lee
 */
public class CalendarYear {

    public static CalendarYear of(int year) {
        return new CalendarYear(year, Years.isLeapYear(year), new SimpleUSLocaleDateTimeInfo());
    }

    public static CalendarYear of(int year, LocaleDateTimeInfo localeDateTimeInfo) {
        return new CalendarYear(year, Years.isLeapYear(year), localeDateTimeInfo);
    }

    private final int year;
    private final boolean isLeapYear;
    private final LocaleDateTimeInfo localeDateTimeInfo;

    private CalendarYear(final int year, final boolean isLeapYear, LocaleDateTimeInfo localeDateTimeInfo) {
        this.year = year;
        this.localeDateTimeInfo = localeDateTimeInfo;
        
        /*
         TODO: Consider moving outside. Leap year should not be a 
         given variable but should be calculated
         */
        this.isLeapYear = isLeapYear;

    }

    /**
     * Returns if the current <code>CalendarYear</code> is a leap
     * year.
     *
     * @return True if the current <code>CalendarYear</code> is a
     * leap year, otherwise false.
     */
    public boolean isIsLeapYear() {
        return isLeapYear;
    }

    /**
     * Returns a number indicating the year
     *
     * @return a number indicating the year
     */
    public int getYear() {
        return year;
    }


    /**
     * Returns a new instance of a <code>CalendarMonth</code> for the
     * given month.
     *
     * @param month a month
     * @return a new instance of a <code>CalendarMonth</code> for the
     * given month.
     */
    public CalendarMonth getMonth(int month) {
        return CalendarMonth.of(getYear(), month);
    }


    /**
     * Returns a new instance of a <code>CalendarDate</code> for the
     * given month and day of the month.
     *
     * @param month      the month
     * @param dayOfMonth the day of the month
     * @return a new instance of a <code>CalendarDate</code> for the
     * given month and day of the month.
     * @see CalendarDate
     * @see GregorianCalendar
     */
    public CalendarDate getDate(final int month, final int dayOfMonth) {

        return CalendarDate.of(year, month, dayOfMonth);
    }

    /**
     * Returns a new array contain all the current <code>CalendarMonth</code>s
     * in the <code>CalendarYear</code>.
     *
     * @return
     * @see Years.MONTHS_IN_A_YEAR
     */
    public CalendarMonth[] getAllMonths() {
        CalendarMonth[] months = new CalendarMonth[Years.MONTHS_IN_YEAR];
        for (int month = 0; month < Years.MONTHS_IN_YEAR; month++)
            months[month] = CalendarMonth.of(getYear(), month);

        return months;
    }

    /**
     * Returns all the <code>CalendarDate</code>s in the current <code>CalendarYear</code>
     *
     * @return
     */
    public CalendarDate[] getAllDates() {
        GregorianCalendar baseCalendar = new GregorianCalendar(year, Months.JANUARY, 1);
        final int lastDayOfYear = baseCalendar.getActualMaximum(Calendar.DAY_OF_YEAR);
        final CalendarDate[] allCalendarDates = new CalendarDate[lastDayOfYear];

        int currentDayOfYear = 1;
        while (currentDayOfYear <= lastDayOfYear) {
            allCalendarDates[currentDayOfYear - 1] = CalendarDate.of(baseCalendar);
            baseCalendar.roll(Calendar.DAY_OF_YEAR, 1);
            currentDayOfYear++;
        }

        return allCalendarDates;
    }

    @Override
    public String toString() {
        return String.valueOf(getYear());
    }

    /**
     * Returns the <code>int</code> value of the current <code>CalendarYear</code>
     *
     * @return the <code>int</code> value of the current <code>CalendarYear</code>
     */
    public int toInt() {
        return year;
    }


}
