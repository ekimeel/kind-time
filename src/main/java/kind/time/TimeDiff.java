package kind.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeDiff {

    public int seconds(Date startDate, Date endDate) {
        final long diff = endDate.getTime() - startDate.getTime();
        return (int)(diff / Constants.MILLISECONDS_IN_SECOND);
    }

    public int minutes(Date startDate, Date endDate) {
        final long diff = endDate.getTime() - startDate.getTime();
        return (int)(diff / Constants.MILLISECONDS_IN_MINUTE);
    }

    public int hours(Date startDate, Date endDate) {
        final long diff = endDate.getTime() - startDate.getTime();
        return (int)(diff / Constants.MILLISECONDS_IN_HOUR);
    }

    public int days(Date startDate, Date endDate) {
        final Calendar c1 = new GregorianCalendar();
        c1.setTime(startDate);
        final Calendar c2 = new GregorianCalendar();
        c2.setTime(endDate);
        return days((Calendar)c1, (Calendar)c2);
    }

    public int days(Calendar startDate, Calendar endDate) {
        long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
        int offset = endDate.get(16) - startDate.get(16);
        diff += (long)offset;
        int days = (int)(diff / Constants.MILLISECONDS_IN_DAY);
        return Math.abs(days);
    }

    public int hours(Calendar startDate, Calendar endDate) {
        long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
        int offset = endDate.get(16) - startDate.get(16);
        diff += (long)offset;
        int hours = (int)(diff / Constants.MILLISECONDS_IN_HOUR);
        return hours;
    }
}
