package by.tsvirko.task01.service.readingInformation;

//TODO: classname convention

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int readInt() {
        System.out.println("Write positive number and press <Enter>: ");
        return scanner.nextInt();
    }
}
