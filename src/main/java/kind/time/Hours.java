package kind.time;


public class Hours implements Duration {

    public static final long MILLISECONDS_IN_A_HOUR = 3600000;
    public static final long SECONDS_IN_A_HOUR = 3600;
    public static final int MINUTES_IN_A_HOUR = 60;

    /**
     * Returns the number of milliseconds in the given number of hours.
     * 1 hour = 3600000 milliseconds
     *
     * @param hours the number hours.
     * @return the number of milliseconds in the given hours.
     */
    public static long toMilliseconds(int hours) {
        return hours * Hours.MILLISECONDS_IN_A_HOUR;
    }

    /**
     * Returns the number of seconds in the given number of hours.
     * 1 hour = 3600 minutes
     *
     * @param hours the number hours.
     * @return the number of seconds in the given hours.
     */
    public static long toSeconds(int hours) {
        return hours * Hours.SECONDS_IN_A_HOUR;
    }

    /**
     * Returns the number of minutes in the given number of hours.
     * 1 hour = 60 minutes
     *
     * @param hours the number hours.
     * @return the number of minutes in the given hours.
     */
    public static long toMinutes(int hours) {
        return hours * Hours.MINUTES_IN_A_HOUR;
    }

    private Hours() {
    }

    public long getTimeInMillis() {
        return MILLISECONDS_IN_A_HOUR;
    }
}
