package by.tsvirko.task02.task6;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarUtility {

    private static Calendar calendar = Calendar.getInstance();

    private CalendarUtility() {
        throw new AssertionError("Instantiating utility class.");
    }

    public static void devLimit(int devDayNum, String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.add(Calendar.DAY_OF_MONTH, devDayNum);
        String newDate = sdf.format(calendar.getTime());
        int hour = calendar.get(Calendar.HOUR);
        if (devDayNum > 0) {
            System.out.println(name + ",you have " + devDayNum + " days.\n"
                    + " Finish by " + newDate + " " + hour + " h.");
        } else if (devDayNum == 0) {
            System.out.println(name + " ,okay, we are waiting today " + newDate
                    + " till " + hour + " h.");
        }
    }
}
