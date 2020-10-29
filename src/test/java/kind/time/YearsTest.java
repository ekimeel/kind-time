package kind.time;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class YearsTest {

    @Test
    public void testWeeksInAYear() {
        assertEquals(52, Years.WEEKS_IN_YEAR);
    }

    @Test
    public void testMonthsInYear() {
        assertEquals(12, Years.MONTHS_IN_YEAR);
    }


}
