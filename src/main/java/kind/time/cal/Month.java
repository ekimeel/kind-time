package kind.time.cal;

import java.util.ArrayList;
import java.util.List;

public enum Month {
    JANUARY(Months.JANUARY, "January", "Jan"),
    FEBRUARY(Months.FEBRUARY, "February", "Feb"),
    MARCH(Months.MARCH, "March", "Mar"),
    APRIL(Months.APRIL, "April", "Apr"),
    MAY(Months.MAY, "May", "May"),
    JUNE(Months.JUNE, "June", "Jun"),
    JULY(Months.JULY, "July", "Jul"),
    AUGUST(Months.AUGUST, "August", "Aug"),
    SEPTEMBER(Months.SEPTEMBER, "September", "Sep"),
    OCTOBER(Months.OCTOBER, "October", "Oct"),
    NOVEMBER(Months.NOVEMBER, "November", "Nov"),
    DECEMBER(Months.DECEMBER, "December", "Dec");

    /**
     * Contains a list of all the months
     */
    public static final List<Month> MONTHS;
    public static final int MAXIMUM_MONTH = 11;
    public static final int MINIMUM_MONTH = 0;

    static {
        MONTHS = new ArrayList<Month>();
        MONTHS.add(JANUARY);
        MONTHS.add(FEBRUARY);
        MONTHS.add(MARCH);
        MONTHS.add(APRIL);
        MONTHS.add(MAY);
        MONTHS.add(JUNE);
        MONTHS.add(JULY);
        MONTHS.add(AUGUST);
        MONTHS.add(SEPTEMBER);
        MONTHS.add(OCTOBER);
        MONTHS.add(NOVEMBER);
        MONTHS.add(DECEMBER);
    }

    ;

    /**
     * Returns a month based on a gregorian calendar.
     * <br/>
     * <table border="1">
     * <tr>
     * <td>value</td><td>returns</td>
     * </tr>
     * <tr><td>0</td><td>January</td></tr>
     * <tr><td>1</td><td>February</td></tr>
     * <tr><td>2</td><td>March</td></tr>
     * <tr><td>3</td><td>April</td></tr>
     * <tr><td>4</td><td>May</td></tr>
     * <tr><td>5</td><td>June</td></tr>
     * <tr><td>6</td><td>July</td></tr>
     * <tr><td>7</td><td>August</td></tr>
     * <tr><td>8</td><td>September</td></tr>
     * <tr><td>9</td><td>October</td></tr>
     * <tr><td>10</td><td>November</td></tr>
     * <tr><td>11</td><td>December</td></tr>
     * <tr><td>otherwise</td><td>null</td></tr>
     * </table>
     *
     * @param value zero based index of a month based on a gregorian
     *              calendar.
     * @return a Month if value given can be found, Otherwise null.
     */
    public static Month of(int value) {

        if (value < MINIMUM_MONTH)
            return null;

        if (value > MAXIMUM_MONTH)
            return null;

        return MONTHS.get(value);

    }

    /**
     * Returns the formal name of the current month from a gregorian
     * calendar.
     * <br/>
     * <table border="1">
     * <tr>
     * <td>monthName</td><td>Return Month</td>
     * </tr>
     * <tr><td>January | Jan</td><td>January</td></tr>
     * <tr><td>Febraury | Feb</td><td>February</td></tr>
     * <tr><td>March | Mar</td><td>March</td></tr>
     * <tr><td>April | Apr</td><td>April</td></tr>
     * <tr><td>May</td><td>May</td></tr>
     * <tr><td>June | Jun</td><td>June</td></tr>
     * <tr><td>July | Jul</td><td>July</td></tr>
     * <tr><td>August | Aug</td><td>August</td></tr>
     * <tr><td>September | Sep</td><td>September</td></tr>
     * <tr><td>October | Oct</td><td>October</td></tr>
     * <tr><td>November | Nov</td><td>November</td></tr>
     * <tr><td>December | Dec</td><td>December</td></tr>
     * </table>
     *
     * @param monthName long or short month name case is ignored.
     * @return a month if the monthName can be found, otherwise null
     */
    public static Month of(String monthName) {
        for (Month month : MONTHS) {
            if (month.name.equalsIgnoreCase(monthName))
                return month;

            if (month.shortName.equalsIgnoreCase(monthName))
                return month;

        }
        return null;
    }

    private final int value;
    private final String name;
    private final String shortName;


    private Month(int value, String name, String shortName) {
        this.value = value;
        this.name = name;
        this.shortName = shortName;

    }

    /**
     * Returns the formal name of the current month from a gregorian
     * calendar.
     * <br/>
     * <table border="1">
     * <tr>
     * <td>Month Index</td><td>Return Value</td>
     * </tr>
     * <tr><td>0</td><td>January</td></tr>
     * <tr><td>1</td><td>February</td></tr>
     * <tr><td>2</td><td>March</td></tr>
     * <tr><td>3</td><td>April</td></tr>
     * <tr><td>4</td><td>May</td></tr>
     * <tr><td>5</td><td>June</td></tr>
     * <tr><td>6</td><td>July</td></tr>
     * <tr><td>7</td><td>August</td></tr>
     * <tr><td>8</td><td>September</td></tr>
     * <tr><td>9</td><td>October</td></tr>
     * <tr><td>10</td><td>November</td></tr>
     * <tr><td>11</td><td>December</td></tr>
     * </table>
     *
     * @return the formal name of the current month.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the short name of the current month from a gregorian
     * calendar.
     * <br/>
     * <table border="1">
     * <tr>
     * <td>Month Index</td><td>Return Value</td>
     * </tr>
     * <tr><td>0</td><td>Jan</td></tr>
     * <tr><td>1</td><td>Feb</td></tr>
     * <tr><td>2</td><td>Mar</td></tr>
     * <tr><td>3</td><td>Apr/td></tr>
     * <tr><td>4</td><td>May</td></tr>
     * <tr><td>5</td><td>Jun</td></tr>
     * <tr><td>6</td><td>Jul</td></tr>
     * <tr><td>7</td><td>Aug</td></tr>
     * <tr><td>8</td><td>Sep</td></tr>
     * <tr><td>9</td><td>Oct</td></tr>
     * <tr><td>10</td><td>Nov</td></tr>
     * <tr><td>11</td><td>Dec</td></tr>
     * </table>
     *
     * @return the short name of the current month.
     */
    public String getShortName() {
        return shortName;
    }


    /**
     * Returns the zero based index of the current month within a
     * gregorian calendar.
     * <br/>
     * <table border="1">
     * <tr>
     * <td>Month</td><td>Return Value</td>
     * </tr>
     * <tr><td>January</td><td>0</td></tr>
     * <tr><td>February</td><td>1</td></tr>
     * <tr><td>March</td><td>2</td></tr>
     * <tr><td>April</td><td>3</td></tr>
     * <tr><td>May</td><td>4</td></tr>
     * <tr><td>June</td><td>5</td></tr>
     * <tr><td>July</td><td>6</td></tr>
     * <tr><td>August</td><td>7</td></tr>
     * <tr><td>September</td><td>8</td></tr>
     * <tr><td>October</td><td>9</td></tr>
     * <tr><td>November</td><td>10</td></tr>
     * <tr><td>December</td><td>11</td></tr>
     * </table>
     *
     * @return the zero based index of the current month.
     */
    public int getValue() {
        return value;
    }

    public int toInt() {
        return value;
    }

    @Override
    public String toString() {
        return getName();
    }
}
