package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysController;
import by.tsvirko.task04.entity.ArraysWrapper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysView {
    private ArraysController arraysController;
    private Scanner scanner;

    public ArraysView() {
        scanner = new Scanner(System.in);
    }

    public void showTasks() {
        try {
            chooseArray();
            FillArraysView fillArraysView = new FillArraysView(arraysController);
            fillArraysView.fillArray();
            System.out.println("1.\tОсуществлять поиск элемента массива равного x. \n"
                    + "2.\tНаходить максимальный; 3. минимальный элементы массива.\n"
                    + "4.\tСортировать массив типа Array тремя способами (выберите любые 3 алгоритма сортировки," +
                    " которые вы ранее еще не реализовывали).\n"
                    + "5. Осуществлять бинарный поиск элемента массива типа Array");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter number you want to find: ");
                    int i = scanner.nextInt();
                    int elementIndex = arraysController.findElementIndex(i);
                    System.out.println("Index: " + elementIndex);
                case 2:
                    int max = arraysController.findMax();
                    System.out.println("Max =" + max);
                case 3:
                    int min = arraysController.findMin();
                    System.out.println("Min =" + min);
                case 4:
                    int method = chooseSortMethod();
                    ArraysWrapper array = arraysController.sort(method);
                    System.out.println(array);
                case 5:
                    System.out.println("Enter key: ");
                    int key = scanner.nextInt();
                    int index = arraysController.binarySearch(key);
                    System.out.println("Index= " + index);
            }
        } catch (InputMismatchException e) {
            System.err.println("Try again...");
        }

    }

    public void chooseArray() {
        System.out.println("1.Array\n2.Jagged array");
        int num = scanner.nextInt();
        arraysController = new ArraysController(num);
        arraysController.servicesFactory(num);
    }

    private int chooseSortMethod() {
        System.out.println("1-HeapSort\n2-InsertionSort\n3-CombSort");
        return scanner.nextInt();
    }
}
