package by.tsvirko.task02.task6;

import by.tsvirko.task02.task1.ValidateName;

import java.util.*;

public class DeveloperCalendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your name: ");
            String name = scanner.next();
            if (isNameValid(name)) {
                System.out.println("How many days do you need?");
                int days = scanner.nextInt();
                if (isDayValid(days)) {
                    CalendarUtility.devLimit(days, name);
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Check your answers!");
        }
    }

    private static boolean isDayValid(int userDate) {
        if (userDate < 0) throw new InputMismatchException();
        return true;
    }

    private static boolean isNameValid(String name) {
        ValidateName validateName = new ValidateName();
        if (validateName.validateUserName(name)) {
            return true;
        } else {
            throw new InputMismatchException();
        }
    }
}
