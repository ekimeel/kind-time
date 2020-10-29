package kind.time.cal;


import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;


import kind.time.Days;
import kind.time.Minutes;
import kind.time.tz.TimeZones;
import org.junit.Test;

import static kind.test.assertions.DateTimeAsserts.*;
import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class CalendarDateTest {

    private int year;

    private int month;

    private int dayOfMonth;

    private int hour;


    @Test
    public void testToString_string() {
        assertEquals("01/02/2009", CalendarDate.of(2009, 0, 2).toString("MM/dd/yyyy"));
        assertEquals("2009-01-02", CalendarDate.of(2009, 0, 2).toString("yyyy-MM-dd"));
        assertEquals("2009", CalendarDate.of(2009, 0, 2).toString("yyyy"));
        assertEquals("01", CalendarDate.of(2009, 0, 2).toString("MM"));
        assertEquals("02", CalendarDate.of(2009, 0, 2).toString("dd"));
    }

    @Test
    public void testIsBetweenHours_int_int_whenNot() {
        CalendarDate date = CalendarDate.of(2009, Months.JANUARY, 15, 5);
        assertFalse(date.isBetweenHours(10, 24));
    }

    @Test
    public void testIsBetweenHours_int_int_whenHourIsOnEnd() {
        CalendarDate date = CalendarDate.of(2009, Months.JANUARY, 15, 5);
        assertTrue(date.isBetweenHours(2, 5));
    }

    @Test
    public void testIsBetweenHours_int_int_whenHourIsOnStart() {
        CalendarDate date = CalendarDate.of(2009, Months.JANUARY, 15, 5);
        assertTrue(date.isBetweenHours(5, 6));
    }

    @Test
    public void testIsBetweenHours_int_int() {
        CalendarDate beforeNoon = CalendarDate.of(2009, Months.JANUARY, 15, 5);
        assertTrue(beforeNoon.isBetweenHours(4, 6));

        CalendarDate afterNoon = CalendarDate.of(2009, Months.JANUARY, 15, 23);
        assertTrue(afterNoon.isBetweenHours(20, 23));
    }

    @Test
    public void testFirstDayOfWeekIsCorrectDuringTheWeek() throws InvalidDateException {
        CalendarDate util = CalendarDate.of(2008, 9, 28);
        CalendarDate cal2 = util.getFirstCalendarDateOfWeek();

        assertEquals(26, cal2.get(Calendar.DATE));
        assertEquals(10, cal2.get(Calendar.MONTH) + 1);
        assertEquals(2008, cal2.get(Calendar.YEAR));

    }

    @Test
    public void testLastDayOfWeekIsCorrectDuringTheWeek() throws InvalidDateException {
        //October 29th, 2008
        CalendarDate util = CalendarDate.of(2008, 9, 29);
        CalendarDate cal2 = util.getLastCalendarDateOfWeek();

        //November 01th, 2008
        assertEquals(01, cal2.get(Calendar.DATE));
        assertEquals(10, cal2.get(Calendar.MONTH));
        assertEquals(2008, cal2.get(Calendar.YEAR));
    }

    @Test
    public void testLastDayOfWeekIsCorrectCrossingMonths() throws InvalidDateException {
        //November 30, 2008
        CalendarDate util = CalendarDate.of(2008, 10, 30);
        Calendar cal2 = util.getLastCalendarDateOfWeek();

        //December 6th, 2008
        assertEquals(06, cal2.get(Calendar.DATE));
        assertEquals(11, cal2.get(Calendar.MONTH));
        assertEquals(2008, cal2.get(Calendar.YEAR));
    }

    @Test
    public void testFirstDayOfWeekIsCorrectCrossingMonths() throws InvalidDateException {
        //December 6th, 2008
        CalendarDate util = CalendarDate.of(2008, 11, 6);
        Calendar cal2 = util.getFirstCalendarDateOfWeek();

        //November 30, 2008
        assertEquals(30, cal2.get(Calendar.DATE));
        assertEquals(10, cal2.get(Calendar.MONTH));
        assertEquals(2008, cal2.get(Calendar.YEAR));
    }

    @Test
    public void testLastDayOfWeekIsCorrectCrossingYears() throws InvalidDateException {
        //December 30, 2008
        CalendarDate util = CalendarDate.of(2008, 11, 30);
        Calendar cal2 = util.getLastCalendarDateOfWeek();

        //January 3rd, 2009
        assertEquals(03, cal2.get(Calendar.DATE));
        assertEquals(0, cal2.get(Calendar.MONTH));
        assertEquals(2009, cal2.get(Calendar.YEAR));
    }

    @Test
    public void testFirstDayOfWeekIsCorrectCrossingYears() throws InvalidDateException {
        //January 2nd, 2008
        CalendarDate util = CalendarDate.of(2008, 0, 2);
        Calendar cal2 = util.getFirstCalendarDateOfWeek();

        //December 30th, 2007
        assertEquals(30, cal2.get(Calendar.DATE));
        assertEquals(11, cal2.get(Calendar.MONTH));
        assertEquals(2007, cal2.get(Calendar.YEAR));
    }

    @Test
    public void testDefaultMonth() {

        assertEquals(0, CalendarDate.DEFAULT_MONTH);
    }

    @Test
    public void testDefaultMinuteOfHour() {
        assertEquals(0, CalendarDate.DEFAULT_MINUTE_OF_HOUR);
    }

    @Test
    public void testDefaultHourOfDay() {
        assertEquals(0, CalendarDate.DEFAULT_HOUR_OF_DAY);
    }

    @Test
    public void testDefaultDayOfTheMonth() {
        assertEquals(1, CalendarDate.DEFAULT_DAY_OF_MONTH);
    }

    @Test
    public void testToISOTime() {
        CalendarDate nov4 = CalendarDate.of(2008, Months.NOVEMBER, 4, 5, 15, 45);


        assertEquals("T05:15:45", nov4.toISOTime());
    }

    @Test
    public void testToISODate() {
        CalendarDate nov4 = CalendarDate.of(2008, Months.NOVEMBER, 4, 5, 15, 45);
        assertEquals("2008-11-04", nov4.toISODate());
    }

    @Test
    public void testToISODateTimeOnALeapYear() {
        CalendarDate feb29 = CalendarDate.of(2008, Months.FEBRUARY, 29, 14, 32, 12);
        assertEquals("2008-02-29T14:32:12", feb29.toISODateTime());
    }

    @Test
    public void testToISODateTime() {
        CalendarDate apr26 = CalendarDate.of(2008, Months.APRIL, 26, 14, 32, 12);
        assertEquals("2008-04-26T14:32:12", apr26.toISODateTime());
    }

    @Test
    public void testIsToday() {
        CalendarDate now = CalendarDate.now();
        CalendarDate tomorrow = now.addDays(1);
        CalendarDate yesterday = now.addDays(-1);


        assertFalse(yesterday.isToday());
        assertTrue(now.isToday());
        assertFalse(tomorrow.isToday());

    }

    @Test
    public void testNow() {

        Calendar nowAsGregorianCalendar = GregorianCalendar.getInstance();
        CalendarDate nowAsCalendarDate = CalendarDate.now();

        final long timeDiff = nowAsGregorianCalendar.getTimeInMillis() - nowAsCalendarDate.getTimeInMillis();
        assertTrue(timeDiff < Minutes.ONE.getTimeInMillis()); //<--tolerance of one minute for cpu
    }

    @Test
    public void testIsWeekday() {

        CalendarDate tuesday = CalendarDate.of(2008, Months.JANUARY, 1);
        CalendarDate wednesday = tuesday.addDays(1);
        CalendarDate thursday = wednesday.addDays(1);
        CalendarDate friday = thursday.addDays(1);
        CalendarDate saturday = friday.addDays(1);
        CalendarDate sunday = saturday.addDays(1);
        CalendarDate monday = sunday.addDays(1);

        assertTrue(tuesday.isWeekday());
        assertTrue(wednesday.isWeekday());
        assertTrue(thursday.isWeekday());
        assertTrue(friday.isWeekday());
        assertTrue(saturday.isWeekend());
        assertTrue(sunday.isWeekend());
        assertTrue(monday.isWeekday());
    }

    @Test
    public void testToJavaUtilDate() {
        CalendarDate date = CalendarDate.of("9/15/2008", "MM/dd/yyyy");
        java.util.Date dateAsJava = date.toUtilDate();
        assertEquals(date.getTimeInMillis(), dateAsJava.getTime());
    }

    @Test
    public void testToSQLDate() {
        CalendarDate date = CalendarDate.of("9/15/2008", "MM/dd/yyyy");
        java.sql.Date dateAsSQL = date.toSQLDate();
        assertEquals(date.getTimeInMillis(), dateAsSQL.getTime());
    }

    @Test
    public void testToGregorianCalendar() {
        CalendarDate date = CalendarDate.of("9/15/2008", "MM/dd/yyyy");
        Calendar dateAsCalendar = date.toGregorianCalendar();
        assertEquals(date.getTimeInMillis(), dateAsCalendar.getTimeInMillis());
    }

    @Test
    public void testGetYear() {
        CalendarDate date = CalendarDate.of("9/15/2008", "MM/dd/yyyy");
        assertEquals(2008, date.getYear());
    }

    @Test
    public void testGetDayOfYear() {
        CalendarDate date = CalendarDate.of("1/15/2008", "MM/dd/yyyy");
        assertEquals(15, date.getDayOfTheYear());
    }

    @Test
    public void testAddMonthsThatWillRollToTheNextYear() {
        CalendarDate may = CalendarDate.of("5/15/2008", "MM/dd/yyyy");

        CalendarDate mayIn24Months = may.addMonths(24);
        assertIsMay(mayIn24Months);
        assertYear(2010, mayIn24Months);
        assertDayOfMonth(15, mayIn24Months);
    }

    @Test
    public void testAddMonths() {
        CalendarDate may = CalendarDate.of("5/15/2008", "MM/dd/yyyy");

        CalendarDate june = may.addMonths(1);
        assertIsJune(june);
        assertDayOfMonth(15, june);

        CalendarDate july = may.addMonths(2);
        assertIsJuly(july);
        assertDayOfMonth(15, july);

        CalendarDate august = may.addMonths(3);
        assertIsAugust(august);
        assertDayOfMonth(15, august);

        CalendarDate september = may.addMonths(4);
        assertIsSeptember(september);
        assertDayOfMonth(15, september);
    }

    @Test
    public void testToISOYear() {
        assertEquals("4048", CalendarDate.of(4048, Months.JULY, 4).toISOYear());
        assertEquals("2008", CalendarDate.of(2008, Months.JULY, 4).toISOYear());
        assertEquals("1842", CalendarDate.of(1842, Months.JULY, 4).toISOYear());
    }

    @Test
    public void testGetHoursInADayOnALeapYearStart() {
        LocaleDateTimeInfo dates = new SimpleUSLocaleDateTimeInfo();

        CalendarDate date = (CalendarDate) dates.getDaylightSavingsStart(2008);

        assertTrue(date.isDayLightSavings()); //<--Make sure the day is a DST
        assertEquals(22, date.getActualHoursInDay());
    }

    @Test
    public void testGetHoursInADayOnANormalDay() {
        CalendarDate date = CalendarDate.of(2007, Calendar.FEBRUARY, 16);
        assertFalse("This should not be a DST date", date.isDayLightSavings()); //<--Make sure the day is not a DST start or end 
        assertEquals(23, date.getActualHoursInDay());
    }

    @Test
    public void testDiffInDaysWhenGivenCalendarIsLessThan() {
        CalendarDate startCalendarDate = CalendarDate.of(2007, Calendar.FEBRUARY, 16);
        CalendarDate endCalendarDate = CalendarDate.of(2007, Calendar.MARCH, 15);

        assertEquals(-27, endCalendarDate.diffInDays(startCalendarDate));
    }

    @Test
    public void testDiffInDaysWhenCrossingMonths() {
        CalendarDate startCalendarDate = CalendarDate.of(2007, Calendar.FEBRUARY, 16);
        CalendarDate endCalendarDate = CalendarDate.of(2007, Calendar.MARCH, 15);

        assertEquals(27, startCalendarDate.diffInDays(endCalendarDate));
    }

    @Test
    public void testDiffInDaysWhenCrossingMonthsWithLeapYear() {
        CalendarDate startCalendarDate = CalendarDate.of(2008, Calendar.FEBRUARY, 16);
        CalendarDate endCalendarDate = CalendarDate.of(2008, Calendar.MARCH, 15);

        assertEquals(28, startCalendarDate.diffInDays(endCalendarDate));
    }

    @Test
    public void testDaysDifferenceForYearsTimeFrame() {
        CalendarDate startCalendarDate = CalendarDate.of(2007, Calendar.JANUARY, 1);
        CalendarDate endCalendarDate = CalendarDate.of(2007, Calendar.DECEMBER, 31);

        assertEquals(364, startCalendarDate.diffInDays(endCalendarDate));
    }

    @Test
    public void testIsBetween() {

        CalendarDate aug9th = CalendarDate.of(2008, Months.AUGUST, 9);
        CalendarDate aug10th = CalendarDate.of(2008, Months.AUGUST, 10);
        CalendarDate aug11th = CalendarDate.of(2008, Months.AUGUST, 11);

        assertTrue(aug10th.isBetween(aug9th, aug11th));

        assertFalse(aug11th.isBetween(aug9th, aug10th));
        assertFalse(aug9th.isBetween(aug10th, aug11th));
    }

    @Test
    public void testIsBetweenWhenGivenNull() {
        CalendarDate aug10th = CalendarDate.of(2008, Months.AUGUST, 10);

        assertFalse(aug10th.isBetween(null, null));
    }

    @Test
    public void testToTimeZone() {
        CalendarDate estDate = CalendarDate.of(2008, Months.DECEMBER, 5, 12, 30, TimeZones.EASTERN_STANDARD_DAYLIGHT_SAVINGS);

        CalendarDate mntDate = estDate.toTimeZone(TimeZones.MOUNTAIN_STANDARD_DAYLIGHT_SAVINGS);

        assertEquals(2008, mntDate.getYear());
        assertEquals(Months.DECEMBER, mntDate.getMonth());
        assertEquals(5, mntDate.getDayOfTheMonth());
        assertEquals(10, mntDate.getHourOfTheDay());//<-- two hours back
        assertEquals(30, mntDate.getMinuteOfTheHour());

    }

    @Test
    public void testIsLeapYear() {

        assertTrue(CalendarDate.of(2008).isLeapYear());//<--leap year
        assertFalse(CalendarDate.of(2007).isLeapYear());
        assertFalse(CalendarDate.of(2006).isLeapYear());
        assertFalse(CalendarDate.of(2005).isLeapYear());

        assertTrue(CalendarDate.of(2004).isLeapYear());//<--leap year
        assertFalse(CalendarDate.of(2003).isLeapYear());
        assertFalse(CalendarDate.of(2002).isLeapYear());
        assertFalse(CalendarDate.of(2001).isLeapYear());

        assertTrue(CalendarDate.of(2000).isLeapYear());//<--leap year
        assertFalse(CalendarDate.of(1999).isLeapYear());
        assertFalse(CalendarDate.of(1998).isLeapYear());
        assertFalse(CalendarDate.of(1997).isLeapYear());
    }

    @Test
    public void testEqualsDay() {
        CalendarDate jan14of2008_1 = CalendarDate.of(2008, Months.JANUARY, 14);
        CalendarDate jan14of2008_2 = CalendarDate.of(2008, Months.JANUARY, 14);

        assertTrue(jan14of2008_1.equalsDay(jan14of2008_2));
        assertTrue(jan14of2008_2.equalsDay(jan14of2008_1));

        CalendarDate jan15of2008 = CalendarDate.of(2008, Months.JANUARY, 15);

        assertFalse(jan15of2008.equalsDay(jan14of2008_1));
    }

    @Test
    public void testEqualsMonth() {
        CalendarDate jan1of2008 = CalendarDate.of(2008, Months.JANUARY, 1);
        CalendarDate jan2of2008 = CalendarDate.of(2008, Months.JANUARY, 2);

        assertTrue(jan1of2008.equalsMonth(jan2of2008));
        assertTrue(jan2of2008.equalsMonth(jan1of2008));

        CalendarDate feb2of2008 = CalendarDate.of(2008, Months.FEBRUARY, 2);

        assertFalse(feb2of2008.equalsMonth(jan2of2008));
    }

    @Test
    public void testEqualsYear() {
        CalendarDate jan2008 = CalendarDate.of(2008, Months.JANUARY, 1);
        CalendarDate feb2008 = CalendarDate.of(2008, Months.FEBRUARY, 2);

        assertTrue(jan2008.equalsYear(feb2008));
        assertTrue(feb2008.equalsYear(jan2008));

        CalendarDate apr2009 = CalendarDate.of(2009, Months.APRIL, 12);

        assertFalse(jan2008.equalsYear(apr2009));
        assertFalse(apr2009.equalsYear(feb2008));
    }

    @Test
    public void testGreaterThan() {
        CalendarDate jan01 = CalendarDate.of(2008, Months.JANUARY, 1);
        CalendarDate jan02 = CalendarDate.of(2008, Months.JANUARY, 2);

        assertTrue(jan02.isGreaterThan(jan01));
        assertFalse(jan01.isGreaterThan(jan02));
    }

    @Test
    public void testGreaterThanWhenGivenNull() {
        CalendarDate jan01 = CalendarDate.of(2008, Months.JANUARY, 1);
        assertFalse(jan01.isGreaterThan(null));
    }

    @Test
    public void testLessThan() {
        CalendarDate jan01 = CalendarDate.of(2008, Months.JANUARY, 1);
        CalendarDate jan02 = CalendarDate.of(2008, Months.JANUARY, 2);

        assertTrue(jan01.isLessThan(jan02));
        assertFalse(jan02.isLessThan(jan01));
    }

    @Test
    public void testLessThanWhenGivenNull() {
        CalendarDate jan01 = CalendarDate.of(2008, Months.JANUARY, 1);
        assertFalse(jan01.isLessThan(null));
    }

    @Test
    public void testAddHoursWithANegativeValue() {

        year = 2008;
        month = Month.SEPTEMBER.toInt();
        dayOfMonth = 1;
        hour = 0;

        CalendarDate date1 = CalendarDate.of(year, month, dayOfMonth);
        CalendarDate date2 = date1.addHours(-1); //<--puts us in the previous month

        assertEquals(31, date2.getDayOfTheMonth());
        assertEquals(Month.AUGUST.toInt(), date2.getMonth());
        assertEquals(year, date2.getYear());
        assertEquals(23, date2.getHourOfTheDay());
    }

    @Test
    public void testAddHoursMovesToTheNextDay() {
        year = 2000;
        month = Month.JANUARY.toInt();
        dayOfMonth = 1;
        hour = 23;

        CalendarDate date1 = CalendarDate.of(year, month, dayOfMonth, hour);
        CalendarDate date2 = date1.addHours(1);

        assertEquals(dayOfMonth + 1, date2.getDayOfTheMonth());
        assertEquals(hour - 23, date2.getHourOfTheDay());
    }

    @Test
    public void testAddHours() {
        year = 2000;
        month = Month.JANUARY.toInt();
        dayOfMonth = 1;
        hour = 12;

        CalendarDate date1 = CalendarDate.of(year, month, dayOfMonth, hour);
        CalendarDate date2 = date1.addHours(2);

        assertEquals(dayOfMonth, date2.getDayOfTheMonth());
        assertEquals(hour + 2, date2.getHourOfTheDay());
    }

    @Test
    public void testAddDaysWithANegativeValue() {

        year = 2008;
        month = Month.SEPTEMBER.toInt();
        dayOfMonth = 1;

        CalendarDate date1 = CalendarDate.of(year, month, dayOfMonth);
        CalendarDate date2 = date1.addDays(-1); //<--puts us in the previous month

        assertEquals(31, date2.getDayOfTheMonth());
        assertEquals(Month.AUGUST.toInt(), date2.getMonth());
        assertEquals(year, date2.getYear());

    }

    @Test
    public void testAddDaysMovesToTheNextYear() {

        year = 2000;
        month = Month.JANUARY.toInt();
        dayOfMonth = 1;

        CalendarDate date1 = CalendarDate.of(year, month, dayOfMonth);
        CalendarDate date2 = date1.addDays(366); //<-- 366 days will put us into the next year on the same day
        assertEquals(1, date2.getDayOfTheMonth());
        assertEquals(Month.JANUARY.toInt(), date2.getMonth());
        assertEquals(year + 1, date2.getYear());
    }

    @Test
    public void testAddDaysMovesToTheNextMonth() {

        year = 2000;
        month = Month.JANUARY.toInt();
        dayOfMonth = 1;

        CalendarDate date1 = CalendarDate.of(year, month, dayOfMonth);
        CalendarDate date2 = date1.addDays(31); //<-- 31 days will put us into the next month

        assertEquals(1, date2.getDayOfTheMonth());
        assertEquals(Month.FEBRUARY.toInt(), date2.getMonth());
        assertEquals(year, date2.getYear());
    }

    @Test
    public void testAddDays() {

        year = 2000;
        month = Month.JANUARY.toInt();
        dayOfMonth = 1;

        CalendarDate date1 = CalendarDate.of(year, month, dayOfMonth);
        CalendarDate date2 = date1.addDays(1);

        assertEquals(dayOfMonth, date1.getDayOfTheMonth());
        assertEquals(dayOfMonth + 1, date2.getDayOfTheMonth());
    }

    @Test
    public void testOf_int_int_int_holidaySchedule() {

        HolidaySchedule holidaySchedule = HolidaySchedule.of(new Holiday("4th of July", CalendarDate.of(2009, Months.JULY, 4)));
        CalendarDate forthOfJuly = CalendarDate.of(2009, Months.JULY, 4, holidaySchedule);
        CalendarDate notAHoliday = CalendarDate.of(2009, Months.SEPTEMBER, 3, holidaySchedule);
        assertTrue(forthOfJuly.isHoliday());
        assertFalse(notAHoliday.isHoliday());

    }

    @Test
    public void testOf_int_int_int_Empty_holidaySchedule() {

        HolidaySchedule holidaySchedule = HolidaySchedule.of();
        CalendarDate forthOfJuly = CalendarDate.of(2009, Months.JULY, 4, holidaySchedule);
        assertFalse(forthOfJuly.isHoliday());

    }

    @Test
    public void testOfOnACalendarCreatesADefensiveCopy() {

        int jan = Month.JANUARY.toInt();
        Calendar calendar = new GregorianCalendar(2008, 0, 1);
        CalendarDate calendarDate = CalendarDate.of(calendar);

        assertEquals(jan, calendarDate.getMonth());
        calendar.roll(Calendar.MONTH, 1);
        assertEquals(jan, calendarDate.getMonth());
    }

    @Test
    public void testAddUsingDurationOfOneDay() {
        year = 2008;
        month = Month.JULY.toInt();
        dayOfMonth = 5;

        CalendarDate date = CalendarDate.of(year, month, dayOfMonth);

        CalendarDate dateAdded = date.add(Days.ONE);

        assertEquals(dayOfMonth + 1, dateAdded.getDayOfTheMonth());
        assertEquals(month, dateAdded.getMonth());
        assertEquals(year, dateAdded.getYear());
    }

    @Test
    public void testAddUsingDurationOfTwoDays() {
        year = 2008;
        month = Month.DECEMBER.toInt();
        dayOfMonth = 5;

        CalendarDate date = CalendarDate.of(year, month, dayOfMonth);

        CalendarDate dateAdded = date.add(Days.TWO);

        assertEquals(dayOfMonth + 2, dateAdded.getDayOfTheMonth());
        assertEquals(month, dateAdded.getMonth());
        assertEquals(year, dateAdded.getYear());
    }

    @Test
    public void testOfWithAString() throws ParseException {


        CalendarDate calendarDate = CalendarDate.of("9/8/2008", "MM/dd/yyyy");

        assertMonth(Months.SEPTEMBER, calendarDate);
        assertYear(2008, calendarDate);
        assertDayOfMonth(8, calendarDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOfWithABadString() throws ParseException {


        CalendarDate.of("9#8#2008", "MM/dd/yyyy");
        fail("Should have thrown an exception.");
    }

    @Test
    public void testOfWithAYearDefaultsToTheFirstDayOfTheYear() {
        CalendarDate calendar = CalendarDate.of(2008);
        assertEquals(2008, calendar.getYear());
        assertEquals(Months.JANUARY, calendar.getMonth());
        assertEquals(1, calendar.getDayOfTheMonth());
        assertEquals(1, calendar.getDayOfTheYear());
        assertEquals(0, calendar.getHourOfTheDay());

    }

    @Test
    public void testOfYearAndMonth() {
        CalendarDate date = CalendarDate.of(2008, Months.DECEMBER);
        assertIsDecember(date);
        assertDayOfMonth(1, date);
        assertYear(2008, date);
    }

    @Test
    public void testAreEqualDates() {

        assertTrue(
                CalendarDate.areEqualDates(CalendarDate.of(1982, Months.APRIL, 26), CalendarDate.of(1982, Months.APRIL, 26)));

        assertTrue(
                CalendarDate.areEqualDates(CalendarDate.of(2020, Months.SEPTEMBER, 8), CalendarDate.of(2020, Months.SEPTEMBER, 8)));
    }

    @Test
    public void testAreEqualDatesWhenNot() {

        assertFalse(
                CalendarDate.areEqualDates(CalendarDate.of(1982, Months.APRIL, 27), CalendarDate.of(1982, Months.APRIL, 26)));

        assertFalse(
                CalendarDate.areEqualDates(CalendarDate.of(2021, Months.SEPTEMBER, 8), CalendarDate.of(2020, Months.SEPTEMBER, 8)));
    }

    @Test
    public void testAreEqualDatesWhenGivenNull() {

        assertFalse(
                CalendarDate.areEqualDates(null, CalendarDate.of(1982, Months.APRIL, 26)));

        assertFalse(
                CalendarDate.areEqualDates(CalendarDate.of(2020, Months.SEPTEMBER, 8), null));

        assertFalse(
                CalendarDate.areEqualDates(null, null));
    }
}
