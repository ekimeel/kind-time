package kind.time.cal;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {

    @Test
    public void testCreateDate_int_int_int() {

        CalendarDate date = BankingCalendarFactory.createDate(2009, Months.FEBRUARY, 2);
        assertNotNull("Should have been a valid date", date);

        assertEquals(2009, date.getYear());
        assertEquals(Months.FEBRUARY, date.getMonth());
        assertEquals(2, date.getDayOfTheMonth());
    }

    @Test
    public void testCreateDate_int_int_int_WithMonthGreaterThanMaxMonth() {
        try {
            BankingCalendarFactory.createDate(2009, BankingCalendarFactory.MAX_MONTH + 3, 2);
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Month should be 0-11"));
        }
    }

    @Test
    public void testCreateDate_int_int_int_WithMonthLessThanMinMonth() {
        try {
            BankingCalendarFactory.createDate(2009, BankingCalendarFactory.MIN_MONTH - 4, 2);
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Month should be 0-11"));
        }
    }

    @Test
    public void testCreateDate_int_int_int_WithYearLessThanMinYear() {
        try {
            BankingCalendarFactory.createDate(BankingCalendarFactory.MIN_YEAR - 3, 5, 2);
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Year should be 1980 <= year =< 9999"));
        }
    }

    @Test
    public void testCreateDate_int_int_int_WithYearGreaterThanMaxYear() {
        try {
            BankingCalendarFactory.createDate(BankingCalendarFactory.MAX_YEAR + 245, 5, 2);
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Year should be 1980 <= year =< 9999"));
        }
    }

    @Test
    public void testCreateDate_int_int_int_WithDayLessThanMinDay() {
        try {
            BankingCalendarFactory.createDate(2009, 1, BankingCalendarFactory.MIN_DAY - 4);
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Day should be in the range 1-31"));
        }
    }

    @Test
    public void testCreateDate_int_int_int_WithDayGreaterThanMaxDay() {
        try {
            BankingCalendarFactory.createDate(2009, 1, BankingCalendarFactory.MAX_DAY + 10);
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Day should be in the range 1-31"));
        }
    }
//    @Test
//    public void testIsHoliday(){
//
//       CalendarDate date =  BankingCalendarFactory.createDate(2009, Months.JULY, 4);
//       assertTrue(date.isHoliday());
//
//    }
}
