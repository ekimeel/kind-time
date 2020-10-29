package kind.time.cal;

/**
 * @author Michael J. Lee
 */
public class Holidays {

    private Holidays() {
    }

    public static CalendarDate NewYearsDayObserved(int year) {
        //TODO: JavaDoc
        return CalendarDate.of(year, Months.JANUARY, 1).toNearestWeekday();
    }

    public static CalendarDate NewYearsDay(int year) {
        //TODO: JavaDoc
        return CalendarDate.of(year, Months.JANUARY, 1);
    }

    public static CalendarDate MartinLutherKingObserved(int year) {
        //TODO: JavaDoc
        CalendarMonth januray = CalendarMonth.of(year, Months.JANUARY);
        return januray.get(DayOfWeek.MONDAY, 3);  //<-- Third Monday in JANUARY
    }

    public static CalendarDate PresidentsDayObserved(int year) {
        //TODO: JavaDoc
        CalendarMonth januray = CalendarMonth.of(year, Months.FEBRUARY);
        return januray.get(DayOfWeek.MONDAY, 3);  //<-- Third Monday in FEBRUARY
    }

    public static CalendarDate MemorialDayObserved(int year) {
        //TODO: JavaDoc
        CalendarMonth januray = CalendarMonth.of(year, Months.MAY);
        return januray.getLast(DayOfWeek.MONDAY);  // Last Monday in MAY
    }

    public static CalendarDate IndependenceDayObserved(int year) {
        //TODO: JavaDoc
        CalendarDate calendar = CalendarDate.of(year, Months.JULY, 4);
        return calendar.toNearestWeekday();
    }

    public static CalendarDate LaborDayObserved(int year) {
        //TODO: JavaDoc
        CalendarMonth september = CalendarMonth.of(year, Months.SEPTEMBER);
        return september.getFirst(DayOfWeek.MONDAY);// First onday in SEPTEMBER
    }

    public static CalendarDate ChristmasDayObserved(int year) {
        //TODO: JavaDoc
        CalendarDate calendar = CalendarDate.of(year, Months.DECEMBER, 25);
        return calendar.toNearestWeekday();
    }

    public static CalendarDate ColumbusDayObserved(int year) {
        //TODO: JavaDoc
        CalendarMonth month = CalendarMonth.of(year, Months.OCTOBER);
        return month.get(DayOfWeek.MONDAY, 2);// Second Monday in OCTOBER
    }

    public static CalendarDate ElectionDay(int year) {
        //TODO: JavaDoc
        CalendarMonth october = CalendarMonth.of(year, Months.NOVEMBER);
        return october.getFirst(DayOfWeek.TUESDAY);// First Tuesday in NOVEMBER
    }

    public static CalendarDate VeteransDayObserved(int year) {
        //TODO: JavaDoc
        CalendarDate calendar = CalendarDate.of(year, Months.NOVEMBER, 11);
        return calendar.toNearestWeekday();
    }

    public static CalendarDate ThanksgivingDayObserved(int year) {
        //TODO: JavaDoc
        CalendarMonth month = CalendarMonth.of(year, Months.NOVEMBER);
        return month.get(DayOfWeek.THURSDAY, 4);//Fourth Thursday of November.
    }
}
