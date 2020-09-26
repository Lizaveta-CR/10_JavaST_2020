package by.tsvirko.task01.service;

import java.util.Scanner;

public interface ReaderAccess {
    long fileReader(Scanner scanner, String filePath);

    long consoleReader();
}
