package main.java.by.tsvirko.view;

import main.java.by.tsvirko.resource.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private ResourceManager resourceManager = ResourceManager.INSTANCE;
    private final String TERMINATOR_STRING = ",,";
    private final String CONSOLE = "1";
    private Scanner scanner = new Scanner(System.in);

    List<String> task1Console() {
        List<String> list = new ArrayList<>();
        list.add(CONSOLE);
        System.out.println(resourceManager.getString("text.consoleStr1"));
        list.add(readText());
        System.out.println(resourceManager.getString("text.consoleStr2"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleStr3"));
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

    public List<String> task2Console() {
        List<String> list = new ArrayList<>();
        list.add(CONSOLE);
        System.out.println(resourceManager.getString("text.consoleStr1"));
        list.add(readText());
        System.out.println(resourceManager.getString("text.consoleTask2Str1"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleTask2Str2"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleTask2Str3"));
        list.add(scanner.next());
        return list;
    }
}
