package main.java.by.tsvirko.view;

import main.java.by.tsvirko.controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewMain {
    private Controller controller = new Controller();
    private ConsoleView consoleView = new ConsoleView();
    private FileView fileView = new FileView();
    private Scanner scanner = new Scanner(System.in);

    public void tasks() {
        //TODO:
        System.out.println("1-file\n2-console");
        System.out.println("1.\tВ каждом слове k-ю букву заменить заданным символом. " +
                "Если k больше длины слова, корректировку не выполнять.\n");
        String task1 = controller.executeTask(task1());
        System.out.println(task1);
    }

    List<String> task1() {
        List<String> list = new ArrayList<>();
        list.add("task1");
        System.out.println("1-console\n2-file");
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
