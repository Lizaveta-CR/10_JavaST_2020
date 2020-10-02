package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysController;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysView {
    private ArraysController arraysController;
    private Scanner scanner;

    public ArraysView() {
        scanner = new Scanner(System.in);
    }

    public void fillArray() {
        try {
            chooseArray();
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
        } catch (InputMismatchException | IllegalStateException | IOException e) {
            System.err.println("try again...");
        }

    }

    private void chooseArray() throws InputMismatchException {
        System.out.println("1.Array\n2.Jagged array");
        int num = scanner.nextInt();
        arraysController = new ArraysController(num);
        arraysController.servicesFactory(num);
    }

    private void fillArrayConsoleView() throws InputMismatchException {
        System.out.println("Enter number of elements: ");
        int size = scanner.nextInt();
        arraysController.fillArrayConsole(scanner, size);
    }

    private void fillArrayFileView() throws InputMismatchException, IOException {
        System.out.println("Enter file name: ");
        String fileName = scanner.next();
        arraysController.fillArrayFile(fileName);
    }

    private void fillArrayRandomView() throws InputMismatchException {
        System.out.println("Random initialization...");
        arraysController.fillArrayRandom();
    }
}
