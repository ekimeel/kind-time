package kind.time;

public final class Minutes implements Duration {

    public static final long MILLIS_IN_A_MINUTE = 60000;

    public static final MinuteMultiple ONE;

    public static final MinuteMultiple TWO;

    public static final MinuteMultiple THREE;

    public static final MinuteMultiple FOUR;

    public static final MinuteMultiple FIVE;

    public static final MinuteMultiple TEN;

    public static final MinuteMultiple FIFTEEN;

    public static final MinuteMultiple TWENTY;

    public static final MinuteMultiple THIRTY;

    public static final MinuteMultiple SIXTY;

    public static final MinuteMultiple NINETY;

    public static final MinuteMultiple ONE_HUNDRED;

    public static final MinuteMultiple ONE_HUNDRED_TWENTY;


    static {
        ONE = new MinuteMultiple(1);
        TWO = new MinuteMultiple(2);
        THREE = new MinuteMultiple(3);
        FOUR = new MinuteMultiple(4);
        FIVE = new MinuteMultiple(5);
        TEN = new MinuteMultiple(10);
        FIFTEEN = new MinuteMultiple(15);
        TWENTY = new MinuteMultiple(20);
        THIRTY = new MinuteMultiple(30);
        SIXTY = new MinuteMultiple(60);
        NINETY = new MinuteMultiple(90);
        ONE_HUNDRED = new MinuteMultiple(100);
        ONE_HUNDRED_TWENTY = new MinuteMultiple(120);
    }

    private Minutes() {
    }

    public long getTimeInMillis() {
        return MILLIS_IN_A_MINUTE;
    }

    /**
     * Returns the number of minutes in the given milliseconds
     *
     * @param milliseconds
     * @return
     */
    public static long toMinutes(long milliseconds) {
        return milliseconds / MILLIS_IN_A_MINUTE;
    }

    public static class MinuteMultiple implements Duration {

        private final int minutes;

        private final long milliseconds;

        private MinuteMultiple(int minutes) {
            this.minutes = minutes;
            this.milliseconds = minutes * MILLIS_IN_A_MINUTE;

        }

        public long getTimeInMillis() {
            return this.milliseconds;
        }

        public MinuteMultiple plus(MinuteMultiple amount) {
            //TODO: javadoc
            return new MinuteMultiple(this.minutes + amount.minutes);
        }

        public MinuteMultiple plus(int minutesToAdd) {
            //TODO: javadoc
            return new MinuteMultiple(this.minutes + minutesToAdd);
        }
    }
}
