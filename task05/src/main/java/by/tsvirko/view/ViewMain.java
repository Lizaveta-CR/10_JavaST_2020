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
        System.out.println(resourceManager.getString("text.task"));
        System.out.println(resourceManager.getString("text.task1"));
        System.out.println(resourceManager.getString("text.task2"));
        System.out.println(resourceManager.getString("text.task3"));
        System.out.println(resourceManager.getString("text.task4"));
        System.out.println(resourceManager.getString("text.task5"));

        switch (scanner.nextInt()) {
            case 1:
                System.out.println(controller.executeTask(task1()));
                break;
            case 2:
                System.out.println(controller.executeTask(task2()));
                break;
            case 3:
                System.out.println(controller.executeTask(task3()));
                break;
            case 4:
                System.out.println(controller.executeTask(task4()));
                break;
            case 5:
                System.out.println(controller.executeTask(task5()));
                break;
        }

    }

    private List<String> task1() {
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

    private List<String> task2() {
        List<String> list = new ArrayList<>();
        list.add("task2");
        System.out.println(resourceManager.getString("text.chooseInput"));
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                list.addAll(1, consoleView.task2Console());
                break;
            case 2:
                list.addAll(1, fileView.task2File());
                break;
        }
        return list;
    }

    private List<String> task3() {
        List<String> list = new ArrayList<>();
        list.add("task3");
        System.out.println(resourceManager.getString("text.chooseInput"));
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                list.addAll(1, consoleView.task3Console());
                break;
            case 2:
                list.addAll(1, fileView.task3File());
                break;
        }
        return list;
    }

    private List<String> task4() {
        List<String> list = new ArrayList<>();
        list.add("task4");
        System.out.println(resourceManager.getString("text.chooseInput"));
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                list.addAll(1, consoleView.task4Console());
                break;
            case 2:
                list.addAll(1, fileView.task4File());
                break;
        }
        return list;
    }

    private List<String> task5() {
        List<String> list = new ArrayList<>();
        list.add("task5");
        System.out.println(resourceManager.getString("text.chooseInput"));
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                list.addAll(1, consoleView.task5Console());
                break;
            case 2:
                list.addAll(1, fileView.task5File());
                break;
        }
        return list;
    }
}
