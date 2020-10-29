
package kind.time.cal;

import java.util.Calendar;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class CalendarCalculatorTest {

    private Calendar startCalendarDate = CalendarDate.of(2007, Calendar.FEBRUARY, 16);

    private Calendar endCalendarDate = CalendarDate.of(2007, Calendar.MARCH, 15);


    @Test
    public void testDaysDifferenceWhenCrossingMonths() {
        assertEquals(27, CalendarCalculator.calculateDaysDifference(startCalendarDate, endCalendarDate));
    }

    @Test
    public void testDaysDifferenceWhenCrossingMonthsWithLeapYear() {
        //2008 is a leap year
        startCalendarDate = CalendarDate.of(2008, Calendar.FEBRUARY, 16);
        endCalendarDate = CalendarDate.of(2008, Calendar.MARCH, 15);

        assertEquals(28, CalendarCalculator.calculateDaysDifference(startCalendarDate, endCalendarDate));
    }

    @Test
    public void testDaysDifferenceForYearsTimeFrame() {
        Calendar startOfYearCalendarDate = CalendarDate.of(2007, Calendar.JANUARY, 1);
        Calendar endOfYearCalendarDate = CalendarDate.of(2007, Calendar.DECEMBER, 31);
        assertEquals(364, CalendarCalculator.calculateDaysDifference(startOfYearCalendarDate, endOfYearCalendarDate));
    }


}
