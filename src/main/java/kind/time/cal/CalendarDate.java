package kind.time.cal;

import kind.support.Copyable;
import kind.time.Days;
import kind.time.Duration;
import kind.time.Hours;
import kind.time.Time;
import kind.time.fmt.DateFormats;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Michael J. Lee
 * @see GregorianCalendar
 */
public class CalendarDate extends GregorianCalendar implements Copyable<CalendarDate> {

    private static final long serialVersionUID = 1;
    protected static final int DEFAULT_MONTH = 0;
    protected static final int DEFAULT_DAY_OF_MONTH = 1;
    protected static final int DEFAULT_HOUR_OF_DAY = 0;
    protected static final int DEFAULT_MINUTE_OF_HOUR = 0;

    /**
     * Creats a <code>CalendarDate</code> with the current date time.
     *
     * @return A new instance of a <code>CalendarDate</code>
     */
    public static CalendarDate now() {
        return new CalendarDate(GregorianCalendar.getInstance());
    }

    /**
     * Creats a <code>CalendarDate</code> from a <code>Calendar</code>
     *
     * @param calendar
     * @return A new instance of a <code>CalendarDate</code>
     */
    public static synchronized CalendarDate of(Calendar calendar) {
        return new CalendarDate((Calendar) calendar.clone());
    }

    /**
     * Creates a <code>CalendarDate</code> from a <code>java.sql.TimeStamp</code>
     *
     * @param timeStep a <code>java.sql.TimeStamp</code>
     * @return a new <code>CalendarDate</code>.
     * @see CalendarDate#of(Timestamp)
     */
    public static synchronized CalendarDate of(java.sql.Timestamp timeStep) {

        if (timeStep == null) {
            return null;
        }

        return of(timeStep.getTime());
    }

    /**
     * Creates a <code>CalendarDate</code> from a <code>java.util.Date</code>
     *
     * @param date a <code>java.util.Date</code>
     * @return a new <code>CalendarDate</code>.
     * @see CalendarDate#of(long milliseconds)
     */
    public static synchronized CalendarDate of(java.util.Date date) {

        if (date == null) {
            return null;
        }

        return of(date.getTime());
    }

    /**
     * Creates a <code>CalendarDate</code> from a <code>java.sql.Date</code>
     *
     * @param date a <code>java.sql.Date</code>
     * @return a new <code>CalendarDate</code>.
     * @see CalendarDate#of(long milliseconds)
     */
    public static synchronized CalendarDate of(java.sql.Date date) {

        if (date == null) {
            return null;
        }

        return of(date.getTime());
    }

    /**
     * Creates a <code>CalendarDate</code> that will return a new
     * instance of a <code>CalendarDate</code> for the given year.  The month,
     * day and hour will default to the first hour of the first day in the first
     * month.
     *
     * @param year the year to create a new instance of
     * @return A new <code>CalendarDate</code> for the first hour of the first
     * day of the first month of the give year.
     */
    public static synchronized CalendarDate of(int year) {
        return of(year, Months.JANUARY, DEFAULT_DAY_OF_MONTH,
                DEFAULT_HOUR_OF_DAY, DEFAULT_MINUTE_OF_HOUR);
    }

    /**
     * Creates a new <code>CalendarDate</code> form the given milliseconds from
     * January 1, 1970 (Gregorian), midnight UTC.
     *
     * @param milliseconds The milliseconds from January 1, 1970 (Gregorian), midnight UTC.
     * @return a new instance of a <code>CalendarDate</code>
     */
    public static synchronized CalendarDate of(long milliseconds) {

        return new CalendarDate(milliseconds, TimeZone.getDefault());
    }

