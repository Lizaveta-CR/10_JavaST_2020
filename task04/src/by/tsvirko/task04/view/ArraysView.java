package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysControllerImpl;
import by.tsvirko.task04.controller.ArraysFactoryController;
import by.tsvirko.task04.controller.ArraysWrapperController;
import by.tsvirko.task04.controller.JaggedArraysControllerImpl;
import by.tsvirko.task04.entity.ArraysWrapper;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArraysView {
    private ArraysFactoryController arraysFactoryController = new ArraysFactoryController();
    private ArraysControllerImpl arraysController = new ArraysControllerImpl();
    private JaggedArraysControllerImpl jaggedArraysController = new JaggedArraysControllerImpl();
    private ArraysWrapperController arraysWrapperController;
    private FillArraysView fillArraysView;
    private Scanner scanner;

    public ArraysView() {
        scanner = new Scanner(System.in);
    }

    public void showTasks() {
        try {
            chooseArray();
            System.out.println("1.\tОсуществлять поиск элемента массива равного x. \n"
                    + "2.\tНаходить максимальный; 3. минимальный элементы массива.\n"
                    + "4.\tСортировать массив типа Array тремя способами (выберите любые 3 алгоритма сортировки," +
                    " которые вы ранее еще не реализовывали).\n"
                    + "5. Осуществлять бинарный поиск элемента массива типа Array\n"
                    + "6. Получить все простые числа, находящиеся в массиве типа Array.\n"
                    + "7. Получить все числа Фибонначчи, находящиеся в массиве типа Array\n"
                    + "8.\tПолучить все трехзначные числа, в десятичной записи которых нет одинаковых цифр " +
                    "в массиве типа Array.\n"
                    + "9. Выполнить операции над объектами типа JaggedArray:\n" +
                    "9.1 сравнения размерностей\n"
                    + "9.2 проверки является ли массив квадратной матрицей");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter number you want to find: ");
                    int i = scanner.nextInt();
                    int elementIndex = arraysWrapperController.findElementIndex(i);
                    System.out.println("Index: " + elementIndex);
                    break;
                case 2:
                    int max = arraysWrapperController.findMax();
                    System.out.println("Max =" + max);
                    break;
                case 3:
                    int min = arraysWrapperController.findMin();
                    System.out.println("Min =" + min);
                    break;
                case 4:
                    int method = chooseSortMethod();
                    ArraysWrapper array = arraysController.sort(method);
                    System.out.println(array);
                    break;
                case 5:
                    System.out.println("Enter key: ");
                    int key = scanner.nextInt();
                    int index = arraysController.binarySearch(key);
                    System.out.println("Index= " + index);
                    break;
                case 6:
                    List<Integer> ptimesInArray = arraysController.getPtimesInArray();
                    ptimesInArray.forEach(System.out::println);
                    break;
                case 7:
                    List<Integer> fibonacciNumInArray = arraysController.getFibonacciNumInArray();
                    fibonacciNumInArray.forEach(System.out::println);
                    break;
                case 8:
                    List<Integer> numbersWithThreeDifDigits = arraysController.getNumbersWithThreeDifDigits();
                    numbersWithThreeDifDigits.forEach(System.out::println);
                    break;
                case 9:
                    List<ArraysWrapper> severalArraysView = createSeveralArraysView();
                    boolean sameDim = jaggedArraysController.isSameDim(severalArraysView);
                    System.out.println("Same dim-s: " + sameDim);
                    severalArraysView.forEach(arr -> System.out.println("Square= " + jaggedArraysController.isSquare(arr)));

                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Try again...");
        }

    }

    private List<ArraysWrapper> createSeveralArraysView() {
        System.out.println("How many arrays you want to create?");
        int numOfArrays = scanner.nextInt();
        return fillArraysView.fillSeveralArrays(numOfArrays);
    }

    public void chooseArray() {
        System.out.println("1.Array\n2.Jagged array");
        int num = scanner.nextInt();
        arraysWrapperController = arraysFactoryController.controllerFactory(num);
        fillArraysView = new FillArraysView(arraysWrapperController);
        fillArraysView.fillArray();
    }

    private int chooseSortMethod() {
        System.out.println("1-HeapSort\n2-InsertionSort\n3-CombSort");
        return scanner.nextInt();
    }
}
