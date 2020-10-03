package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysView {
    private ArraysController arraysController;
    private Scanner scanner;

    public ArraysView() {
        scanner = new Scanner(System.in);
    }

    public void showTasks() {
        chooseArray();
        FillArraysView fillArraysView = new FillArraysView(arraysController);
        fillArraysView.fillArray();
        System.out.println("1.\tОсуществлять поиск элемента массива равного x. \n");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter number you want to find: ");
                int i = scanner.nextInt();
                int elementIndex = arraysController.findElementIndex(i);
                System.out.println("Index: " + elementIndex);
        }
    }

    public void chooseArray() throws InputMismatchException {
        System.out.println("1.Array\n2.Jagged array");
        int num = scanner.nextInt();
        arraysController = new ArraysController(num);
        arraysController.servicesFactory(num);
    }
}
