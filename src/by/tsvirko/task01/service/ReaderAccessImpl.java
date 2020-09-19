package by.tsvirko.task01.service;

import by.tsvirko.task01.dao.ConsoleIntegerReading;
import by.tsvirko.task01.dao.FileIntegerReading;
import by.tsvirko.task01.dao.IntegerReadring;

import java.util.Scanner;

public class ReaderAccessImpl implements ReaderAccess {
    public int fileReader(Scanner scanner, String filePath) {
        System.out.println("Write file name (Number): ");
        String filename = scanner.next();
        String fullPath = filePath.concat(filename);
        FileIntegerReading reader = new FileIntegerReading(fullPath);
        return reader.readNumber();
    }

    public int consoleReader() {
        System.out.println("Write positive number and press <Enter>: ");
        IntegerReadring reader = new ConsoleIntegerReading();
        return reader.readNumber();
    }
}
