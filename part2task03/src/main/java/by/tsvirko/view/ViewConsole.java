package by.tsvirko.view;

import by.tsvirko.controller.Controller;
import by.tsvirko.controller.command.CommandName;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewConsole {
    private Scanner scanner;
    private Controller controller;

    public ViewConsole() {
        this.scanner = new Scanner(System.in);
        this.controller = new Controller();
    }

    public void view() {
        System.out.println("Enter parser: ");
        System.out.println("1. DOM");

        switch (scanner.nextInt()) {
            case 1:
                controller.executeTask(CommandName.DOM.name()).forEach(System.out::println);
            default:
                break;
        }
    }
}
