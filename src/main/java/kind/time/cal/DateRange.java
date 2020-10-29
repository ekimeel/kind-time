package kind.time.cal;

import kind.time.Duration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * @author Michael J. Lee
 */
public class DateRange implements Serializable, Duration {

    private static final long serialVersionUID = 1;

    public enum DateToIncludeWhenAllDaysNotIncluded {

        StartDate,
        EndDate
    }

    /**
     * Creates a date range from the given start and end <code>Calendar</code>
     * <br/>
     * Examples...<br/>
     * When <code>includedStartSay</code> <strong>IS NOT</strong> included 1/1/2001 to 1/31/2001 = 30 days<br/>
     * When <code>includedStartSay</code> <strong>IS</strong> included 1/1/2001 to 1/31/2001 = 31 days<br/>
     *
     * @param startDate               the start date <code>Calendar</code> of the range
     * @param endDate                 the end date <code>Calendar</code> of the range
     * @param includedStartDayInCount if true an extra day will be included in the total range
     * @return A new instance of a <code>DateRange</code>
     * @throws InvalidDateException when start date is after the end date or either dates are null.
     * @see DateRange#of(Calendar startDate, Calendar endDate)
     */
    public static synchronized DateRange of(Calendar startDate, Calendar endDate, boolean includedStartDayInCount) throws InvalidDateException {
        failIfNotValid(startDate, endDate);

        return new DateRange(startDate, endDate, includedStartDayInCount);

    }

    /**
     * Creates a date range from the given start and end <code>Calendar</code>
     * E.g 1/1/2001 to 1/31/2001 = 30 days
     *
     * @param startDate the start date <code>Calendar</code> of the range
     * @param endDate   the end date <code>Calendar</code> of the range
     * @return A new instance of a <code>DateRange</code>
     * @throws InvalidDateException when start date is after the end date or either dates are null.
     * @see DateRange#of(Calendar startDate, Calendar endDate, boolean includedStartDayInCount)
     */
    public static synchronized DateRange of(Calendar startDate, Calendar endDate) throws InvalidDateException {
        return of(startDate, endDate, false);
    }

    public static synchronized DateRange of(Calendar startDate, Calendar endDate, int numberOfDaysInDateRange) throws InvalidDateException {
        DateRange dateRange = of(startDate, endDate);

        final int differenceBetweenDateDiffDaysAndNumberOfDaysInDateRange = (numberOfDaysInDateRange - dateRange.differenceInDates);

        if (differenceBetweenDateDiffDaysAndNumberOfDaysInDateRange != 0) {
            throw new InvalidDateException("Invalid number of days in range.  " +
                    "Expected [" + numberOfDaysInDateRange + "] but was " +
                    "[" + differenceBetweenDateDiffDaysAndNumberOfDaysInDateRange + "].");
        }
        dateRange.numberOfDaysInDateRange = numberOfDaysInDateRange;

        return dateRange;
    }

    //    public static synchronized DateRange set(Calendar startDate, Calendar endDate, boolean includesAllDays) throws InvalidDateException {
//        DateRange dateRange = set(startDate, endDate);
//
//        if (includesAllDays)
//        {
//            dateRange.differenceInDates++;
//            dateRange.numberOfDaysInDateRange = dateRange.differenceInDates + 1;
//        } else
//            dateRange.numberOfDaysInDateRange = dateRange.differenceInDates;
//
//        return dateRange;
//    }
    private static Boolean failIfNotValid(Calendar startDate, Calendar endDate) throws InvalidDateException {
        if (startDate == null) {
            throw new InvalidDateException("Start date cannot be null in a date range.");
        }
        if (endDate == null) {
            throw new InvalidDateException("End date cannot be null in a date range.");
        }

        return true;
    }

    private int differenceInDates;
    private int numberOfDaysInDateRange;
    private DateToIncludeWhenAllDaysNotIncluded dateToIncludeWhenAllDaysNotIncluded =
            DateToIncludeWhenAllDaysNotIncluded.StartDate;
    private final Calendar startDate;
    private final Calendar endDate;
    private final boolean includeStartDayInCount;
    private final int daysInRange;
    private final long millisecondsInRange;

