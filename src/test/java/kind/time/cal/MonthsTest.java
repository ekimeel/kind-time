package kind.time.cal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class MonthsTest {

    @Test
    public void testMin() {
        assertEquals(0, Months.MIN_VALUE);
    }

    @Test
    public void testMax() {
        assertEquals(11, Months.MAX_VALUE);
    }

    @Test
    public void testNumberOfDaysInMonth() {

        assertEquals("JANUARY", 31, Months.daysInMonth(2007, Months.JANUARY));
        assertEquals("FEBRUARY", 28, Months.daysInMonth(2007, Months.FEBRUARY));
        assertEquals("MARCH", 31, Months.daysInMonth(2007, Months.MARCH));
        assertEquals("APRIL", 30, Months.daysInMonth(2007, Months.APRIL));
        assertEquals("MAY", 31, Months.daysInMonth(2007, Months.MAY));
        assertEquals("JUNE", 30, Months.daysInMonth(2007, Months.JUNE));
        assertEquals("JULY", 31, Months.daysInMonth(2007, Months.JULY));
        assertEquals("AUGUST", 31, Months.daysInMonth(2007, Months.AUGUST));
        assertEquals("SEPTEMBER", 30, Months.daysInMonth(2007, Months.SEPTEMBER));
        assertEquals("OCTOBER", 31, Months.daysInMonth(2007, Months.OCTOBER));
        assertEquals("NOVEMBER", 30, Months.daysInMonth(2007, Months.NOVEMBER));
        assertEquals("DECEMBER", 31, Months.daysInMonth(2007, Months.DECEMBER));
    }

    @Test
    public void testNumberOfDaysInMonthOnALeapYear() {
        assertEquals(29, Months.daysInMonth(2008, Months.FEBRUARY)); //<--Leap year so one extra day
    }

//    @Test
//    public void testToDayOfWeek(){
//        assertEquals(Days.TUESDAY, Months.toDayOfWeek(CalendarMonth.of(2008, Months.APRIL), 1));
//        
//        //fail("TODO");
//        
//        //System.out.println(Months.toDayOfWeek(month, 1));
//    }
}
