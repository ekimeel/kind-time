
package kind.time.cal;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael J. Lee @ Synergy Energy Holdings, LLC
 */
public class HolidayScheduleTest {

    public HolidayScheduleTest() {
    }


    @Test
    public void testNewEmptyHolidaySchedule(){
        //TODO: Test for zero lenght in returned instance
        assertNotNull(HolidaySchedule.newEmptyHolidaySchedule());
    }
    
    @Test
    public void testContainsDate()
    {
        Holiday[] holidays = new Holiday[5];
        
        holidays[0] = new Holiday("New Years Day 2007",CalendarDate.of(2007, 0, 1)); //<--Holiday is out of range of 2008
        holidays[1] = new Holiday("New Years Day 2008", CalendarDate.of(2008, 0, 1));
        holidays[2] = new Holiday("Easter 2008", CalendarDate.of(2008, 2, 23));
        holidays[3] = new Holiday("Christmas Day 2008", CalendarDate.of(2008, 11, 25));
        holidays[4] = new Holiday("New Years Day 2009", CalendarDate.of(2009, 0, 1)); //<--Holiday is out of range of 2008
        
        HolidaySchedule holidaySchedule = HolidaySchedule.of(holidays);
        
        Calendar easter = CalendarDate.of(2008, 2, 23);
        assertTrue("Holiday not found",holidaySchedule.containsDate(easter));
        
        
    }

}
