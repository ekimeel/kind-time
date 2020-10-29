
package kind.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import kind.time.cal.CalendarDate;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class TimeTest {

    @Test
    public void testNowWithPattern() {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String now = format.format(GregorianCalendar.getInstance().getTimeInMillis());

        assertEquals(now, Time.now("MM/dd/yyyy"));
    }

    @Test
    public void testNow() {
        final long timeDiff = GregorianCalendar.getInstance().getTimeInMillis() - Time.now();
        assertTrue(timeDiff < Minutes.ONE.getTimeInMillis()); //<--tolerance of one minute for cpu
    }

    @Test
    public void testCurrentYear() {
        final int currentYear = GregorianCalendar.getInstance().get(Calendar.YEAR);
        assertEquals(currentYear, Time.currentYear());
    }

    @Test
    public void testCurrentMonth() {
        final int currentMonth = GregorianCalendar.getInstance().get(Calendar.MONTH);
        assertEquals(currentMonth, Time.currentMonth());
    }

    @Test
    public void testCurrentDayOfMonth() {
        final int currentDayOfMonth = GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH);
        assertEquals(currentDayOfMonth, Time.currentDayOfMonth());
    }

    @Test
    public void testCurrentDate() {
        final Calendar currentDate = GregorianCalendar.getInstance();
        assertTrue(CalendarDate.areEqualDates(currentDate, Time.currentDate()));

    }

}
