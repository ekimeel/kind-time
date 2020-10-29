
package kind.time.cal;


import java.util.Calendar;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class DayTest {
    private DayOfWeek monday;
    private DayOfWeek tuesday;
    private DayOfWeek wednesday;
    private DayOfWeek thursday;
    private DayOfWeek friday;
    private DayOfWeek saturday;
    private DayOfWeek sunday;

    @Before
    public void setup() {
        monday = DayOfWeek.of(0);
        tuesday = DayOfWeek.of(1);
        wednesday = DayOfWeek.of(2);
        thursday = DayOfWeek.of(3);
        friday = DayOfWeek.of(4);
        saturday = DayOfWeek.of(5);
        sunday = DayOfWeek.of(6);
    }

    @Test
    public void testOfAIntIsAlignedWithJavaCalendar() {
        assertEquals(Calendar.MONDAY, monday.getValue());
        assertEquals(Calendar.TUESDAY, tuesday.getValue());
        assertEquals(Calendar.WEDNESDAY, wednesday.getValue());
        assertEquals(Calendar.THURSDAY, thursday.getValue());
        assertEquals(Calendar.FRIDAY, friday.getValue());
        assertEquals(Calendar.SATURDAY, saturday.getValue());
        assertEquals(Calendar.SUNDAY, sunday.getValue());
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
        monday = DayOfWeek.of("mon");
        tuesday = DayOfWeek.of("tue");
        wednesday = DayOfWeek.of("wed");
        thursday = DayOfWeek.of("thr");
        friday = DayOfWeek.of("fri");
        saturday = DayOfWeek.of("sat");
        sunday = DayOfWeek.of("sun");

        assertEquals(Calendar.MONDAY, monday.getValue());
        assertEquals(Calendar.TUESDAY, tuesday.getValue());
        assertEquals(Calendar.WEDNESDAY, wednesday.getValue());
        assertEquals(Calendar.THURSDAY, thursday.getValue());
        assertEquals(Calendar.FRIDAY, friday.getValue());
        assertEquals(Calendar.SATURDAY, saturday.getValue());
        assertEquals(Calendar.SUNDAY, sunday.getValue());
    }

    @Test
    public void testOfOnLongNamedDays() {
        monday = DayOfWeek.of("monday");
        tuesday = DayOfWeek.of("tuesday");
        wednesday = DayOfWeek.of("wednesday");
        thursday = DayOfWeek.of("thursday");
        friday = DayOfWeek.of("friday");
        saturday = DayOfWeek.of("saturday");
        sunday = DayOfWeek.of("sunday");

        assertEquals(Calendar.MONDAY, monday.getValue());
        assertEquals(Calendar.TUESDAY, tuesday.getValue());
        assertEquals(Calendar.WEDNESDAY, wednesday.getValue());
        assertEquals(Calendar.THURSDAY, thursday.getValue());
        assertEquals(Calendar.FRIDAY, friday.getValue());
        assertEquals(Calendar.SATURDAY, saturday.getValue());
        assertEquals(Calendar.SUNDAY, sunday.getValue());
    }

    @Test
    public void testOfOnAInvalidDayString() {
        DayOfWeek car = DayOfWeek.of("car");
        assertNull(car);
    }

    @Test
    public void testOfOnANullString() {
        DayOfWeek nullDay = DayOfWeek.of(null);
        assertNull(nullDay);
    }

    @Test
    public void testOfOnInvalidDayIndex() {

        DayOfWeek badIndex;

        badIndex = DayOfWeek.of(-11);
        assertNull(badIndex);

        badIndex = DayOfWeek.of(110);
        assertNull(badIndex);
    }
}
