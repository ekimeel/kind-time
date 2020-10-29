package kind.time.cal;

import java.util.Calendar;

import org.junit.Test;

import static org.junit.Assert.*;
import static kind.test.assertions.DateTimeAsserts.*;

/**
 * @author Michael J. Lee
 */
public class CalendarMonthTest {

    @Test
    public void testGetFirstDayOfWeek() {
        CalendarMonth month = CalendarMonth.of(1999, Months.JUNE);
        CalendarDate firstWednesday = month.getFirst(DayOfWeek.WEDNESDAY);

        assertIsJune(firstWednesday);
        assertIsWednesday(firstWednesday);
        assertDayOfMonth(2, firstWednesday); //2nd
    }

    @Test
    public void testGetLastDayOfWeek() {
        CalendarMonth month = CalendarMonth.of(1982, Months.SEPTEMBER);
        CalendarDate lastSaturday = month.getLast(DayOfWeek.SATURDAY);

        assertIsSeptember(lastSaturday);
        assertIsSaturday(lastSaturday);
        assertDayOfMonth(25, lastSaturday); //25th 
    }

    @Test
    public void testGetLastDayOfWeekOnALeapYear() {
        CalendarMonth month = CalendarMonth.of(2008, Months.FEBRUARY);
        CalendarDate lastFriday = month.getLast(DayOfWeek.FRIDAY);

        assertIsFeburay(lastFriday);
        assertIsFriday(lastFriday);
        assertDayOfMonth(29, lastFriday); //29th
    }

    @Test
    public void testGetFifthThursdayInDecemberWhenItDoesntExist() {
        CalendarMonth month = CalendarMonth.of(2002, Months.DECEMBER);
        assertNull(month.get(DayOfWeek.THURSDAY, 5));//<-- doesn't exist should return null;

    }

    @Test
    public void testGetSecondThursdayInMarch() {
        CalendarMonth month = CalendarMonth.of(2002, Months.MARCH);
        CalendarDate secondThursday = month.get(DayOfWeek.THURSDAY, 2);

        assertIsMarch(secondThursday);
        assertIsThursday(secondThursday);
        assertDayOfMonth(14, secondThursday);
    }

    @Test
    public void testGetFirstSundayInApril() {
        CalendarMonth month = CalendarMonth.of(2008, Months.APRIL);
        CalendarDate firstSunday = month.get(DayOfWeek.SUNDAY, 1);
        System.out.println(Calendar.SUNDAY);

        assertIsApril(firstSunday);
        assertIsSunday(firstSunday);
        assertDayOfMonth(6, firstSunday);
    }

    @Test
    public void testOfYeaAndMonth() {

        CalendarMonth apr = CalendarMonth.of(2008, Months.APRIL);


        assertEquals(Calendar.APRIL, apr.getMonth().getValue());
        assertEquals(2008, apr.getCalendarYear().getYear());
        assertEquals(30, apr.getAllDates().length);
    }

    @Test
    public void testGetDates() {
        CalendarMonth march = CalendarMonth.of(2008, Months.MARCH);

        CalendarDate[] allDaysInMarch = march.getAllDates();

        assertEquals(1, allDaysInMarch[0].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[0].getYear());
        assertIsSaturday(allDaysInMarch[0]);


        assertEquals(2, allDaysInMarch[1].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[1].getYear());

        assertEquals(3, allDaysInMarch[2].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[2].getYear());

        assertEquals(4, allDaysInMarch[3].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[3].getYear());

        assertEquals(5, allDaysInMarch[4].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[4].getYear());

        assertEquals(6, allDaysInMarch[5].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[5].getYear());

        assertEquals(7, allDaysInMarch[6].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[6].getYear());

        assertEquals(8, allDaysInMarch[7].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[7].getYear());

        assertEquals(9, allDaysInMarch[8].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[8].getYear());

        assertEquals(10, allDaysInMarch[9].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[9].getYear());

        assertEquals(11, allDaysInMarch[10].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[10].getYear());

        assertEquals(12, allDaysInMarch[11].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[11].getYear());

        assertEquals(13, allDaysInMarch[12].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[12].getYear());

        assertEquals(14, allDaysInMarch[13].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[13].getYear());

        assertEquals(15, allDaysInMarch[14].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[14].getYear());

        assertEquals(16, allDaysInMarch[15].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[15].getYear());

        assertEquals(17, allDaysInMarch[16].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[16].getYear());

        assertEquals(18, allDaysInMarch[17].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[17].getYear());

        assertEquals(19, allDaysInMarch[18].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[18].getYear());

        assertEquals(20, allDaysInMarch[19].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[19].getYear());

        assertEquals(21, allDaysInMarch[20].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[20].getYear());

        assertEquals(22, allDaysInMarch[21].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[21].getYear());

        assertEquals(23, allDaysInMarch[22].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[22].getYear());

        assertEquals(24, allDaysInMarch[23].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[23].getYear());

        assertEquals(25, allDaysInMarch[24].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[24].getYear());

        assertEquals(26, allDaysInMarch[25].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[25].getYear());

        assertEquals(27, allDaysInMarch[26].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[26].getYear());

        assertEquals(28, allDaysInMarch[27].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[27].getYear());

        assertEquals(29, allDaysInMarch[28].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[28].getYear());

        assertEquals(30, allDaysInMarch[29].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[29].getYear());

        assertEquals(31, allDaysInMarch[30].getDayOfTheMonth());
        assertEquals(2008, allDaysInMarch[30].getYear());

//        

    }

    @Test
    public void testGetDayOfMonthWhenOutOfRange() {
        CalendarMonth nov = CalendarMonth.of(2008, Months.NOVEMBER);

        assertNull(nov.getDayOfMonth(0));
        assertNull(nov.getDayOfMonth(32));

    }

    @Test
    public void testGetDayOfMonth() {
        CalendarMonth nov = CalendarMonth.of(2008, Months.NOVEMBER);

        assertIsSaturday(nov.getDayOfMonth(1));
        assertDayOfMonth(1, nov.getDayOfMonth(1));
        assertIsNovember(nov.getDayOfMonth(1));
        assertYear(2008, nov.getDayOfMonth(1));

        assertIsSaturday(nov.getDayOfMonth(8));
        assertDayOfMonth(8, nov.getDayOfMonth(8));
        assertIsNovember(nov.getDayOfMonth(1));
        assertYear(2008, nov.getDayOfMonth(1));

        assertIsWednesday(nov.getDayOfMonth(19));
        assertDayOfMonth(19, nov.getDayOfMonth(19));
        assertIsNovember(nov.getDayOfMonth(1));
        assertYear(2008, nov.getDayOfMonth(1));

    }
}
