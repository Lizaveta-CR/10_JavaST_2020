package by.tsvirko.task01.controller;

//TODO: classname convention

import by.tsvirko.task01.service.PerfectNumber;
import by.tsvirko.task01.service.readingInformation.ConsoleIntegerReader;
import by.tsvirko.task01.service.readingInformation.FileIntegerReader;
import by.tsvirko.task01.service.readingInformation.IntegerReader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckPerfectNumber {
    private static String FILE_PATH = "src/by/tsvirko/task01/beans/";
    private static String STOP_WORD = "Stop";

    public static void main(String[] args) {
        System.out.println("Press 1 if you want to write number "
                + "from console\n" + "Press 2 if you want to "
                + "read number from file\n"
                + "If you want to stop, write 'Stop'");

        Scanner scanner = new Scanner(System.in);
//        boolean flag = true;
//        while (flag) {
//            if (scanner.next().equals(STOP_WORD.toUpperCase())) {
//                flag = false;
//            }
        try {
            int userNumber = getUserNumber(scanner.nextInt());
            System.out.println(PerfectNumber.isPerfectNumber(userNumber));
        } catch (InputMismatchException e) {
            System.err.println("Only 1 or 2!");
        }
        System.out.println("Press <Enter>");
//        }

    }

    private static int getUserNumber(int userConsoleNumber) {
        Scanner scanner = new Scanner(System.in);
        switch (userConsoleNumber) {
            case 1:
                return getConsole();
            case 2:
                return getFile(scanner);
            default:
                System.err.println("Only 1 or 2!");
                getUserNumber(scanner.nextInt());
        }
        return 0;
    }

    private static int getFile(Scanner scanner) {
        System.out.println("Write file name (Number): ");
        String filename = scanner.next();
        FileIntegerReader reader = new FileIntegerReader(FILE_PATH.concat(filename));
        return reader.readNumber();
    }

    private static int getConsole() {
        System.out.println("Write positive number and press <Enter>: ");
        IntegerReader reader = new ConsoleIntegerReader();
        return reader.readNumber();
    }
}
