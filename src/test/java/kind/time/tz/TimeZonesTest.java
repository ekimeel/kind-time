/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kind.time.tz;

import kind.time.cal.CalendarDate;
import kind.time.cal.CalendarYear;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael J. Lee
 */
public class TimeZonesTest {

    @Test
    public void test() {
        CalendarYear year = CalendarYear.of(2009);
        CalendarDate[] dates = year.getAllDates();
        for (CalendarDate date : dates) {

        }

    }

    @Test
    public void testAtlanticTimeZone() {
        assertEquals("Atlantic Standard Time", TimeZones.ATLANTIC_STANDARD.getDisplayName());
        assertFalse(TimeZones.ATLANTIC_STANDARD.useDaylightTime());
    }

    @Test
    public void testAtlanticDaylightSavingsTimeZone() {
        assertEquals("Atlantic Standard Time", TimeZones.ATLANTIC_STANDARD_DAYLIGHT_SAVINGS.getDisplayName());
        assertTrue(TimeZones.ATLANTIC_STANDARD_DAYLIGHT_SAVINGS.useDaylightTime());
    }

    @Test
    public void testAlaskaTimeZone() {
        assertEquals("Alaska Standard Time", TimeZones.ALASKA_STANDARD.getDisplayName());
    }

    @Test
    public void testCentralDaylightSavingsTimeZone() {
        assertEquals("Central Standard Time", TimeZones.CENTRAL_STANDARD_DAYLIGHT_SAVINGS.getDisplayName());
        assertTrue(TimeZones.CENTRAL_STANDARD_DAYLIGHT_SAVINGS.useDaylightTime());
    }

    @Test
    public void testEasternTimeZone() {
        assertEquals("Eastern Standard Time", TimeZones.EASTERN_STANDARD.getDisplayName());
        assertFalse(TimeZones.EASTERN_STANDARD.useDaylightTime());
    }

    @Test
    public void testEasternDayLightSavingsTimeZone() {
        assertEquals("Eastern Standard Time", TimeZones.EASTERN_STANDARD_DAYLIGHT_SAVINGS.getDisplayName());
        assertTrue(TimeZones.EASTERN_STANDARD_DAYLIGHT_SAVINGS.useDaylightTime());
    }

    @Test
    public void testHawaiiTimeZone() {
        assertEquals("Hawaii Standard Time", TimeZones.HAWAII_STANDARD.getDisplayName());
    }

    @Test
    public void testMountainTimeZone() {
        assertEquals("Mountain Standard Time", TimeZones.MOUNTAIN_STANDARD.getDisplayName());
        assertFalse(TimeZones.MOUNTAIN_STANDARD.useDaylightTime());
    }

    @Test
    public void testMountainDayLightSavingsTimeZone() {
        assertEquals("Mountain Standard Time", TimeZones.MOUNTAIN_STANDARD_DAYLIGHT_SAVINGS.getDisplayName());
        assertTrue(TimeZones.MOUNTAIN_STANDARD_DAYLIGHT_SAVINGS.useDaylightTime());
    }

    @Test
    public void testPacificTimeZone() {
        assertEquals("Pacific Standard Time", TimeZones.PACIFIC_STANDARD_DAYLIGHT_SAVINGS.getDisplayName());
        assertTrue(TimeZones.PACIFIC_STANDARD_DAYLIGHT_SAVINGS.useDaylightTime());

    }
}
