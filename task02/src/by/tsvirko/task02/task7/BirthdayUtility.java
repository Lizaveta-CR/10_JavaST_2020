package by.tsvirko.task02.task7;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class BirthdayUtility {
    private BirthdayUtility() {
        throw new AssertionError("Instantiating utility class.");
    }

    public static void showFullAge(Date userDate, Calendar calendar) throws ParseException {
        int years = 0;
        int months = 0;
        int days = 0;

        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(userDate.getTime());

        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;

        months = currMonth - birthMonth;

        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
                months--;
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }

        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        System.out.println(years + " years " + months + " months " + days + " days");
    }

    public static boolean isBirthday(Date usersDate, Calendar calendar) {
        int usersDay = calendar.get(Calendar.DATE);
        int usersMonth = calendar.get(Calendar.MONTH);

        Calendar now = Calendar.getInstance();
        int nowDay = now.get(Calendar.DATE);
        int nowMonth = now.get(Calendar.MONTH);

        return (usersDay == nowDay) && (usersMonth == nowMonth);
    }
}
