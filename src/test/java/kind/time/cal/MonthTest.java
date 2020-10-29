package kind.time.cal;

import java.util.Calendar;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class MonthTest {

    public MonthTest() {
    }

    @Test
    public void testOfAIntIsAlignedWithJavaCalendar() {

        Month jan = Month.of(0);
        Month feb = Month.of(1);
        Month march = Month.of(2);
        Month april = Month.of(3);
        Month may = Month.of(4);
        Month jun = Month.of(5);
        Month jul = Month.of(6);
        Month aug = Month.of(7);
        Month sep = Month.of(8);
        Month oct = Month.of(9);
        Month nov = Month.of(10);
        Month dec = Month.of(11);

        assertEquals(Calendar.JANUARY, jan.getValue());
        assertEquals(Calendar.FEBRUARY, feb.getValue());
        assertEquals(Calendar.MARCH, march.getValue());
        assertEquals(Calendar.APRIL, april.getValue());
        assertEquals(Calendar.MAY, may.getValue());
        assertEquals(Calendar.JUNE, jun.getValue());
        assertEquals(Calendar.JULY, jul.getValue());
        assertEquals(Calendar.AUGUST, aug.getValue());
        assertEquals(Calendar.SEPTEMBER, sep.getValue());
        assertEquals(Calendar.OCTOBER, oct.getValue());
        assertEquals(Calendar.NOVEMBER, nov.getValue());
        assertEquals(Calendar.DECEMBER, dec.getValue());

    }

    @Test
    public void testOfOnShortNamedMonths() {

        Month jan = Month.of("jan");
        Month feb = Month.of("feB");    //<-- Case is ignored
        Month march = Month.of("mAr");  //<-- Case is ignored
        Month april = Month.of("APR");  //<-- Case is ignored
        Month may = Month.of("may");
        Month jun = Month.of("jun");
        Month jul = Month.of("jUl");    //<-- Case is ignored
        Month aug = Month.of("aug");
        Month sep = Month.of("Sep");    //<-- Case is ignored
        Month oct = Month.of("oct");
        Month nov = Month.of("nov");
        Month dec = Month.of("DEC");    //<-- Case is ignored

        assertEquals(Calendar.JANUARY, jan.getValue());
        assertEquals(Calendar.FEBRUARY, feb.getValue());
        assertEquals(Calendar.MARCH, march.getValue());
        assertEquals(Calendar.APRIL, april.getValue());
        assertEquals(Calendar.MAY, may.getValue());
        assertEquals(Calendar.JUNE, jun.getValue());
        assertEquals(Calendar.JULY, jul.getValue());
        assertEquals(Calendar.AUGUST, aug.getValue());
        assertEquals(Calendar.SEPTEMBER, sep.getValue());
        assertEquals(Calendar.OCTOBER, oct.getValue());
        assertEquals(Calendar.NOVEMBER, nov.getValue());
        assertEquals(Calendar.DECEMBER, dec.getValue());

    }

    @Test
    public void testOfOnLongNamedMonths() {

        Month jan = Month.of("january");
        Month feb = Month.of("feBruary");    //<-- Case is ignored
        Month march = Month.of("mArch");  //<-- Case is ignored
        Month april = Month.of("APril");  //<-- Case is ignored
        Month may = Month.of("may");
        Month jun = Month.of("june");
        Month jul = Month.of("jUly");    //<-- Case is ignored
        Month aug = Month.of("august");
        Month sep = Month.of("September");    //<-- Case is ignored
        Month oct = Month.of("october");
        Month nov = Month.of("november");
        Month dec = Month.of("DECember");    //<-- Case is ignored

        assertEquals(Calendar.JANUARY, jan.getValue());
        assertEquals(Calendar.FEBRUARY, feb.getValue());
        assertEquals(Calendar.MARCH, march.getValue());
        assertEquals(Calendar.APRIL, april.getValue());
        assertEquals(Calendar.MAY, may.getValue());
        assertEquals(Calendar.JUNE, jun.getValue());
        assertEquals(Calendar.JULY, jul.getValue());
        assertEquals(Calendar.AUGUST, aug.getValue());
        assertEquals(Calendar.SEPTEMBER, sep.getValue());
        assertEquals(Calendar.OCTOBER, oct.getValue());
        assertEquals(Calendar.NOVEMBER, nov.getValue());
        assertEquals(Calendar.DECEMBER, dec.getValue());

    }

    @Test
    public void testOfOnAInvalidMonthString() {
        Month car = Month.of("car");
        assertNull(car);
    }

    @Test
    public void testOfOnANullString() {
        Month nullMonth = Month.of(null);
        assertNull(nullMonth);
    }

    @Test
    public void testOfOnInvalidMonthIndex() {

        Month badIndex;

        badIndex = Month.of(-11);
        assertNull(badIndex);

        badIndex = Month.of(110);
        assertNull(badIndex);
    }


}
