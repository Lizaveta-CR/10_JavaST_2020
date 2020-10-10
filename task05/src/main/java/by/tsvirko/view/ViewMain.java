package main.java.by.tsvirko.view;

import main.java.by.tsvirko.controller.Controller;
import main.java.by.tsvirko.resource.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ViewMain {
    private ResourceManager resourceManager = ResourceManager.INSTANCE;
    private Controller controller = new Controller();
    private ConsoleView consoleView = new ConsoleView();
    private FileView fileView = new FileView();
    private Scanner scanner = new Scanner(System.in);

    void chooseLanguage() {
        System.out.println("1-русский\n2-english");
        switch (scanner.nextInt()) {
            case 1:
                resourceManager.changeResource(new Locale("ru", "RU"));
                break;
            case 2:
                resourceManager.changeResource(new Locale("en", "US"));
                break;
        }
    }

    public void tasks() {
        chooseLanguage();
        System.out.println(resourceManager.getString("text.task1"));
        System.out.println(controller.executeTask(task1()));
    }

    List<String> task1() {
        List<String> list = new ArrayList<>();
        list.add("task1");
        System.out.println(resourceManager.getString("text.chooseInput"));
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                list.addAll(1, consoleView.task1Console());
                break;
            case 2:
                list.addAll(1, fileView.task1File());
                break;
        }
        return list;
    }

}
