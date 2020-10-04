package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysWrapperController;
import by.tsvirko.task04.entity.ArraysWrapper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FillArraysView {
    private ArraysWrapperController arraysController;
    private Scanner scanner;

    public FillArraysView(ArraysWrapperController controller) {
        scanner = new Scanner(System.in);
        arraysController = controller;
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
        } catch (InputMismatchException | IllegalStateException e) {
            System.err.println("try again...");
        }

    }

    private void fillArrayConsoleView() throws InputMismatchException {
        System.out.println("Enter number of elements: ");
        int size = scanner.nextInt();
        ArraysWrapper arraysWrapper = arraysController.fillArrayConsole(scanner, size);
        System.out.println(arraysWrapper);
    }

    private void fillArrayFileView() throws InputMismatchException {
        System.out.println("Enter file name: ");
        String fileName = scanner.next();
        ArraysWrapper arraysWrapper = arraysController.fillArrayFile(fileName);
        System.out.println(arraysWrapper);
    }

    private void fillArrayRandomView() throws InputMismatchException {
        System.out.println("Random initialization...");
        ArraysWrapper arraysWrapper = arraysController.fillArrayRandom();
        System.out.println(arraysWrapper);
    }
}