    private DateRange(Calendar startDate, Calendar endDate, boolean includeStartDayInCount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.millisecondsInRange = endDate.getTimeInMillis() - startDate.getTimeInMillis();
        this.includeStartDayInCount = includeStartDayInCount;
        this.daysInRange = CalendarCalculator.calculateDaysDifference(startDate, endDate) + ((includeStartDayInCount) ? 1 : 0);

    }

    //    private int calculateDaysInRange() {
//        final long milli = this.endDate().
//    }
    public long getTimeInMillis() {
        return this.millisecondsInRange;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Calendar getStartDate() {
        return startDate;
    }


    public int getDaysInRange() {
        return daysInRange;
    }

    public boolean includesAllDays() {
        return ((differenceInDates + 1) == numberOfDaysInDateRange);
    }

    public List<Long> getDatesInRangeAsUTCMilliSeconds() {
        List<Long> calendars = new ArrayList<Long>();

        //long millisecondsInADay = (1000 * 60 * 60 * 24);
        long endDateInUTCMilliseconds = toTimeInMillis(endDate);
        long currentDateInUTCMilliseconds = toTimeInMillis(startDate);

        while (currentDateInUTCMilliseconds <= endDateInUTCMilliseconds) {
            Calendar currentDate = new GregorianCalendar();
            currentDate.setTimeInMillis(currentDateInUTCMilliseconds);
            calendars.add(currentDateInUTCMilliseconds);
            currentDateInUTCMilliseconds += currentDate.getTimeInMillis();
        }

        if (!this.includesAllDays()) {
            Long removedItem = null;
            if (this.dateToIncludeWhenAllDaysNotIncluded == DateToIncludeWhenAllDaysNotIncluded.EndDate) //remove first date so we are counting the last
            {
                removedItem = calendars.remove(0);
            } else //else remove last
            {
                removedItem = calendars.remove(calendars.size() - 1);
            }
            removedItem = null;
        }


        return calendars;
        //        Calendar currentDate = this.startDate;
//        while (!currentDate.after(endDate))
//        {
//            calendars.add(currentDate);
//            currentDate = (Calendar) currentDate.clone();
//            currentDate.roll(Calendar.DATE, true);
//            System.out.println(currentDate.getTime().toString());
//        }

        //if we dont have all the days included we have to make some adjustments to list, removing
        //either the start or end
//        if (!this.includesAllDays())
//        {
//            if (this.dateToIncludeWhenAllDaysNotIncluded == DateToIncludeWhenAllDaysNotIncluded.EndDate)
//            {
//                //remove first date so we are counting the last
//                calendars.remove(0);
//            }
//            else
//            {
//                //else remove last
//                calendars.remove(calendars.size()-1);
//            }
//        }

        //return calendars;
    }

    public void setDateToIncludeWhenAllDaysNotIncluded(DateToIncludeWhenAllDaysNotIncluded dateToIncludeWhenAllDaysNotIncluded) {
        this.dateToIncludeWhenAllDaysNotIncluded = dateToIncludeWhenAllDaysNotIncluded;
    }

    public DateToIncludeWhenAllDaysNotIncluded getDateToIncludeWhenAllDaysNotIncluded() {
        return this.dateToIncludeWhenAllDaysNotIncluded;
    }

//    public int getDifferenceInDates() {
//        return this.differenceInDates;
//    }

    public Long toTimeInMillis(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    public boolean containsDate(Calendar date) {
        return ((date.after(startDate) && date.before(endDate)) || date.equals(startDate) || date.equals(endDate));
    }

    @Override
    public String toString() {
        return "Date Range : " + this.getStartDate().toString() + " - " + this.getEndDate().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateRange) {
            DateRange dateRange = (DateRange) obj;
            return dateRange.hashCode() == this.hashCode();
        }

        return false;

    }

    @Override
    public int hashCode() {
        int hash = 7;
//        hash = 83 * hash + this.differenceInDates;
//        hash = 83 * hash + this.numberOfDaysInDateRange;
//        hash = 83 * hash + (this.dateToIncludeWhenAllDaysNotIncluded != null ? this.dateToIncludeWhenAllDaysNotIncluded.hashCode() : 0);
        hash = 83 * hash + (this.startDate != null ? this.startDate.hashCode() : 0);
        hash = 83 * hash + (this.endDate != null ? this.endDate.hashCode() : 0);
        return hash;
    }
}
