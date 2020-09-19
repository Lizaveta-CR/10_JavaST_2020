package by.tsvirko.task01.dao;

import java.util.Scanner;

public class ConsoleIntegerReading implements IntegerReadring {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int readNumber() {
        return scanner.nextInt();
    }
}
