package kind.time.cal;

import org.junit.Test;
import static org.junit.Assert.*;
import static kind.test.assertions.DateTimeAsserts.*;

/**
 *
 * @author Michael J. Lee @ Synergy Energy Holdings, LLC
 */
public class HolidaysTest
{

    public HolidaysTest() {
    }
        @Test
    public void testThanksgivingDayObserved() {
        assertEquals(CalendarDate.of("11/23/2006", "MM/dd/yyyy"), Holidays.ThanksgivingDayObserved(2006));
        assertEquals(CalendarDate.of("11/22/2007", "MM/dd/yyyy"), Holidays.ThanksgivingDayObserved(2007));
        assertEquals(CalendarDate.of("11/27/2008", "MM/dd/yyyy"), Holidays.ThanksgivingDayObserved(2008));
        assertEquals(CalendarDate.of("11/26/2009", "MM/dd/yyyy"), Holidays.ThanksgivingDayObserved(2009));
        assertEquals(CalendarDate.of("11/25/2010", "MM/dd/yyyy"), Holidays.ThanksgivingDayObserved(2010));
        assertEquals(CalendarDate.of("11/24/2011", "MM/dd/yyyy"), Holidays.ThanksgivingDayObserved(2011));
        assertEquals(CalendarDate.of("11/22/2012", "MM/dd/yyyy"), Holidays.ThanksgivingDayObserved(2012));
    }
    @Test
    public void testVeteransDayObserved() {
        assertEquals(CalendarDate.of("11/10/2006", "MM/dd/yyyy"), Holidays.VeteransDayObserved(2006));
        assertEquals(CalendarDate.of("11/12/2007", "MM/dd/yyyy"), Holidays.VeteransDayObserved(2007));
        assertEquals(CalendarDate.of("11/11/2008", "MM/dd/yyyy"), Holidays.VeteransDayObserved(2008));
        assertEquals(CalendarDate.of("11/11/2009", "MM/dd/yyyy"), Holidays.VeteransDayObserved(2009));
        assertEquals(CalendarDate.of("11/11/2010", "MM/dd/yyyy"), Holidays.VeteransDayObserved(2010));
        assertEquals(CalendarDate.of("11/11/2011", "MM/dd/yyyy"), Holidays.VeteransDayObserved(2011));
        assertEquals(CalendarDate.of("11/12/2012", "MM/dd/yyyy"), Holidays.VeteransDayObserved(2012));
    }
    @Test
    public void testElectionDay() {
        assertEquals(CalendarDate.of("11/7/2006", "MM/dd/yyyy"), Holidays.ElectionDay(2006));
        assertEquals(CalendarDate.of("11/6/2007", "MM/dd/yyyy"), Holidays.ElectionDay(2007));
        assertEquals(CalendarDate.of("11/4/2008", "MM/dd/yyyy"), Holidays.ElectionDay(2008));
        assertEquals(CalendarDate.of("11/3/2009", "MM/dd/yyyy"), Holidays.ElectionDay(2009));
        assertEquals(CalendarDate.of("11/2/2010", "MM/dd/yyyy"), Holidays.ElectionDay(2010));
        assertEquals(CalendarDate.of("11/1/2011", "MM/dd/yyyy"), Holidays.ElectionDay(2011));
        assertEquals(CalendarDate.of("11/6/2012", "MM/dd/yyyy"), Holidays.ElectionDay(2012));
    }

    @Test
    public void testColumbusDayObserved() {
        assertEquals(CalendarDate.of("10/9/2006", "MM/dd/yyyy"), Holidays.ColumbusDayObserved(2006));
        assertEquals(CalendarDate.of("10/8/2007", "MM/dd/yyyy"), Holidays.ColumbusDayObserved(2007));
        assertEquals(CalendarDate.of("10/13/2008", "MM/dd/yyyy"), Holidays.ColumbusDayObserved(2008));
        assertEquals(CalendarDate.of("10/12/2009", "MM/dd/yyyy"), Holidays.ColumbusDayObserved(2009));
        assertEquals(CalendarDate.of("10/11/2010", "MM/dd/yyyy"), Holidays.ColumbusDayObserved(2010));
        assertEquals(CalendarDate.of("10/10/2011", "MM/dd/yyyy"), Holidays.ColumbusDayObserved(2011));
    }

