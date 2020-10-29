
package kind.time.cal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class CalendarDatesTest {

    @Test
    public void testAreEqualDates() {

        assertTrue(
                CalendarDates.areEqualDates(CalendarDate.of(1982, Months.APRIL, 26), CalendarDate.of(1982, Months.APRIL, 26))
        );

        assertTrue(
                CalendarDates.areEqualDates(CalendarDate.of(2020, Months.SEPTEMBER, 8), CalendarDate.of(2020, Months.SEPTEMBER, 8))
        );
    }

    @Test
    public void testAreEqualDatesWhenNot() {

        assertFalse(
                CalendarDates.areEqualDates(CalendarDate.of(1982, Months.APRIL, 27), CalendarDate.of(1982, Months.APRIL, 26))
        );

        assertFalse(
                CalendarDates.areEqualDates(CalendarDate.of(2021, Months.SEPTEMBER, 8), CalendarDate.of(2020, Months.SEPTEMBER, 8))
        );
    }

    @Test
    public void testAreEqualDatesWhenGivenNull() {

        assertFalse(
                CalendarDates.areEqualDates(null, CalendarDate.of(1982, Months.APRIL, 26))
        );

        assertFalse(
                CalendarDates.areEqualDates(CalendarDate.of(2020, Months.SEPTEMBER, 8), null)
        );

        assertFalse(
                CalendarDates.areEqualDates(null, null)
        );
    }

}
