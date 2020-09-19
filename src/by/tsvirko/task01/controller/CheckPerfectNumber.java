package by.tsvirko.task01.controller;

//TODO: classname convention

import by.tsvirko.task01.service.PerfectNumber;
import by.tsvirko.task01.service.readers.ReaderAccess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckPerfectNumber {
    private static String FILE_PATH = "src/by/tsvirko/task01/beans/";

    public static void main(String[] args) {
        System.out.println("Press 1 if you want to write number "
                + "from console\n" + "Press 2 if you want to "
                + "read number from file");
        Scanner scanner = new Scanner(System.in);
        try {
            int userNumber = getUserNumber(scanner);
            System.out.println(PerfectNumber.isPerfectNumber(userNumber));
        } catch (InputMismatchException e) {
            System.err.println("Only 1 or 2!");
        }
    }

    private static int getUserNumber(Scanner scanner) {
        int userConsoleNumber = scanner.nextInt();
        switch (userConsoleNumber) {
            case 1:
                return ReaderAccess.getConsole();
            case 2:
                return ReaderAccess.getFile(scanner, FILE_PATH);
            default:
                throw new InputMismatchException();
        }
    }
}
