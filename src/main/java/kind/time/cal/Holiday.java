package kind.time.cal;

import java.io.Serializable;
import java.util.Calendar;


/**
 * @author Michael J. Lee
 */
public class Holiday implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final Calendar date;

    public Holiday(final String name, final Calendar date) {
        this.name = name;
        this.date = date;
    }

    public final String getName() {
        return name;
    }

    public final Calendar getDate() {
        return date;
    }

    /**
     * Returns if the given <code>Calendar</code> is the same <code>YEAR</code>,
     * <code>MONTH</code> and <code>DAY_OF_MONTH</code> of the current
     * <code>Holiday</code>.
     *
     * @param calendar The calendar to check
     * @return True if the given <code>Calendar</code> is the same <code>YEAR</code>,
     * <code>MONTH</code> and <code>DAY_OF_MONTH</code> of the current
     * <code>Holiday</code>, otherwise false.
     */
    public boolean equalsDate(Calendar calendar) {
        if (calendar == null || date == null)
            return false;

        if (date.get(Calendar.YEAR) == calendar.get(Calendar.YEAR))
            if (date.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
                if (date.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH))
                    return true;

        return false;

    }


    @Override
    public String toString() {
        return getName() + " [" + getDate() + "]";
    }


}