    @Test
    public void testChristmasDayObserved() {
        assertEquals(CalendarDate.of("12/25/2006", "MM/dd/yyyy"), Holidays.ChristmasDayObserved(2006));
        assertEquals(CalendarDate.of("12/25/2007", "MM/dd/yyyy"), Holidays.ChristmasDayObserved(2007));
        assertEquals(CalendarDate.of("12/25/2008", "MM/dd/yyyy"), Holidays.ChristmasDayObserved(2008));
        assertEquals(CalendarDate.of("12/25/2009", "MM/dd/yyyy"), Holidays.ChristmasDayObserved(2009));
        assertEquals(CalendarDate.of("12/24/2010", "MM/dd/yyyy"), Holidays.ChristmasDayObserved(2010));
        assertEquals(CalendarDate.of("12/26/2011", "MM/dd/yyyy"), Holidays.ChristmasDayObserved(2011));
    }

    @Test
    public void testLaborDayObserved() {
        assertEquals(CalendarDate.of("9/4/2006", "MM/dd/yyyy"), Holidays.LaborDayObserved(2006));
        assertEquals(CalendarDate.of("9/3/2007", "MM/dd/yyyy"), Holidays.LaborDayObserved(2007));
        assertEquals(CalendarDate.of("9/1/2008", "MM/dd/yyyy"), Holidays.LaborDayObserved(2008));
        assertEquals(CalendarDate.of("9/7/2009", "MM/dd/yyyy"), Holidays.LaborDayObserved(2009));
        assertEquals(CalendarDate.of("9/6/2010", "MM/dd/yyyy"), Holidays.LaborDayObserved(2010));
        assertEquals(CalendarDate.of("9/5/2011", "MM/dd/yyyy"), Holidays.LaborDayObserved(2011));
    }

    @Test
    public void testIndependenceDayObserved() {
        assertEquals(CalendarDate.of("7/4/2006", "MM/dd/yyyy"), Holidays.IndependenceDayObserved(2006));
        assertEquals(CalendarDate.of("7/4/2007", "MM/dd/yyyy"), Holidays.IndependenceDayObserved(2007));
        assertEquals(CalendarDate.of("7/4/2008", "MM/dd/yyyy"), Holidays.IndependenceDayObserved(2008));
        assertEquals(CalendarDate.of("7/3/2009", "MM/dd/yyyy"), Holidays.IndependenceDayObserved(2009));
        assertEquals(CalendarDate.of("7/5/2010", "MM/dd/yyyy"), Holidays.IndependenceDayObserved(2010));
        assertEquals(CalendarDate.of("7/4/2011", "MM/dd/yyyy"), Holidays.IndependenceDayObserved(2011));
    }

    @Test
    public void testMemorialDayObserved() {
        assertEquals(CalendarDate.of("5/29/2006", "MM/dd/yyyy"), Holidays.MemorialDayObserved(2006));
        assertEquals(CalendarDate.of("5/28/2007", "MM/dd/yyyy"), Holidays.MemorialDayObserved(2007));
        assertEquals(CalendarDate.of("5/26/2008", "MM/dd/yyyy"), Holidays.MemorialDayObserved(2008));
        assertEquals(CalendarDate.of("5/25/2009", "MM/dd/yyyy"), Holidays.MemorialDayObserved(2009));
    }

    @Test
    public void testPresidentsDayObserved() {
        assertEquals(CalendarDate.of("2/20/2006", "MM/dd/yyyy"), Holidays.PresidentsDayObserved(2006));
        assertEquals(CalendarDate.of("2/19/2007", "MM/dd/yyyy"), Holidays.PresidentsDayObserved(2007));
        assertEquals(CalendarDate.of("2/18/2008", "MM/dd/yyyy"), Holidays.PresidentsDayObserved(2008));
        assertEquals(CalendarDate.of("2/16/2009", "MM/dd/yyyy"), Holidays.PresidentsDayObserved(2009));
    }

