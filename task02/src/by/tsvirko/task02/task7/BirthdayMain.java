package by.tsvirko.task02.task7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BirthdayMain {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter birthday date like " + "'" + DATE_FORMAT + "'");
        try {
            String userDate = scanner.next();
            validateDateFormat(userDate);
            Date javaDate = new SimpleDateFormat(DATE_FORMAT).parse(userDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(javaDate);
            System.out.println(weekDay(userDate, cal));
            BirthdayUtility.showFullAge(javaDate, cal);
            if (BirthdayUtility.isBirthday(javaDate, cal)) System.out.println("Happy birthday!!!");
        } catch (ParseException e) {
            System.err.println("Invalid format");
        }
    }

    private static boolean validateDateFormat(String strDate) {
        SimpleDateFormat sdfrmt = new SimpleDateFormat(DATE_FORMAT);
        sdfrmt.setLenient(false);
        try {
            sdfrmt.parse(strDate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private static String weekDay(String userDate, Calendar calendar) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
