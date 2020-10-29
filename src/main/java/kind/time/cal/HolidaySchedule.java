package kind.time.cal;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;


/**
 * @author Michael J. Lee
 */
public class HolidaySchedule implements Iterable<Holiday>, Serializable {
    private static final long serialVersionUID = 1L;
    private final Holiday[] holidays;

    public static HolidaySchedule newEmptyHolidaySchedule() {
        return new HolidaySchedule(new Holiday[0]);
    }

    public static HolidaySchedule of(Holiday... holidays) {

        return new HolidaySchedule(holidays);
    }

    private HolidaySchedule(final Holiday[] holidays) {
        this.holidays = holidays;
    }

    public final Iterator<Holiday> iterator() {
        return new HolidayScheduleIterator(this);
    }

    public final boolean containsDate(Calendar date) {
        if (holidays == null) {

            return false;
        }

        for (Holiday holiday : holidays)
            if (holiday.getDate() != null)
                if (holiday.equalsDate(date))
                    return true;

        return false;
    }


    public class HolidayScheduleIterator implements Iterator<Holiday> {
        private int location;
        private final Holiday[] holidays;

        private HolidayScheduleIterator(final HolidaySchedule holidaySchedule) {
            this.holidays = holidaySchedule.holidays;
        }

        public boolean hasNext() {
            if (location < holidays.length && holidays[location] != null) {
                return true;
            }
            return false;
        }

        public Holiday next() {
            return holidays[location++];
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }


}
