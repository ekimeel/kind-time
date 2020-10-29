package kind.time.cal;

import org.junit.Test;

import static org.junit.Assert.*;
import static kind.test.assertions.DateTimeAsserts.*;

/**
 * @author Michael J. Lee
 */
public class DatesTest {

    @Test
    public void testIsDaylightSavings() {
        CalendarDate dst = null;

        dst = CalendarDate.of("4/4/2004", "MM/dd/yyyy"); //<--start of dst
        assertTrue(Dates.US.isDaylightSavings(dst));

        dst = CalendarDate.of("4/5/2004", "MM/dd/yyyy"); //<--non dst start or end
        assertFalse(Dates.US.isDaylightSavings(dst));

        dst = CalendarDate.of("10/31/2004", "MM/dd/yyyy"); //<--end of dst
        assertTrue(Dates.US.isDaylightSavings(dst));
    }

    @Test
    public void testDaylightSavingsStart() {

        assertSimpleDate("4/4/2004", CalendarDate.of(Dates.US.getDaylightSavingsStart(2004)));
        assertSimpleDate("4/3/2005", CalendarDate.of(Dates.US.getDaylightSavingsStart(2005)));
        assertSimpleDate("4/2/2006", CalendarDate.of(Dates.US.getDaylightSavingsStart(2006)));

        assertSimpleDate("3/11/2007", CalendarDate.of(Dates.US.getDaylightSavingsStart(2007)));//<--Change in DST law in 2007
        assertSimpleDate("3/9/2008", CalendarDate.of(Dates.US.getDaylightSavingsStart(2008)));
        assertSimpleDate("3/8/2009", CalendarDate.of(Dates.US.getDaylightSavingsStart(2009)));
        assertSimpleDate("3/14/2010", CalendarDate.of(Dates.US.getDaylightSavingsStart(2010)));

    }

    @Test
    public void testDaylightSavingsEnd() {

        assertSimpleDate("10/31/2004", CalendarDate.of(Dates.US.getDaylightSavingsEnd(2004)));
        assertSimpleDate("10/30/2005", CalendarDate.of(Dates.US.getDaylightSavingsEnd(2005)));
        assertSimpleDate("10/29/2006", CalendarDate.of(Dates.US.getDaylightSavingsEnd(2006)));

        assertSimpleDate("11/4/2007", CalendarDate.of(Dates.US.getDaylightSavingsEnd(2007)));//<--Change in DST law in 2007
        assertSimpleDate("11/2/2008", CalendarDate.of(Dates.US.getDaylightSavingsEnd(2008)));
        assertSimpleDate("11/1/2009", CalendarDate.of(Dates.US.getDaylightSavingsEnd(2009)));
        assertSimpleDate("11/7/2010", CalendarDate.of(Dates.US.getDaylightSavingsEnd(2010)));

    }


}
