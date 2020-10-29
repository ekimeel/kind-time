package kind.time.cal;

import java.util.Locale;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class SimpleUSLocaleDateTimeInfoTest {

    @Test
    public void testGetLocale() {
        LocaleDateTimeInfo us = new SimpleUSLocaleDateTimeInfo();
        assertEquals(Locale.US, us.getLocale());
    }

    @Test
    public void testGetHoursInDayOnANonDST() {
        LocaleDateTimeInfo us = new SimpleUSLocaleDateTimeInfo();
        assertEquals(23, us.getHoursInDay(CalendarDate.of(2008, Months.JANUARY, 1)));
    }

    @Test
    public void testGetHoursInDayOnADSTStart() {
        LocaleDateTimeInfo us = new SimpleUSLocaleDateTimeInfo();
        assertEquals(22, us.getHoursInDay(us.getDaylightSavingsStart(2008)));
    }

    @Test
    public void testGetHoursInDayOnADSTEnd() {
        LocaleDateTimeInfo us = new SimpleUSLocaleDateTimeInfo();
        assertEquals(24, us.getHoursInDay(us.getDaylightSavingsEnd(2008)));
    }
}
