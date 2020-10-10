package main.java.by.tsvirko.view;

import main.java.by.tsvirko.controller.Controller;

public class View {
    private Controller controller = new Controller();

    public void tasks() {
        String task1 = controller.executeTask("");
        String task2 = controller.executeTask("task2");
        System.out.println(task1);
        System.out.println(task2);
    }
}
