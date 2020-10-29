
package kind.time.cal;

import org.junit.Test;

import static org.junit.Assert.*;
import static kind.test.assertions.DateTimeAsserts.*;

/**
 * @author Michael J. Lee
 */
public class CalendarYearTest {


    @Test
    public void testGetDayOfTheYear() {
        CalendarYear year1990 = CalendarYear.of(1990);
        CalendarDate date = year1990.getDate(Months.SEPTEMBER, 1);
        assertIsSeptember(date);
        assertDayOfMonth(1, date);
        assertYear(1990, date);


    }

    @Test
    public void testGetAllCalendarDates() {

        CalendarYear year2009 = CalendarYear.of(2009);
        assertEquals(365, year2009.getAllDates().length);

        CalendarYear year2007 = CalendarYear.of(2007);
        assertEquals(365, year2007.getAllDates().length);
    }

    @Test
    public void testGetAllCalendarDatesOnLeapYears() {

        CalendarYear year2000 = CalendarYear.of(2000);
        assertEquals(366, year2000.getAllDates().length);

        CalendarYear year2008 = CalendarYear.of(2008);
        assertEquals(366, year2008.getAllDates().length);
    }

    @Test
    public void testGetAllCalenderMonths() {
        CalendarYear year2008 = CalendarYear.of(2008);
        CalendarMonth[] monthsIn2008 = year2008.getAllMonths();
        assertEquals(12, monthsIn2008.length);
        assertEquals(Months.JANUARY, monthsIn2008[0].getActualMonth());
        assertEquals(Months.FEBRUARY, monthsIn2008[1].getActualMonth());
        assertEquals(Months.MARCH, monthsIn2008[2].getActualMonth());
        assertEquals(Months.APRIL, monthsIn2008[3].getActualMonth());
        assertEquals(Months.MAY, monthsIn2008[4].getActualMonth());
        assertEquals(Months.JUNE, monthsIn2008[5].getActualMonth());
        assertEquals(Months.JULY, monthsIn2008[6].getActualMonth());
        assertEquals(Months.AUGUST, monthsIn2008[7].getActualMonth());
        assertEquals(Months.SEPTEMBER, monthsIn2008[8].getActualMonth());
        assertEquals(Months.OCTOBER, monthsIn2008[9].getActualMonth());
        assertEquals(Months.NOVEMBER, monthsIn2008[10].getActualMonth());
        assertEquals(Months.DECEMBER, monthsIn2008[11].getActualMonth());

    }


    @Test
    public void testGetAllCalendarDatesOnANonLeapYearContains365Dates() {
        CalendarYear year = CalendarYear.of(2009);
        CalendarDate[] dates = year.getAllDates();
        assertEquals(365, dates.length);
    }

    @Test
    public void testGetAllCalendarDatesOnALeapYearContains366Dates() {
        CalendarYear year = CalendarYear.of(2008);
        CalendarDate[] dates = year.getAllDates();
        assertEquals(366, dates.length);
    }


    @Test
    public void testToInt() {

        assertEquals(1987, CalendarYear.of(1987).toInt());
        assertEquals(1999, CalendarYear.of(1999).toInt());
        assertEquals(2008, CalendarYear.of(2008).toInt());
    }

    @Test
    public void testGetMonth() {
        final CalendarYear year2008 = CalendarYear.of(2008);
        CalendarMonth april = null;

        april = year2008.getMonth(Months.APRIL);
        assertNotNull(april);
        assertEquals(Month.APRIL, april.getMonth());

        april = year2008.getMonth(3);
        assertNotNull(april);
        assertEquals(Month.APRIL, april.getMonth());
    }


}
