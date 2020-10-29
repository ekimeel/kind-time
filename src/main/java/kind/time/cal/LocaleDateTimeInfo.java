package kind.time.cal;

import kind.support.Copyable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

/**
 * Interface the represents the local specific rules for date and times.
 */
public interface LocaleDateTimeInfo extends Copyable<LocaleDateTimeInfo>, Serializable {

    //TODO: JavaDoc this interface.
    Locale getLocale();

    int getHoursInDayOnDaylightSavingsStart();

    int getHoursInDayOnDaylightSavingsEnd();

    Calendar getDaylightSavingsStart(final int year);

    Calendar getDaylightSavingsEnd(final int year);

    boolean isDaylightSavingsStartOrEnd(Calendar date);

    boolean isHoliday(Calendar date);

    int getHoursInDay(Calendar date);

    HolidaySchedule getHolidaySchedule();


}
