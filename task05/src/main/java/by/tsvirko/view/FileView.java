package main.java.by.tsvirko.view;

import main.java.by.tsvirko.resource.ResourceManager;

import java.util.ArrayList;
import java.util.Collection;
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

    public List<String> task2File() {
        List<String> list = new ArrayList<>();
        list.add(FILE);
        System.out.println(resourceManager.getString("text.fileStr1"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleTask2Str1"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleTask2Str2"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleTask2Str3"));
        list.add(scanner.next());
        return list;
    }

    public List<String> task3File() {
        List<String> list = new ArrayList<>();
        list.add(FILE);
        System.out.println(resourceManager.getString("text.fileStr1"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleTask3Str2"));
        list.add(scanner.next());
        System.out.println(resourceManager.getString("text.consoleTask3Str1"));
        list.add(scanner.next());
        return list;
    }

    public List<String> task4File() {
        List<String> list = new ArrayList<>();
        list.add(FILE);
        System.out.println(resourceManager.getString("text.fileStr1"));
        list.add(scanner.next());
        return list;
    }
}
