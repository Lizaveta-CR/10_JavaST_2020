package by.tsvirko.task01.service.readers;

import java.util.Scanner;

public class ReaderAccess {
    public static int getFile(Scanner scanner, String filePath) {
        System.out.println("Write file name (Number): ");
        String filename = scanner.next();
        String fullPath = filePath.concat(filename);
        FileIntegerReader reader = new FileIntegerReader(fullPath);
        return reader.readNumber();
    }

    public static int getConsole() {
        System.out.println("Write positive number and press <Enter>: ");
        IntegerReader reader = new ConsoleIntegerReader();
        return reader.readNumber();
    }
}
