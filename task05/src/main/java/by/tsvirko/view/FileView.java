package main.java.by.tsvirko.view;

import main.java.by.tsvirko.resource.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileView {
    private ResourceManager resourceManager = ResourceManager.INSTANCE;
    private final String FILE = "2";
    private Scanner scanner = new Scanner(System.in);

    List<String> task1File() {
        List<String> list = new ArrayList<>();
        list.add(FILE);
        System.out.println(resourceManager.getString("text.fileStr1"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleStr2"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleStr3"));
        list.add(scanner.next());
        return list;
    }

}
