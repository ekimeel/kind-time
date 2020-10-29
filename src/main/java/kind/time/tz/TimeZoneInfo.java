package kind.time.tz;

import java.util.Calendar;
import java.util.TimeZone;

public interface TimeZoneInfo 
{
    //TODO: JavaDoc this interface.
    TimeZone getTimeZone();
    int getHoursInDayOnDaylightSavingsStart();
    int getHoursInDayOnDaylightSavingsEnd();
    Calendar getDaylightSavingsStart(final int year);
    Calendar getDaylightSavingsEnd(final int year);
    int getHoursInDay(Calendar date);
}
