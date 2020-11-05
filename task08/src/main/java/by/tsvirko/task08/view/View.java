package by.tsvirko.task08.view;

import by.tsvirko.task08.controller.command.CommandName;
import by.tsvirko.task08.controller.ControllerLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private ControllerLayer controller = new ControllerLayer();
    private Scanner scanner = new Scanner(System.in);

    public void tasks() {
        System.out.println("1. First");
        switch (scanner.nextInt()) {
            case 1:
                List<String> task = new ArrayList<>();
                task.add(CommandName.FIRST.toString());
                System.out.println("Enter matrix file name: ");
                task.add(scanner.next());
                System.out.println("Enter n1: ");
                task.add(scanner.next());
                System.out.println("Enter n2: ");
                task.add(scanner.next());
                System.out.println("Enter threads' numbers file name: ");
                task.add(scanner.next());
                System.out.println("Enter m1: ");
                task.add(scanner.next());
                System.out.println("Enter m2: ");
                task.add(scanner.next());
                controller.executeTask(task);
        }
    }
}

