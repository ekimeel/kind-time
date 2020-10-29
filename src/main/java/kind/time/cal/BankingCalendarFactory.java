package kind.time.cal;

public class BankingCalendarFactory {

    protected static final int MIN_YEAR = 1980;
    protected static final int MAX_YEAR = 9999;
    protected static final int MIN_MONTH = 0;
    protected static final int MAX_MONTH = 11;
    protected static final int MIN_DAY = 1;
    protected static final int MAX_DAY = 31;

    /**
     * Creates a new instance of {@code CalendarDate} with the given {@code year},
     * {@code month}, and {@code day}.
     *
     * @param year  the year in four digits ei 2009
     * @param month the month in zero based form 0-11
     * @param day   the day of the month 1-31
     * @return {@code CalendarDate}
     * @see CalendarDate
     */
    public static CalendarDate createDate(int year, int month, int day) {
        checkDay(day);
        checkMonth(month);
        checkYear(year);
        return CalendarDate.of(year, month, day);
    }

    private static void checkYear(int year) throws IllegalArgumentException {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Year should be 1980 <= year =< 9999");
        }
    }

    private static void checkMonth(int month) throws IllegalArgumentException {
        if (month > MAX_MONTH || month < MIN_MONTH) {
            throw new IllegalArgumentException("Month should be 0-11");
        }
    }

    private static void checkDay(int day) throws IllegalArgumentException {

        if (day < MIN_DAY || day > MAX_DAY) {
            throw new IllegalArgumentException("Day should be in the range 1-31");
        }
    }
}
