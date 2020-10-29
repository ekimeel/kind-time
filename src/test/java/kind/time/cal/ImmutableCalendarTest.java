package kind.time.cal;


import java.util.Calendar;

import org.junit.Test;

/**
 * @author Michael J. Lee
 */
public class ImmutableCalendarTest {


    @Test
    public void testIm() {
        Calendar calendar = CalendarDate.of(2008, Months.JANUARY, 0);
    }

}
