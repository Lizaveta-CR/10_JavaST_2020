package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysWrapperController;
import by.tsvirko.task04.entity.ArraysWrapper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FillArraysView {
    private ArraysWrapperController arraysController;
    private Scanner scanner;

    public FillArraysView(ArraysWrapperController controller) {
        scanner = new Scanner(System.in);
        arraysController = controller;
    }


    public ArraysWrapper fillArray() {
        try {
            System.out.println("How do you want to initialize array?\n"
                    + "1-console\n"
                    + "2-file\n"
                    + "3-random");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    return fillArrayConsoleView();
                case 2:
                    return fillArrayFileView();
                default:
                    return fillArrayRandomView();
            }
        } catch (InputMismatchException | IllegalStateException e) {
            System.err.println("try again...");
        }
        return null;
    }

    private ArraysWrapper fillArrayConsoleView() throws InputMismatchException {
        System.out.println("Enter number of elements: ");
        int size = scanner.nextInt();
        ArraysWrapper arraysWrapper = arraysController.fillArrayConsole(scanner, size);
        System.out.println(arraysWrapper);
        return arraysWrapper;
    }

    private ArraysWrapper fillArrayFileView() throws InputMismatchException {
        System.out.println("Enter file name: ");
        String fileName = scanner.next();
        ArraysWrapper arraysWrapper = arraysController.fillArrayFile(fileName);
        System.out.println(arraysWrapper);
        return arraysWrapper;
    }

    private ArraysWrapper fillArrayRandomView() throws InputMismatchException {
        System.out.println("Random initialization...");
        ArraysWrapper arraysWrapper = arraysController.fillArrayRandom();
        System.out.println(arraysWrapper);
        return arraysWrapper;
    }

    public List<ArraysWrapper> fillSeveralArrays(int numOfArrays) {
        List<ArraysWrapper> list = new ArrayList<>();
        for (int i = 0; i < numOfArrays; i++) {
            ArraysWrapper arraysWrapper = fillArray();
            list.add(arraysWrapper);
        }
        return list;
    }
}