    @Test
    public void testMartinLutherKingDayObserved() {
        assertEquals(CalendarDate.of("1/20/1986", "MM/dd/yyyy"), Holidays.MartinLutherKingObserved(1986));
        assertEquals(CalendarDate.of("1/15/2007", "MM/dd/yyyy"), Holidays.MartinLutherKingObserved(2007));
        assertEquals(CalendarDate.of("1/21/2008", "MM/dd/yyyy"), Holidays.MartinLutherKingObserved(2008));
        assertEquals(CalendarDate.of("1/19/2009", "MM/dd/yyyy"), Holidays.MartinLutherKingObserved(2009));
    }

    @Test
    public void testNewYeasDay() {
        assertEquals(CalendarDate.of("1/1/2000", "MM/dd/yyyy"), Holidays.NewYearsDay(2000));
        assertEquals(CalendarDate.of("1/1/2001", "MM/dd/yyyy"), Holidays.NewYearsDay(2001));
        assertEquals(CalendarDate.of("1/1/2002", "MM/dd/yyyy"), Holidays.NewYearsDay(2002));
        assertEquals(CalendarDate.of("1/1/2003", "MM/dd/yyyy"), Holidays.NewYearsDay(2003));
        assertEquals(CalendarDate.of("1/1/2004", "MM/dd/yyyy"), Holidays.NewYearsDay(2004));
        assertEquals(CalendarDate.of("1/1/2005", "MM/dd/yyyy"), Holidays.NewYearsDay(2005));
        assertEquals(CalendarDate.of("1/1/2006", "MM/dd/yyyy"), Holidays.NewYearsDay(2006));
        assertEquals(CalendarDate.of("1/1/2007", "MM/dd/yyyy"), Holidays.NewYearsDay(2007));
        assertEquals(CalendarDate.of("1/1/2008", "MM/dd/yyyy"), Holidays.NewYearsDay(2008));
        assertEquals(CalendarDate.of("1/1/2009", "MM/dd/yyyy"), Holidays.NewYearsDay(2009));
        assertEquals(CalendarDate.of("1/1/2010", "MM/dd/yyyy"), Holidays.NewYearsDay(2010));
    }

    @Test
    public void testNewYearsDayObservedWhenHolidayFallsOnAWeekday() {

        assertEquals(CalendarDate.of("1/1/2007", "MM/dd/yyyy"), Holidays.NewYearsDayObserved(2007));
        assertIsMonday(Holidays.NewYearsDayObserved(2007));

        assertEquals(CalendarDate.of("1/1/2008", "MM/dd/yyyy"), Holidays.NewYearsDayObserved(2008));
        assertIsTuesday(Holidays.NewYearsDayObserved(2008));

        assertEquals(CalendarDate.of("1/1/2003", "MM/dd/yyyy"), Holidays.NewYearsDayObserved(2003));
        assertIsWednesday(Holidays.NewYearsDayObserved(2003));

        assertEquals(CalendarDate.of("1/1/2009", "MM/dd/yyyy"), Holidays.NewYearsDayObserved(2009));
        assertIsThursday(Holidays.NewYearsDayObserved(2009));

        assertEquals(CalendarDate.of("1/1/2010", "MM/dd/yyyy"), Holidays.NewYearsDayObserved(2010));
        assertIsFriday(Holidays.NewYearsDayObserved(2010));
    }

    @Test
    public void testNewYearsDayObservedWhenHolidayFalssOnAWeekend() {
        assertEquals(CalendarDate.of("12/31/2010", "MM/dd/yyyy"), Holidays.NewYearsDayObserved(2011));
        assertIsFriday(Holidays.NewYearsDayObserved(2011));

        assertEquals(CalendarDate.of("1/2/2006", "MM/dd/yyyy"), Holidays.NewYearsDayObserved(2006));
        assertIsMonday(Holidays.NewYearsDayObserved(2006));
    }
}
