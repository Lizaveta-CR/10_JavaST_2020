package main.java.by.tsvirko.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final String TERMINATOR_STRING = ",,";
    private final String CONSOLE = "1";
    private Scanner scanner = new Scanner(System.in);

    List<String> task1Console() {
        List<String> list = new ArrayList<>();
        list.add(CONSOLE);
        System.out.println("Enter text:");
        list.add(readText());
        System.out.println("Enter index:");
        list.add(scanner.next());
        System.out.println("Enter symbol:");
        list.add(scanner.next());
        return list;
    }

    private String readText() {
        StringBuilder b = new StringBuilder();
        String strLine;
        while (!(strLine = scanner.nextLine()).equals(TERMINATOR_STRING)) {
            b.append(strLine);
        }
        return b.toString();
    }
}