    /**
     * Creates a new <code>CalendarDate</code> form the given date text and
     * the format of the date text
     *
     * @param dateText      the date E.g. '2/24/2008'
     * @param formatPattern the format of the given date text E.g. 'MM/dd/yyyy'
     * @return a new instance of a <code>CalendarDate</code>
     * @throws IllegalArgumentException when pattern or text cannot be parsed
     * @see <code>SimpleDateFormat</code>
     */
    public static synchronized CalendarDate of(final String dateText, final String formatPattern) {
        DateFormat format = new SimpleDateFormat(formatPattern);
        try {
            return of(format.parse(dateText).getTime());
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Illegal date pattern of [" + formatPattern + "] cannot be applied to [" + dateText + "]." +
                    "\nCaused by: " + ex.getMessage());
        }
    }

    /**
     * Creates a new instance of <code>CalendarDate</code> for a given
     * year and month.  The day of the month will be the 1st calendar
     * date in the month.
     * <br/>
     * Note: the month field is 0-11 format
     *
     * @param year  a year
     * @param month a month 0-11
     * @return a new instance of <code>CalendarDate</code> for a given
     * year and month.
     */
    public static synchronized CalendarDate of(final int year, final int month) {
        return of(year, month, DEFAULT_DAY_OF_MONTH);

    }

    /**
     * Creates a new instance of a <code>CalendarDate</code>.
     * <br/><br/>
     * Note: the month field is 0-11 format
     *
     * @param year       the year e.g. 2008
     * @param month      the month 0-11
     * @param dayOfMonth the day of the month 1-31
     * @return new instance of a <code>CalendarDate</code>.
     */
    public static synchronized CalendarDate of(final int year, final int month, final int dayOfMonth) {
        return new CalendarDate(new GregorianCalendar(year, month, dayOfMonth));
    }

    /**
     * Creates a new instance of a <code>CalendarDate</code>.
     * <br/><br/>
     * Note: the month field is 0-11 format
     *
     * @param year         the year e.g. 2008
     * @param month        the month 0-11
     * @param dayOfMonth   the day of the month 1-31
     * @param hourOfTheDay hour of the day 0-23
     * @return new instance of a <code>CalendarDate</code>.
     */
    public static synchronized CalendarDate of(final int year, final int month, final int dayOfMonth, final int hourOfTheDay) {
        return new CalendarDate(new GregorianCalendar(year, month, dayOfMonth, hourOfTheDay, 0));
    }

    /**
     * Creates a new instance of a <code>CalendarDate</code>.
     * <br/><br/>
     * Note: the month field is 0-11 format
     *
     * @param year            the year e.g. 2008
     * @param month           the month 0-11
     * @param dayOfMonth      the day of the month 1-31
     * @param hourOfTheDay    hour of the day 0-23
     * @param minuteOfTheHour minute of the hour 0-59
     * @return new instance of a <code>CalendarDate</code>.
     */
    public static synchronized CalendarDate of(final int year, final int month, final int dayOfMonth, final int hourOfTheDay, final int minuteOfTheHour) {
        return new CalendarDate(new GregorianCalendar(year, month, dayOfMonth, hourOfTheDay, minuteOfTheHour));
    }

    /**
     * Creates a new instance of a <code>CalendarDate</code>.
     * <br/><br/>
     * Note: the month field is 0-11 format
     *
     * @param year             the year e.g. 2008
     * @param month            the month 0-11
     * @param dayOfMonth       the day of the month 1-31
     * @param hourOfTheDay     hour of the day 0-23
     * @param minuteOfTheHour  minute of the hour 0-59
     * @param secondsInTheHour seconds in the hour 0-59
     * @return new instance of a <code>CalendarDate</code>.
     */
    public static synchronized CalendarDate of(final int year, final int month, final int dayOfMonth, final int hourOfTheDay, final int minuteOfTheHour, final int secondsInTheHour) {
        return new CalendarDate(new GregorianCalendar(year, month, dayOfMonth, hourOfTheDay, minuteOfTheHour, secondsInTheHour));
    }

    /**
     * Creates a new instance of a <code>CalendarDate</code>.
     * <br/><br/>
     * Note: the month field is 0-11 format
     *
     * @param year            the year e.g. 2008
     * @param month           the month 0-11
     * @param dayOfMonth      the day of the month 1-31
     * @param hourOfTheDay    hour of the day 0-23
     * @param minuteOfTheHour minute of the hour 0-59
     * @param timeZone        the time zone
     * @return new instance of a <code>CalendarDate</code>.
     */
    public static synchronized CalendarDate of(final int year, final int month, final int dayOfMonth, final int hourOfTheDay, final int minuteOfTheHour, TimeZone timeZone) {
        Calendar calendar = new GregorianCalendar(year, month, dayOfMonth, hourOfTheDay, minuteOfTheHour);
        calendar.setTimeZone(timeZone);

        return new CalendarDate(calendar);
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

        if (date1 == null || date2 == null) {
            return false;
        }

        if (date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR)) {
            return false;
        }

        if (date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH)) {
            return false;
        }

        if (date1.get(Calendar.DAY_OF_MONTH) != date2.get(Calendar.DAY_OF_MONTH)) {
            return false;
        }

        return true;

    }

    public static CalendarDate of(int year, int month, int dayOfMonth, final HolidaySchedule holidaySchedule) {

        return new CalendarDate(new GregorianCalendar(year, month, dayOfMonth),
                new SimpleUSLocaleDateTimeInfo() {


                    @Override
                    public HolidaySchedule getHolidaySchedule() {
                        return holidaySchedule;

                    }


                });


    }

    private final LocaleDateTimeInfo localeDateTimeInfo;

    private CalendarDate(Calendar calendar) {
        this(calendar.getTimeInMillis(), calendar.getTimeZone());
    }

    private CalendarDate(Calendar calendar, LocaleDateTimeInfo localeDateTimeInfo) {
        this(calendar.getTimeInMillis(), calendar.getTimeZone(), localeDateTimeInfo);
    }

    private CalendarDate(long timeInMillis, TimeZone timeZone) {
        //TODO: Default is always SimpleUsLocaleDateTimeInfo?  Needs to be abstracted or set by user.
        this(timeInMillis, timeZone, new SimpleUSLocaleDateTimeInfo());

    }

    private CalendarDate(long timeInMillis, TimeZone timeZone, LocaleDateTimeInfo localeDateTimeInfo) {
        super();
        setTimeZone(timeZone);
        setTimeInMillis(timeInMillis);
        this.localeDateTimeInfo = localeDateTimeInfo;
    }

    /**
     * Returns a <code>int</code>  indicating the day
     * of the week based on a <code>Calendar</code>.
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
     * </table>
     *
     * @return a Day if value given can be found, Otherwise null.
     */
    public int getDayOfTheWeek() {
        return get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Returns a number indicating the the day of the year. E.g. a date
     * of 1/15/2008 will return 15
     *
     * @return a number indicating the the day of the year.
     */
    public int getDayOfTheYear() {
        return get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Returns a new instance copy of the current <code>LocaleDateTimeInfo</code>
     *
     * @return a new instance copy of the current <code>LocaleDateTimeInfo</code>
     * @see LocaleDateTimeInfo
     * @see Copyable
     */
    public final LocaleDateTimeInfo getLocaleDateTimeInfo() {
        return localeDateTimeInfo.copy();
    }

    /**
     * Returns a number indicating the current year. E.g. 2008
     *
     * @return a number indicating the current year. E.g. 2008
     */
    public int getYear() {
        return get(Calendar.YEAR);
    }

    /**
     * Returns the number indicating the month in a <code>GregorianCalendar</code>.
     * The first month of the year in the Gregorian and Julian calendars is
     * <code>JANUARY</code> which is 0;
     *
     * @return a int indicating the month in 0-11 format
     */
    public int getMonth() {
        return get(Calendar.MONTH);
    }

    /**
     * Returns the number indicating the day of the month. This is a synonym for <code>DATE</code>.
     * The first day of the month has value 1.
     *
     * @return The day of the month in 1-31 format
     */
    public int getDayOfTheMonth() {
        return get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Returns the hour of the day in 0-23 format.  E.g., at 10:04:15.250 PM
     * the hour returned will be 22.
     *
     * @return The hour of the day in 0-23 format
     */
    public int getHourOfTheDay() {
        return get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Returns the number indicating the minute within the hour.
     * E.g., at 10:04:15.250 PM the <code>MINUTE</code> is 4.
     *
     * @return The minute of the hour in 0-59 format
     */
    public int getMinuteOfTheHour() {
        return get(Calendar.MINUTE);
    }

    /**
     * Returns a number indicating the actual number of hours in the
     * current <code>CalendarDate</code>.  This number is derived form
     * the curret <code>CalendarDate</code>'s implementation of
     * <code>LocaleDateTimeInfo</code> and can vary with each implementation.
     *
     * @return hours in day
     * @see LocaleDateTimeInfo
     */
    public int getActualHoursInDay() {
        return localeDateTimeInfo.getHoursInDay(this);
    }

    /**
     * Returns if the current <code>CalendarDate</code> is a DST
     * start or end.  This will be derived form the current
     * <code>CalendarDate</code>'s implemenation of
     * <code>LocaleDateTimeInfo</code> and may vary with each implemenation.
     *
     * @return True of the given <code>CalendarDate</code> is a
     * DST start or end.
     */
    public boolean isDayLightSavings() {
        return localeDateTimeInfo.isDaylightSavingsStartOrEnd(this);
    }

    /**
     * Returns if the current instance if the date is in a leap year.
     *
     * @return True if the current instance is in a leap year, otherwise false.
     */
    public boolean isLeapYear() {
        return super.isLeapYear(getYear());
    }

    /**
     * Checks if the current instance of <code>CalendarDate</code> is between
     * the given start and end <code>Calendar</code>
     *
     * @param start the start of the range
     * @param end   the end of the range
     * @return True if the current instance of <code>CalendarDate</code> is
     * between the given start and end <code>Calendar</code>.
     * @see CalendarDate#isLessThan(Calendar calender)
     * @see CalendarDate#isGreaterThan(Calendar calender)
     */
    public boolean isBetween(Calendar start, Calendar end) {
        if (this.isGreaterThan(start) && this.isLessThan(end)) {
            return true;
        }

        return false;
    }

    /**
     * Returns if the given <code>Calendar</code> is equal to the year, month and day
     * of the current <code>CalendarData</code>.
     *
     * @param calendar The calendar to check
     * @return True if the given <code>Calendar</code>'s year, month and day are equal to the
     * current instance's year;
     * @see CalendarDate#equalsYear(Calendar calendar)
     * @see CalendarDate#equalsMonth(Calendar calendar)
     */
    public boolean equalsDay(Calendar calendar) {
        if (!equalsMonth(calendar)) {
            return false;
        }

        return getDayOfTheMonth() == calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Returns if the given <code>Calendar</code> is equal to only the year and month
     * of the current <code>CalendarData</code>.
     *
     * @param calendar The calendar to check
     * @return True if the given <code>Calendar</code>'s month and year are equal to the
     * current instance's year;
     * @see CalendarDate#equalsYear(Calendar calendar)
     */
    public boolean equalsMonth(Calendar calendar) {
        if (!equalsYear(calendar)) {
            return false;
        }

        return getMonth() == calendar.get(Calendar.MONTH);
    }

    /**
     * Returns if the given <code>Calendar</code> is equal to only the year of the
     * current <code>CalendarData</code>.
     *
     * @param calendar The calendar to check
     * @return True if the given <code>Calendar</code>'s year is equal to the
     * current instance's year;
     */
    public boolean equalsYear(Calendar calendar) {
        if (calendar == null) {
            return false;
        }

        return getYear() == calendar.get(Calendar.YEAR);


    }

    /**
     * Returns if the give <code>Calendar</code> is less than the current
     * <code>CalendarData</code>.
     *
     * @param calendar The <code>Calendar</code> to check
     * @return True if the current instance is less than the given <code>Calendar</code>,
     * Otherwise false.
     */
    public boolean isLessThan(Calendar calendar) {
        return before(calendar);
    }

    /**
     * Returns if the give <code>Calendar</code> is greater than the current
     * <code>CalendarData</code>.
     *
     * @param calendar The <code>Calendar</code> to check
     * @return True if the current instance is greater than the given <code>Calendar</code>,
     * Otherwise false.
     */
    public boolean isGreaterThan(Calendar calendar) {
        return after(calendar);
    }

    /**
     * Returns if the current <code>CalendarDate</code> is a weekday.
     * E.g. The date of April 2nd, 2008 is a weekday because the day
     * of the week is a Wednesday
     *
     * @return True if the current <code>CalendarDate</code> is a weekday,
     * otherwise false.
     * @see DayOfWeek
     */
    public boolean isWeekday() {
        return DayOfWeek.isWeekday(this.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * Returns if the current <code>CalendarDate</code> is a weekend (
     * Saturday or Sunday).
     *
     * @return True if the current <code>CalendarDate</code> is a weekend,
     * otherwise false.
     * @see DayOfWeek
     */
    public boolean isWeekend() {
        return DayOfWeek.isWeekend(this.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * Returns if the current <code>CalendarDate</code> is the current
     * date.
     *
     * @return True if the current <code>CalendarData</code> is the
     * current date.
     * @see CalendarDate#areEqualDates(Calendar, Calendar)
     */
    public boolean isToday() {
        return areEqualDates(this, Time.currentDate());
    }

    /**
     * Adds a new <code>CalendarDate</code> with the given <code>Duration</code>
     * added to the return instance.
     *
     * @param duration <code>Duration</code> to add
     * @return a new <code>CalendarDate</code> with the given <code>Duration</code>
     * added to the return instance.
     */
    public CalendarDate add(Duration duration) {
        return new CalendarDate(this.getTimeInMillis() + duration.getTimeInMillis(), getTimeZone());
    }

    /**
     * Creates a new <code>CalendarDate</code> from the current instance
     * with the given number of hours added to the epoch.
     * <br/><br/>
     * Note: Adding more hours than which the current day has remaining
     * will cause a roll to the next year. E.g. Adding 48 hours  to
     * 4/15/2008 will return 4/17/2008.
     *
     * @param hours number to add
     * @return a new <code>CalendarDate</code>
     */
    public CalendarDate addHours(int hours) {
        return new CalendarDate(this.getTimeInMillis() + Hours.toMilliseconds(hours), getTimeZone());
    }

    /**
     * Creates a new <code>CalendarDate</code> from the current instance
     * with the given number of days added to the epoch.
     * <br/><br/>
     * Note: Adding more days than which the current year has remaining
     * will cause a roll to the next year. E.g. Adding 365 day to
     * 4/15/2008 will return 4/15/2009.
     *
     * @param days number to add
     * @return a new <code>CalendarDate</code>
     */
    public CalendarDate addDays(int days) {
        return new CalendarDate(this.getTimeInMillis() + Days.toMilliseconds(days), getTimeZone());
    }

    /**
     * Creates a new <code>CalendarDate</code> from the current instance
     * with the given number of months added to the epoch.
     * <br/><br/>
     * Note: Adding more months than which the current year has remaining
     * will cause a roll to the next year. E.g. Adding 24 months to
     * 4/15/2008 will return 4/15/2010.
     *
     * @param months number to add
     * @return a new <code>CalendarDate</code>
     */
    public CalendarDate addMonths(int months) {
        //TODO: Refactor method, consider more encapsulation
        final int grossMonthsToAdd = getMonth() + months;

        if (grossMonthsToAdd > Months.MAX_VALUE) {
            GregorianCalendar baseCalendar = toGregorianCalendar();

            int monthsLeftToAdd = 0;
            while (monthsLeftToAdd < months) {

                if (baseCalendar.getActualMaximum(MONTH) == baseCalendar.get(Calendar.MONTH)) {
                    baseCalendar.roll(Calendar.YEAR, 1);
                }

                baseCalendar.roll(Calendar.MONTH, 1);

                monthsLeftToAdd++;
            }

            return CalendarDate.of(baseCalendar);

        } else {
            return CalendarDate.of(getYear(), getMonth() + months, getDayOfTheMonth());
        }
    }

    /**
     * Creates a new <code>CalendarDate</code> from the current instance
     * with the given number of years added to the epoch.
     * <br/><br/>
     * Note: Adding a year to a leap year day rolls forward to the next day in
     * the year.
     *
     * @param years number to add
     * @return a new <code>CalendarDate</code>
     */
    public CalendarDate addYears(int years) {
        return CalendarDate.of(getYear() + years, getMonth(), getDayOfTheMonth());

    }

    /**
     * Returns the differance in days between the current instance of
     * the <code>CalendarDate</code> and the given <code>Calendar</code>.
     * If the current instance is less than the given the result will be
     * negative, otherwise results will be a positive.
     *
     * @param calendar The calendar to subtract from
     * @return The days differance between the two
     */
    public int diffInDays(Calendar calendar) {
        return CalendarCalculator.calculateDaysDifference(this, calendar);
    }

    /**
     * Returns the differance in hours between the current instance of
     * the <code>CalendarDate</code> and the given <code>Calendar</code>.
     * If the current instance is less than the given the result will be
     * negative, otherwise results will be a positive.
     *
     * @param calendar The calendar to subtract from
     * @return The hours differance between the two
     */
    public int diffInHours(Calendar calendar) {
        return CalendarCalculator.calculateHoursDifference(this, calendar);
    }

    /**
     * Returns a new <code>CalendarDate</code> to the nearest weekday
     * <br/>
     * <table border="1">
     * <tr>
     * <td>value</td><td>returns</td>
     * </tr>
     * <tr><td>SUNDAY</td><td>MONDAY</td></tr>
     * <tr><td>MONDAY</td><td>MONDAY</td></tr>
     * <tr><td>TUESDAY</td><td>TUESDAY</td></tr>
     * <tr><td>WEDNESDAY</td><td>WEDNESDAY</td></tr>
     * <tr><td>THURSDAY</td><td>THURSDAY</td></tr>
     * <tr><td>FRIDAY</td><td>FRIDAY</td></tr>
     * <tr><td>SATURDAY</td><td>FRIDAY</td></tr>
     * </table>
     *
     * @return
     */
    public CalendarDate toNearestWeekday() {

        switch (get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                return addDays(1);
            case Calendar.MONDAY:
                return this.copy();
            case Calendar.TUESDAY:
                return this.copy();
            case Calendar.WEDNESDAY:
                return this.copy();
            case Calendar.THURSDAY:
                return this.copy();
            case Calendar.FRIDAY:
                return this.copy();
            case Calendar.SATURDAY:
                return addDays(-1);
            default:
                return this.copy();
        }
    }

    /**
     * Creates a new instance of the currenct <code>CalendarDate</code> for the
     * give time zone.
     *
     * @param timeZone The time zone to return the <code>CalendarDate</code> in
     * @return a new instance of a <code>CalendarDate</code> for the given time zone.
     */
    public CalendarDate toTimeZone(TimeZone timeZone) {

        Calendar calendar = new GregorianCalendar(timeZone);
        calendar.setTimeInMillis(getTimeInMillis());

        return CalendarDate.of(calendar);

    }

    /**
     * Returns this Calendar's time value in milliseconds.
     *
     * @return the current time as UTC milliseconds from the epoch.
     * @see #getTime()
     */
    public long toMillis() {
        return getTimeInMillis();
    }

    /**
     * Returns a <code>String</code> that represents the ISO 8601 standard for a
     * date time <tt>yyyy-MM-dd'T'HH:mm:ss</tt>. E.g. The date of 1/15/2008 will return
     * 2008-01-15T00:00:00.
     *
     * @return ISO 8601 standard for a calendar date <tt>yyyy-MM-dd'T'HH:mm:ss</tt> as a <code>String</code>
     */
    public String toISODateTime() {
        return DateFormats.ISO_DATETIME_FORMAT.format(getTime());
    }

    /**
     * Returns a <code>String</code> that represents the ISO 8601 standard for a
     * date <tt>yyyy-MM-dd</tt>. E.g. The date of 1/15/2008 will return
     * 2008-01-15.
     *
     * @return ISO 8601 standard for a calendar date <tt>yyyy-MM-dd</tt> as a <code>String</code>
     */
    public String toISODate() {
        return DateFormats.ISO_DATE_FORMAT.format(getTime());
    }

    /**
     * Returns a <code>String</code> that represents the ISO 8601 standard for a
     * time <tt>'T'HH:mm:ss</tt>.
     *
     * @return ISO 8601 standard for a time <tt>'T'HH:mm:ss</tt> as a <code>String</code>
     */
    public String toISOTime() {
        return DateFormats.ISO_TIME_FORMAT.format(getTime());
    }

    /**
     * Returns a <code>String</code> that represents the ISO 8601 standard for a
     * date time with time zone <tt>yyyy-MM-dd'T'HH:mm:ssZZ</tt>.
     *
     * @return ISO 8601 standard for a time<tt>yyyy-MM-dd'T'HH:mm:ssZZ</tt> as a <code>String</code>
     */
    public String toISODateTimeWithZone() {
        return DateFormats.ISO_DATETIME_TIME_ZONE_FORMAT.format(getTime());
    }

    /**
     * Returns a <code>String</code> that represents the ISO 8601 standard for a
     * year(YYYY). E.g. The date of 1/1/2008 will return 2008.
     *
     * @return ISO 8601 standard for a year(YYYY) as a <code>String</code>
     */
    public String toISOYear() {
        return String.valueOf(getYear());
    }

    @Override
    public String toString() {
        return "Date: " + (getMonth() + 1) + "/" + getDayOfTheMonth() + "/" + getYear();
    }

    /**
     * <p>Formats a calendar into a specific pattern.</p>
     *
     * @param pattern the pattern to use to format the calendar
     * @return the formatted calendar as a {@Code String}
     * @see DateFormats
     */
    public String toString(String pattern) {
        return DateFormats.format(this, pattern);
    }

    /**
     * Converts the current <code>CalendarDate</code> to a <code>GregorianCalendar</code>
     * with the same time in millis
     *
     * @return a new instance of a <code>GregorianCalendar</code>
     * @see GregorianCalendar
     */
    public GregorianCalendar toGregorianCalendar() {
        GregorianCalendar baseCalendar = new GregorianCalendar();
        baseCalendar.setTimeInMillis(getTimeInMillis());

        return baseCalendar;
    }

    /**
     * Converts the current <code>CalendarDate</code> to a <code>java.util.Date</code>
     * with the same time in millis
     *
     * @return a new instance of a <code>java.util.Date</code>
     * @see java.util.Date
     */
    public java.util.Date toUtilDate() {
        return new java.util.Date(getTimeInMillis());
    }

    /**
     * Converts the current <code>CalendarDate</code> to a <code>java.sql.Date</code>
     * with the same time in millis
     *
     * @return a new instance of a <code>java.sql.Date</code>
     * @see java.util.Date
     */
    public java.sql.Date toSQLDate() {
        return new java.sql.Date(getTimeInMillis());
    }

    /**
     * Returns a <code>CalendarDate</code> which is the first day of the week.
     *
     * @return CalendarDate
     */
    public CalendarDate getFirstCalendarDateOfWeek() {
        CalendarDate firstDayOfWeek = this;
        while (firstDayOfWeek.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            firstDayOfWeek = firstDayOfWeek.addDays(-1);
        }
        return CalendarDate.of(firstDayOfWeek);
    }

    public CalendarDate copy() {
        return (CalendarDate) this.clone();
    }

    /**
     * Returns a <code>CalendarDate</code> which is the last day of the week.
     *
     * @return CalendarDate
     */
    public CalendarDate getLastCalendarDateOfWeek() {
        CalendarDate lastDayOfWeek = this;
        while (lastDayOfWeek.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
            lastDayOfWeek = lastDayOfWeek.addDays(1);
        }
        return CalendarDate.of(lastDayOfWeek);
    }

    /**
     * Returns if the current instance of {@code CalendarDate}'s hour is between the given range of hours
     *
     * @param startHr start hour in 24 notation
     * @param endHr   end hour in 24 notation
     * @return
     */
    public boolean isBetweenHours(int startHr, int endHr) {
        return (getHourOfTheDay() >= startHr && getHourOfTheDay() <= endHr);
    }

    public boolean isHoliday() {
        return localeDateTimeInfo.isHoliday(this);
    }

}


