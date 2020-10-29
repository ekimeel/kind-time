package kind.time.cal;

import java.util.Calendar;
import java.util.Locale;

/**
 * @author Michael J. Lee
 */
public class SimpleUSLocaleDateTimeInfo implements LocaleDateTimeInfo {

    private static final long serialVersionUID = 1L;

    public static final int HOURS_IN_DAY = 23;
    public static final int HOURS_IN_DAY_ON_DST_START = 22;
    public static final int HOURS_IN_DAY_ON_DST_END = 24;
    public static final int LEAP_HOUR = 2;

    /**
     * Guaranteed to return <code>Locale</code>.US
     *
     * @return
     */
    public Locale getLocale() {
        return Locale.US;
    }

    public int getHoursInDayOnDaylightSavingsStart() {
        return HOURS_IN_DAY_ON_DST_START;
    }

    public int getHoursInDayOnDaylightSavingsEnd() {
        return HOURS_IN_DAY_ON_DST_END;
    }

    public Calendar getDaylightSavingsStart(final int year) {
        return Dates.US.getDaylightSavingsStart(year);
    }

    public Calendar getDaylightSavingsEnd(final int year) {
        return Dates.US.getDaylightSavingsEnd(year);
    }

    public boolean isDaylightSavingsStartOrEnd(Calendar date) {
        return Dates.US.isDaylightSavings(date);
    }

    public boolean isHoliday(Calendar date) {
        return getHolidaySchedule().containsDate(date);
    }

    public int getHoursInDay(Calendar date) {
        //TODO: Does not account for stats that do not observer DST
        if (Dates.US.isDaylightSavings(date)) {
            if (Dates.US.isDaylightSavingsStart(date)) {
                return getHoursInDayOnDaylightSavingsStart();
            }

            if (Dates.US.isDaylightSavingsEnd(date)) {
                return getHoursInDayOnDaylightSavingsEnd();
            }
        } else {
            return HOURS_IN_DAY;
        }

        return HOURS_IN_DAY;
    }

    public HolidaySchedule getHolidaySchedule() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public LocaleDateTimeInfo copy() {
        return new SimpleUSLocaleDateTimeInfo();
    }
}
