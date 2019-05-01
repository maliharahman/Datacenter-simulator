package utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static Date getDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static int calculateTickCount(long load) {
        if (load >= 0 &&  load < 5000) {
            return 5;
        } else {
            return 10;
        }
    }
}
