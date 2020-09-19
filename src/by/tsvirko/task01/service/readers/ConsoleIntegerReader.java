package by.tsvirko.task01.service.readers;

//TODO: classname convention

import java.util.Scanner;

public class ConsoleIntegerReader implements IntegerReader {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int readNumber() {
        return scanner.nextInt();
    }
}
