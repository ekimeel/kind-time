package kind.time.cal;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Represents an Gregorian calendar month.
 *
 * @author Michael J. Lee
 */
public class CalendarMonth {

    /**
     * Create an new <code>CalendarMonth</code> for the given year and
     * month.<br/><br/>
     * Note: month is 0 based E.g. 0-11
     *
     * @param year  the year
     * @param month the month 0-11
     * @return a new <code>CalendarMonth</code> for the given year and
     * month.
     */
    public static CalendarMonth of(final int year, final int month) {
        CalendarYear calendarYear = CalendarYear.of(year);

        if (calendarYear == null)
            throw new IllegalArgumentException("Invalid year of [" + year + "]");
        Month calendarMonth = Month.of(month);

        if (calendarMonth == null)
            throw new IllegalArgumentException("Invalid month of [" + month + "]");

        return new CalendarMonth(CalendarYear.of(year), Month.of(month), TimeZone.getDefault());
    }

    public static CalendarMonth of(final int year, final int month, final TimeZone timeZone) {
        CalendarYear calendarYear = CalendarYear.of(year);

        if (calendarYear == null)
            throw new IllegalArgumentException("Invalid year of [" + year + "]");
        Month calendarMonth = Month.of(month);

        if (calendarMonth == null)
            throw new IllegalArgumentException("Invalid month of [" + month + "]");
        return new CalendarMonth(CalendarYear.of(year), Month.of(month), timeZone);
    }

    protected final CalendarYear year;

    protected final Month month;

    protected CalendarDate[] dates;

    protected final TimeZone timeZone;

    private CalendarMonth(final CalendarYear year, final Month month, final TimeZone timeZone) {
        this.year = year;
        this.month = month;
        this.timeZone = timeZone;
    }

    final public Month getMonth() {
        return month;
    }

    final public int getActualMonth() {
        return month.getValue();
    }

    final public CalendarYear getCalendarYear() {
        return year;
    }

    final public int getActualYear() {
        return year.getYear();
    }

    public CalendarDate[] getAllDates() {

        if (dates == null)
            fillDates();

        return dates;
    }

    public CalendarDate getDayOfMonth(int i) {

        if (i < 1)
            return null;

        if (i > getAllDates().length)
            return null;

        return getAllDates()[i - 1];
    }

    /**
     * Returns a <code>CalendarDate</code> in the current
     * <code>CalendarMonth</code> given the <code>DayOfWeek</code> and number of
     * occurrences.  If a <code>CalendarDate</code> does not exists for the given
     * parameters a null is returned instead.<br/><br/>
     * Examples.<br/>
     * 1.) Given a <code>SUNDAY</code> and a occurrences of 1 will return the 1st Sunday in the month<br/>
     * 2.) Given a <code>FRIDAY</code> and a occurrences of 4 will return the 4th Friday in the month<br/>
     *
     * @param day         the day
     * @param occurrences the occurrences of the day
     * @return A new instance of a <code>CalendarDate</code> if one exists, otherwise null
     */
    public CalendarDate get(DayOfWeek day, int occurrences) {
        //TODO: Refector method. Also see other getXXXX's for duplicate code
        Calendar calendar = new GregorianCalendar(year.toInt(), month.toInt(), 1);
        final int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + 1;
        int daysParsed = 0;
        int actualOccurrences = 0;

        while (actualOccurrences < occurrences && daysParsed <= daysInMonth) {

            if (calendar.get(Calendar.DAY_OF_WEEK) == day.toInt())
                actualOccurrences++;

            if (actualOccurrences != occurrences) {
                calendar.roll(Calendar.DAY_OF_MONTH, 1);
                daysParsed++;
            }

        }

        if (daysParsed > 32)
            return null;
        return CalendarDate.of(calendar);
    }

    /**
     * Returns the last occurrence of the given <code>DayOfWeek</code> in the current
     * <code>CalendarMonth</code> as a <code>CalendarDate</code>.
     *
     * @param day the day
     * @return A new instance of a <code>CalendarDate</code> if one exists, otherwise null
     */
    public CalendarDate getLast(DayOfWeek day) {
        //TODO: Refector method. Also see other getXXXX's for duplicate code
        Calendar calendar = new GregorianCalendar(year.toInt(), month.toInt(), 1);
        final int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar lastDay = null;
        int daysParsed = 0;

        while (daysParsed < daysInMonth) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == day.toInt())
                lastDay = (Calendar) calendar.clone();
            calendar.roll(Calendar.DAY_OF_MONTH, 1);
            daysParsed++;
        }

        return CalendarDate.of(lastDay);
    }

    /**
     * Returns the first occurrence of the given <code>DayOfWeek</code> in the current
     * <code>CalendarMonth</code> as a <code>CalendarDate</code>.
     *
     * @param day the day
     * @return A new instance of a <code>CalendarDate</code> if one exists, otherwise null
     */
    public CalendarDate getFirst(DayOfWeek day) {
        return get(day, 1);
    }

    private void fillDates() {

        GregorianCalendar calendar = new GregorianCalendar(getCalendarYear().getYear(), month.getValue(), 1);
        final int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        dates = new CalendarDate[lastDayOfMonth];
        int dayOfMonth = 1;

        while (dayOfMonth <= lastDayOfMonth) {
            dates[dayOfMonth - 1] = CalendarDate.of(calendar);
            calendar.roll(Calendar.DAY_OF_MONTH, 1);
            dayOfMonth++;
        }

    }

    @Override
    public String toString() {
        return getCalendarYear() + " - " + getMonth().getName();
    }
}
