package by.tsvirko.task01.service;

import java.util.Scanner;

public interface ReaderAccess {
    int fileReader(Scanner scanner, String filePath);

    int consoleReader();
}
