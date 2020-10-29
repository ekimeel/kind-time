package kind.time.fmt;

import kind.time.cal.CalendarDate;
import kind.time.cal.Months;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class DateFormatsTest {


    @Test
    public void testFomrat_calendar_string() {
        assertEquals("01/02/2009", DateFormats.format(CalendarDate.of(2009, 0, 2), "MM/dd/yyyy"));
        assertEquals("2009-01-02", DateFormats.format(CalendarDate.of(2009, 0, 2), "yyyy-MM-dd"));
        assertEquals("2009", DateFormats.format(CalendarDate.of(2009, 0, 2), "yyyy"));
        assertEquals("01", DateFormats.format(CalendarDate.of(2009, 0, 2), "MM"));
        assertEquals("02", DateFormats.format(CalendarDate.of(2009, 0, 2), "dd"));

    }

    @Test
    public void testFormatStrings() {

        System.out.println(DateFormats.format("12/01/2008", "MM/dd/yyyy", "YYYY/MM/DD hh:mm:ss"));


    }


    @Test
    public void test() {
        //DateFormats.format(CalendarDate.of(2008, Months.APRIL, 15), DateFormats.ISO_DATETIME_FORMAT);
        System.out.println(DateFormats.ISO_DATETIME_FORMAT.format(CalendarDate.of(2008, Months.APRIL, 15).toUtilDate()));

    }

//    @Test
//    public void testFormatISOWeekDate() {
//
//        assertEquals("2009-W01-1",
//                DateFormats.format(CalendarDate.of(2008, Months.DECEMBER, 29),
//                DateFormats.ISO_WEEK_DATE));
//        
////        assertEquals("2009-W53-7",
////                DateFormats.format(CalendarDate.of(2010, Months.JANUARY, 3),
////                DateFormats.ISO_WEEK_DATE));
//    }
//
//    @Test
//    public void testFormatISOYear() {
//
//        assertEquals("2008",
//                DateFormats.format(CalendarDate.of(2008, Months.APRIL, 15),
//                DateFormats.ISO_YEAR));
//
//    }
//
//    @Test
//    public void testFormatISOCalendarDate() {
//        assertEquals("2010-12-25",
//                DateFormats.format(CalendarDate.of(2010, Months.DECEMBER, 25),
//                DateFormats.ISO_CALENDAR_DATE));
//
//    }
}
