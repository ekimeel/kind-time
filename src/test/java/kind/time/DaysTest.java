
package kind.time;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class DaysTest {

    private Days monday;
    private Days tuesday;
    private Days wednesday;
    private Days thursday;
    private Days friday;
    private Days saturday;
    private Days sunday;

    @Before
    public void setup() {
        monday = Days.of(0);
        tuesday = Days.of(1);
        wednesday = Days.of(2);
        thursday = Days.of(3);
        friday = Days.of(4);
        saturday = Days.of(5);
        sunday = Days.of(6);
    }

    @Test
    public void testToMilliseconds() {
        final long millisecondsInADay = 86400000;

        assertEquals(millisecondsInADay, Days.toMilliseconds(1));
        assertEquals(millisecondsInADay * 5, Days.toMilliseconds(5));
        assertEquals(millisecondsInADay * 100, Days.toMilliseconds(100));
    }

    @Test
    public void testAlignedWithJavaCalendar() {

        assertEquals(Calendar.MONDAY, Days.MONDAY.toInt());
        assertEquals(Calendar.TUESDAY, Days.TUESDAY.toInt());
        assertEquals(Calendar.WEDNESDAY, Days.WEDNESDAY.toInt());
        assertEquals(Calendar.THURSDAY, Days.THURSDAY.toInt());
        assertEquals(Calendar.FRIDAY, Days.FRIDAY.toInt());
        assertEquals(Calendar.SATURDAY, Days.SATURDAY.toInt());
        assertEquals(Calendar.SUNDAY, Days.SUNDAY.toInt());
    }


    @Test
    public void testWeekendAndWeekday() {

        assertTrue(monday.isWeekday());
        assertTrue(tuesday.isWeekday());
        assertTrue(wednesday.isWeekday());
        assertTrue(thursday.isWeekday());
        assertTrue(friday.isWeekday());

        assertFalse(saturday.isWeekday());
        assertFalse(sunday.isWeekday());
    }


    @Test
    public void testOfOnShortNamedDays() {
        monday = Days.of("mon");
        tuesday = Days.of("tue");
        wednesday = Days.of("wed");
        thursday = Days.of("thr");
        friday = Days.of("fri");
        saturday = Days.of("sat");
        sunday = Days.of("sun");

        assertEquals(Calendar.MONDAY, monday.toInt());
        assertEquals(Calendar.TUESDAY, tuesday.toInt());
        assertEquals(Calendar.WEDNESDAY, wednesday.toInt());
        assertEquals(Calendar.THURSDAY, thursday.toInt());
        assertEquals(Calendar.FRIDAY, friday.toInt());
        assertEquals(Calendar.SATURDAY, saturday.toInt());
        assertEquals(Calendar.SUNDAY, sunday.toInt());
    }

    @Test
    public void testOfOnLongNamedDays() {
        monday = Days.of("monday");
        tuesday = Days.of("tuesday");
        wednesday = Days.of("wednesday");
        thursday = Days.of("thursday");
        friday = Days.of("friday");
        saturday = Days.of("saturday");
        sunday = Days.of("sunday");

        assertEquals(Calendar.MONDAY, monday.toInt());
        assertEquals(Calendar.TUESDAY, tuesday.toInt());
        assertEquals(Calendar.WEDNESDAY, wednesday.toInt());
        assertEquals(Calendar.THURSDAY, thursday.toInt());
        assertEquals(Calendar.FRIDAY, friday.toInt());
        assertEquals(Calendar.SATURDAY, saturday.toInt());
        assertEquals(Calendar.SUNDAY, sunday.toInt());
    }

    @Test
    public void testOfOnAInvalidDayString() {
        Days car = Days.of("car");
        assertNull(car);
    }

    @Test
    public void testOfOnANullString() {
        Days nullDay = Days.of(null);
        assertNull(nullDay);
    }

    @Test
    public void testOfOnInvalidDayIndex() {

        Days badIndex;

        badIndex = Days.of(-11);
        assertNull(badIndex);

        badIndex = Days.of(110);
        assertNull(badIndex);
    }

    @Test
    public void testMillisInADay() {
        assertTrue(Days.MILLIS_IN_A_DAY == 86400000);
    }

    @Test
    public void testOneDay() {
        assertTrue(Days.ONE.getNumberOfDays() == 1);
        assertTrue(Days.ONE.getTimeInMillis() == 1 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testTwoDays() {
        assertTrue(Days.TWO.getNumberOfDays() == 2);
        assertTrue(Days.TWO.getTimeInMillis() == 2 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testThreeDays() {
        assertTrue(Days.THREE.getNumberOfDays() == 3);
        assertTrue(Days.THREE.getTimeInMillis() == 3 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testFourDays() {
        assertTrue(Days.FOUR.getNumberOfDays() == 4);
        assertTrue(Days.FOUR.getTimeInMillis() == 4 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testFiveDays() {
        assertTrue(Days.FIVE.getNumberOfDays() == 5);
        assertTrue(Days.FIVE.getTimeInMillis() == 5 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testSixDays() {
        assertTrue(Days.SIX.getNumberOfDays() == 6);
        assertTrue(Days.SIX.getTimeInMillis() == 6 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testSevenDays() {
        assertTrue(Days.SEVEN.getNumberOfDays() == 7);
        assertTrue(Days.SEVEN.getTimeInMillis() == 7 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testThirtyDays() {
        assertTrue(Days.THIRTY.getNumberOfDays() == 30);
        assertTrue(Days.THIRTY.getTimeInMillis() == 30 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testSixtyDays() {
        assertTrue(Days.SIXTY.getNumberOfDays() == 60);
        assertTrue(Days.SIXTY.getTimeInMillis() == 60 * Days.MILLIS_IN_A_DAY);
    }

    @Test
    public void testNinetyDays() {
        assertTrue(Days.NINETY.getNumberOfDays() == 90);
        assertTrue(Days.NINETY.getTimeInMillis() == 90 * Days.MILLIS_IN_A_DAY);
    }
}
