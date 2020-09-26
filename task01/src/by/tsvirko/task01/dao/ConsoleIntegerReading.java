package by.tsvirko.task01.dao;

import java.util.Scanner;

public class ConsoleIntegerReading implements IntegerReading {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public long readNumber() {
        return scanner.nextLong();
    }
}
