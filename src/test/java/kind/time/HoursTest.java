
package kind.time;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael J. Lee
 */
public class HoursTest {

    @Test
    public void testToMilliseconds(){
        final long millisecondsInAHour = 3600000;
        
        assertEquals(millisecondsInAHour, Hours.toMilliseconds(1));
        assertEquals(millisecondsInAHour * 5, Hours.toMilliseconds(5));
        assertEquals(millisecondsInAHour * 100, Hours.toMilliseconds(100));
    }
    
    
    @Test
    public void testToSeconds(){
        final long secondsInAHour = 3600;
        
        assertEquals(secondsInAHour, Hours.toSeconds(1));
        assertEquals(secondsInAHour * 5, Hours.toSeconds(5));
        assertEquals(secondsInAHour * 100, Hours.toSeconds(100));
    }

    @Test
    public void testToMinutes(){
        final long minutesInAHour = 60;
        
        assertEquals(minutesInAHour, Hours.toMinutes(1));
        assertEquals(minutesInAHour * 5, Hours.toMinutes(5));
        assertEquals(minutesInAHour * 100, Hours.toMinutes(100));
    }
}
