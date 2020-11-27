package by.tsvirko.view;

import by.tsvirko.controller.Controller;
import by.tsvirko.controller.command.CommandName;

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
        System.out.println("2. SAX");
        System.out.println("3. STAX");

        switch (scanner.nextInt()) {
            case 1:
                controller.executeTask(CommandName.DOM.name()).forEach(System.out::println);
                break;
            case 2:
                controller.executeTask(CommandName.SAX.name()).forEach(System.out::println);
                break;
            case 3:
                controller.executeTask(CommandName.STAX.name()).forEach(System.out::println);
                break;
            default:
                break;
        }
    }
}
