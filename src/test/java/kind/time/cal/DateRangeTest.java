package kind.time.cal;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class DateRangeTest {

    CalendarDate startDate;

    CalendarDate endDate;

    public DateRangeTest() {
    }

    @Before
    public void setup() throws InvalidDateException {
        startDate = CalendarDate.of(2008, Months.JANUARY, 1);
        endDate = CalendarDate.of(2008, Months.FEBRUARY, 1);
    }


    @Test
    public void testContainsDate() throws InvalidDateException {
        DateRange dateRange = DateRange.of(startDate, endDate);
        CalendarDate dateInBetweenRange = CalendarDate.of(2008, Months.JANUARY, 15);
        CalendarDate dateOutsideOfRange = CalendarDate.of(2008, Months.FEBRUARY, 15);
        CalendarDate dateOnBoundryStart = CalendarDate.of(2008, Months.JANUARY, 1);
        CalendarDate dateOnBoundryEnd = CalendarDate.of(2008, Months.FEBRUARY, 1);

        assertTrue("between dates should be true", dateRange.containsDate(dateInBetweenRange));
        assertFalse("outside dates should be false", dateRange.containsDate(dateOutsideOfRange));
        assertTrue("boundry dates (begin) should be true", dateRange.containsDate(dateOnBoundryStart));
        assertTrue("boundry dates (end)  should be true", dateRange.containsDate(dateOnBoundryEnd));
    }

    @Test
    public void testSetDateRangeWhenStartDateIsBeforeEndDate() throws InvalidDateException {
        DateRange dateRange = DateRange.of(startDate, endDate);
        assertNotNull("Date Range Is Null", dateRange);
    }

    @Test
    public void testSetDateRangeWhenStartDateIsAfterEndDate() throws InvalidDateException {
        endDate = CalendarDate.of(2007, Months.JANUARY, 1);

        assertEquals(-365, DateRange.of(startDate, endDate).getDaysInRange());

        endDate = CalendarDate.of(2008, Months.JANUARY, 1);
        endDate = endDate.addDays(-1);

        assertEquals(-1, DateRange.of(startDate, endDate).getDaysInRange());
    }

    @Test
    public void testSetDateRangeWhenStartDateOrEndDateIsNull() {
        try {
            DateRange.of(Calendar.getInstance(), null);
            fail("You should not be able to set a end date that is before the start date.");
        } catch (Exception ex) {
            assertNotNull(ex);
        }
    }

    @Test
    public void testGetDaysInRange() throws InvalidDateException {

        CalendarDate date1 = CalendarDate.of("1/1/2001", "MM/dd/yyyy");
        CalendarDate date2 = CalendarDate.of("1/31/2001", "MM/dd/yyyy");
        DateRange range = DateRange.of(date1, date2);
        assertEquals("30 days in range", 30, range.getDaysInRange());
    }

    @Test
    public void testGetDaysInRangeWhenIncludeStartDateInCount() throws InvalidDateException {

        CalendarDate date1 = CalendarDate.of("1/1/2001", "MM/dd/yyyy");
        CalendarDate date2 = CalendarDate.of("1/31/2001", "MM/dd/yyyy");
        DateRange range = DateRange.of(date1, date2, true);
        assertEquals("31 days in range", 31, range.getDaysInRange());
    }
}
