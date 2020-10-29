
package kind.time.cal;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael J. Lee @ Synergy Energy Holdings, LLC
 */
public class HolidayTest {

    @Test
    public void testEqualsDate(){
        final String holidayName = "Christmas";
        final Calendar holidayDate = CalendarDate.of(2008, Months.DECEMBER, 25);
        Holiday holiday = new Holiday(holidayName, holidayDate);
        
        CalendarDate dateThatIsEqual = CalendarDate.of(2008, Months.DECEMBER, 25);
        CalendarDate dateThatIsNotEqual = CalendarDate.of(2008, Months.DECEMBER, 27);
        
        
        assertTrue(holiday.equalsDate(dateThatIsEqual));
        assertFalse(holiday.equalsDate(dateThatIsNotEqual));
    }
    
    @Test
    public void testGetName(){
        final String holidayName = "Christmas";
        Holiday holiday = new Holiday(holidayName, null);
        assertEquals(holidayName, holiday.getName());
    }
    
    @Test
    public void testGetDate(){
        final Calendar holidayDate = CalendarDate.of(2008, Months.DECEMBER, 25);
        Holiday holiday = new Holiday(null, holidayDate);
        assertEquals(holidayDate, holiday.getDate());
    }

}
