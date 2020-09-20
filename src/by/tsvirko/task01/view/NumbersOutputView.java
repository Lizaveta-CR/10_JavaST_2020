package by.tsvirko.task01.view;

import by.tsvirko.task01.service.ReaderAccess;
import by.tsvirko.task01.service.ReaderAccessImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumbersOutputView {
    private String filePath = "src/by/tsvirko/task01/";
    private ReaderAccess reader = new ReaderAccessImpl();

    /**
     * Returns an integer number depending on user's choice:
     * 1- get it from console;
     * 2-get from file.
     *
     * @param scanner allows to read a number from System.in
     * @return an integer number
     */
    public int getNumber(Scanner scanner) {
        int userConsoleNumber = scanner.nextInt();
        switch (userConsoleNumber) {
            case 1:
                return reader.consoleReader();
            case 2:
                return reader.fileReader(scanner, filePath);
            default:
                throw new InputMismatchException();
        }
    }
}
