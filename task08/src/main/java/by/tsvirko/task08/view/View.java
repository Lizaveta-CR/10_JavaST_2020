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
        System.out.println("3. Third");
        System.out.println("4. Fourth");
        switch (scanner.nextInt()) {
            case 1:
                List<String> taskFirst = new ArrayList<>();
                taskFirst.add(CommandName.FIRST.toString());
                List<String> stringsFirst = informationEntering();
                taskFirst.addAll(stringsFirst);
                System.out.println(controller.executeTask(taskFirst));
                break;
            case 3:
                List<String> taskThird = new ArrayList<>();
                taskThird.add(CommandName.THIRD.toString());
                List<String> strings = informationEntering();
                taskThird.addAll(strings);
                System.out.println(controller.executeTask(taskThird));
                break;
            case 4:
                List<String> taskFour = new ArrayList<>();
                taskFour.add(CommandName.FOURTH.toString());
                List<String> strFour = informationEntering();
                taskFour.addAll(strFour);
                System.out.println(controller.executeTask(taskFour));
                break;
        }
    }

    private List<String> informationEntering() {
        List<String> task = new ArrayList<>();
        System.out.println("Enter matrix file name: ");
        task.add(scanner.next());
        System.out.println("Enter n: ");
        task.add(scanner.next());
        System.out.println("Enter threads' numbers file name: ");
        task.add(scanner.next());
        System.out.println("Enter m: ");
        task.add(scanner.next());
        return task;
    }
}

