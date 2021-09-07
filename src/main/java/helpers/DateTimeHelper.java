package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {
    private static Calendar calendar = Calendar.getInstance();

    /**
     * Choose random depart date from drop-down list:
     * Get current date and add a random number of date between 3-30
     *
     * @return random depart date
     */
    public static String getDateFromToday(int day) {
        calendar.setTime(DataHelper.getCurrentDate());
        calendar.add(Calendar.DATE, day);
        return new SimpleDateFormat("M/d/yyyy").format(calendar.getTime());
    }
}
