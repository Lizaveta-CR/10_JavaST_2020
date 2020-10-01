package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysView {
    private ArraysController arraysController;
    private Scanner scanner;

    public ArraysView() {
        arraysController = new ArraysController();
        scanner = new Scanner(System.in);
    }

    public void fillArray() {
        try {
            System.out.println("How do you want to initialize array?\n"
                    + "1-console\n"
                    + "2-file\n"
                    + "3-random");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    fillArrayConsoleView();
                    break;
                case 2:
                    fillArrayFileView();
                    break;
                default:
                    fillArrayRandomView();
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("try again...");
        }

    }

    private void fillArrayConsoleView() throws InputMismatchException {
        System.out.println("Enter number of elements: ");
        int size = scanner.nextInt();
        System.out.println("Enter numbers: ");
        arraysController.fillArrayConsole(scanner, size);
    }

    private void fillArrayFileView() throws InputMismatchException {
        System.out.println("Enter file name: ");
        String fileName = scanner.next();
        arraysController.fillArrayFile(fileName);
    }

    //TODO
    private void fillArrayRandomView() throws InputMismatchException {
        arraysController.fillArrayRandom();
    }
}
