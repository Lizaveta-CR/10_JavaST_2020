package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysWrapperController;
import by.tsvirko.task04.entity.ArraysWrapper;

import java.util.*;

public class FillArraysView {
    private ArraysWrapperController arraysController;
    private Scanner scanner;
    private ResourceBundle resourceBundle;

    public FillArraysView(ArraysWrapperController controller, ResourceBundle resourceBundle) {
        scanner = new Scanner(System.in);
        arraysController = controller;
        this.resourceBundle = resourceBundle;
    }


    public ArraysWrapper fillArray() {
        try {
            System.out.println(resourceBundle.getString("message.str1")
                    + "\n1 - " + resourceBundle.getString("message.str2")
                    + "\n2 - " + resourceBundle.getString("message.str3")
                    + "\n3 - " + resourceBundle.getString("message.str4"));
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
            System.err.println(resourceBundle.getString("message.tryAgain"));
        }
        return null;
    }

    private ArraysWrapper fillArrayConsoleView() throws InputMismatchException {
        System.out.println(resourceBundle.getString("message.str5"));
        int size = scanner.nextInt();
        ArraysWrapper arraysWrapper = arraysController.fillArrayConsole(scanner, size);
        System.out.println(arraysWrapper);
        return arraysWrapper;
    }

    private ArraysWrapper fillArrayFileView() throws InputMismatchException {
        System.out.println(resourceBundle.getString("message.str6"));
        String fileName = scanner.next();
        ArraysWrapper arraysWrapper = arraysController.fillArrayFile(fileName);
        System.out.println(arraysWrapper);
        return arraysWrapper;
    }

    private ArraysWrapper fillArrayRandomView() throws InputMismatchException {
        System.out.println(resourceBundle.getString("message.str7"));
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
