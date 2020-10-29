package kind.time.fmt;

import kind.time.tz.TimeZones;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * YYYY = four-digit year
 * MM = two-digit month (01=January, etc.)
 * DD = two-digit day of month (01 through 31)
 * hh = two digits of hour (00 through 23) (am/pm NOT allowed)
 * mm = two digits of minute (00 through 59)
 * ss = two digits of second (00 through 59)
 * s = one or more digits representing a decimal fraction of a second
 * TZD = time zone designator (Z or +hh:mm or -hh:mm)
 */
public class DateFormats {


    /**
     * ISO8601 formatter for date-time without time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ss</tt>.
     */
    public static final DateFormat ISO_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * ISO8601 formatter for date-time with time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ssZZ</tt>.
     */
    public static final DateFormat ISO_DATETIME_TIME_ZONE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");

    /**
     * ISO8601 formatter for date without time zone.
     * The format used is <tt>yyyy-MM-dd</tt>.
     */
    public static final DateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * ISO8601-like formatter for date with time zone.
     * The format used is <tt>yyyy-MM-ddZZ</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard does not allow a time zone  without a time.
     */
    public static final DateFormat ISO_DATE_TIME_ZONE_FORMAT = new SimpleDateFormat("yyyy-MM-ddZZ");

    /**
     * ISO8601 formatter for time without time zone.
     * The format used is <tt>'T'HH:mm:ss</tt>.
     */
    public static final DateFormat ISO_TIME_FORMAT = new SimpleDateFormat("'T'HH:mm:ss");

    /**
     * ISO8601 formatter for time with time zone.
     * The format used is <tt>'T'HH:mm:ssZZ</tt>.
     */
    public static final DateFormat ISO_TIME_TIME_ZONE_FORMAT = new SimpleDateFormat("'T'HH:mm:ssZZ");

    /**
     * ISO8601-like formatter for time without time zone.
     * The format used is <tt>HH:mm:ss</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard requires the 'T' prefix for times.
     */
    public static final DateFormat ISO_TIME_NO_T_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * ISO8601-like formatter for time with time zone.
     * The format used is <tt>HH:mm:ssZZ</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard requires the 'T' prefix for times.
     */
    public static final DateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT = new SimpleDateFormat("HH:mm:ssZZ");

    /**
     * SMTP (and probably other) date headers.
     * The format used is <tt>EEE, dd MMM yyyy HH:mm:ss Z</tt> in US locale.
     */
    public static final DateFormat SMTP_DATETIME_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    //-----------------------------------------------------------------------

    /**
     * <p>DateFormatUtils instances should NOT be constructed in standard programming.</p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean instance
     * to operate.</p>
     */
    public DateFormats() {
        super();
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date
     * @return the formatted date
     */
    public static String formatUTC(long millis, String pattern) {
        return format(new Date(millis), pattern, TimeZones.UTC_TIME_ZONE, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param date    the date to format
     * @param pattern the pattern to use to format the date
     * @return the formatted date
     */
    public static String formatUTC(Date date, String pattern) {
        return format(date, pattern, TimeZones.UTC_TIME_ZONE, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String formatUTC(long millis, String pattern, Locale locale) {
        return format(new Date(millis), pattern, TimeZones.UTC_TIME_ZONE, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param date    the date to format
     * @param pattern the pattern to use to format the date
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String formatUTC(Date date, String pattern, Locale locale) {
        return format(date, pattern, TimeZones.UTC_TIME_ZONE, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date
     * @return the formatted date
     */
    public static String format(long millis, String pattern) {
        return format(new Date(millis), pattern, null, null);
    }

    public static String format(String date, String inputPattern, String outputPattern) {
        return null;
    }

    /**
     * <p>Formats a date/time into a specific pattern.</p>
     *
     * @param date    the date to format
     * @param pattern the pattern to use to format the date
     * @return the formatted date
     */
    public static String format(Date date, String pattern) {
        return format(date, pattern, null, null);
    }

    /**
     * <p>Formats a calendar into a specific pattern.</p>
     *
     * @param calendar the calendar to format
     * @param pattern  the pattern to use to format the calendar
     * @return the formatted calendar
     */
    public static String format(Calendar calendar, String pattern) {
        return format(calendar, pattern, TimeZone.getDefault(), Locale.getDefault());
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone.</p>
     *
     * @param millis   the time expressed in milliseconds
     * @param pattern  the pattern to use to format the date
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(long millis, String pattern, TimeZone timeZone) {
        return format(new Date(millis), pattern, timeZone, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone.</p>
     *
     * @param date     the date to format
     * @param pattern  the pattern to use to format the date
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(Date date, String pattern, TimeZone timeZone) {
        return format(date, pattern, timeZone, null);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a time zone.</p>
     *
     * @param calendar the calendar to format
     * @param pattern  the pattern to use to format the calendar
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted calendar
     * @since 2.4
     */
    public static String format(Calendar calendar, String pattern, TimeZone timeZone) {
        return format(calendar, pattern, timeZone, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a locale.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(long millis, String pattern, Locale locale) {
        return format(new Date(millis), pattern, null, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a locale.</p>
     *
     * @param date    the date to format
     * @param pattern the pattern to use to format the date
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(Date date, String pattern, Locale locale) {
        return format(date, pattern, null, locale);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a locale.</p>
     *
     * @param calendar the calendar to format
     * @param pattern  the pattern to use to format the calendar
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(Calendar calendar, String pattern, Locale locale) {
        return format(calendar, pattern, null, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone  and locale.</p>
     *
     * @param millis   the date to format expressed in milliseconds
     * @param pattern  the pattern to use to format the date
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(long millis, String pattern, TimeZone timeZone, Locale locale) {
        return format(new Date(millis), pattern, timeZone, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone  and locale.</p>
     *
     * @param date     the date to format
     * @param pattern  the pattern to use to format the date
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(Date date, String pattern, TimeZone timeZone, Locale locale) {

        DateFormat df = new SimpleDateFormat(pattern, locale);
        df.setTimeZone(timeZone);
        return df.format(date);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a time zone  and locale.</p>
     *
     * @param calendar the calendar to format
     * @param pattern  the pattern to use to format the calendar
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted calendar
     */
    public static String format(Calendar calendar, String pattern, TimeZone timeZone, Locale locale) {
        DateFormat df = new SimpleDateFormat(pattern, locale);
        df.setTimeZone(timeZone);
        return df.format(calendar.getTime());

    }
}
