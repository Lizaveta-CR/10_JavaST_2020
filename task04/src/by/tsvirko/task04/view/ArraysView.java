package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysControllerImpl;
import by.tsvirko.task04.controller.ArraysFactoryController;
import by.tsvirko.task04.controller.ArraysWrapperController;
import by.tsvirko.task04.controller.JaggedArraysControllerImpl;
import by.tsvirko.task04.entity.ArraysWrapper;

import java.io.IOException;
import java.util.*;

public class ArraysView {
    private ArraysFactoryController arraysFactoryController;
    private ArraysControllerImpl arraysController = new ArraysControllerImpl();
    private JaggedArraysControllerImpl jaggedArraysController = new JaggedArraysControllerImpl();
    private ArraysWrapperController arraysWrapperController;
    private FillArraysView fillArraysView;
    private Scanner scanner;
    private ResourceBundle resourceBundle;

    public ArraysView() {
        scanner = new Scanner(System.in);
    }

    public void chooseLocale() {
        System.out.println("1 - english\n 2 - русский");
        char i = 0;
        try {
            i = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country = "";
        String language = "";
        switch (i) {
            case '1':
                country = "US";
                language = "EN";
                break;
            case '2':
                country = "RU";
                language = "RU";
                break;
        }
        resourceBundle = ResourceBundle.getBundle("property.messages", new Locale(language, country));
        arraysFactoryController = new ArraysFactoryController(resourceBundle);
    }

    public void showTasks() {

        try {
            chooseLocale();
            chooseArray();
            System.out.println(resourceBundle.getString("message.task1")
                    + resourceBundle.getString("message.task2")
                    + resourceBundle.getString("message.task3")
                    + resourceBundle.getString("message.task4")
                    + resourceBundle.getString("message.task5")
                    + resourceBundle.getString("message.task6")
                    + resourceBundle.getString("message.task7")
                    + resourceBundle.getString("message.task8")
                    + resourceBundle.getString("message.task9")
                    + resourceBundle.getString("message.task91")
                    + resourceBundle.getString("message.task92")
                    + resourceBundle.getString("message.task10")
                    + resourceBundle.getString("message.task11")
                    + resourceBundle.getString("message.task12")
                    + resourceBundle.getString("message.task131")
                    + resourceBundle.getString("message.task132")
                    + resourceBundle.getString("message.task133"))
            ;
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println(resourceBundle.getString("message.str8"));
                    int i = scanner.nextInt();
                    int elementIndex = arraysWrapperController.findElementIndex(i);
                    System.out.println(resourceBundle.getString("message.str9") + elementIndex);
                    break;
                case 2:
                    int max = arraysWrapperController.findMax();
                    System.out.println(resourceBundle.getString("message.str10") + max);
                    break;
                case 3:
                    int min = arraysWrapperController.findMin();
                    System.out.println(resourceBundle.getString("message.str11") + min);
                    break;
                case 4:
                    int method = chooseSortMethod();
                    ArraysWrapper array = arraysController.sort(method);
                    System.out.println(array);
                    break;
                case 5:
                    System.out.println(resourceBundle.getString("message.str12"));
                    int key = scanner.nextInt();
                    int index = arraysController.binarySearch(key);
                    System.out.println(resourceBundle.getString("message.str9") + index);
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
                    System.out.println(resourceBundle.getString("message.str13") + sameDim);
                    severalArraysView.forEach(arr -> System.out.println(resourceBundle.getString("message.str14") + jaggedArraysController.isSquare(arr)));
                    break;
                case 10:
                    List<ArraysWrapper> list = sumDifView();
                    System.out.println(resourceBundle.getString("message.str15") + "\n" + jaggedArraysController.getDif(list.get(0), list.get(1)));
                    System.out.println(resourceBundle.getString("message.str16") + "\n" + jaggedArraysController.getSum(list.get(0), list.get(1)));
                    break;
                case 11:
                    ArraysWrapper arraysWrapper = fillArraysView.fillArray();
                    System.out.println(resourceBundle.getString("message.str18") + "\n" + jaggedArraysController.getTranspose(arraysWrapper));
                    break;
                case 12:
                    ArraysWrapper arrMult = fillArraysView.fillArray();
                    System.out.println(resourceBundle.getString("message.str17") + "\n");
                    int constNum = scanner.nextInt();
                    jaggedArraysController.multiplyConst(arrMult, constNum);
                    System.out.println(arrMult);
                    break;
                case 13:
                    ArraysWrapper arr = fillArraysView.fillArray();
                    System.out.println(resourceBundle.getString("message.task131") + "\n");
                    jaggedArraysController.sortAscSumms(arr);
                    System.out.println(arr);
                    System.out.println("===");
                    jaggedArraysController.sortDescSumms(arr);
                    System.out.println(arr);
                    System.out.println(resourceBundle.getString("message.task132") + "\n");
                    jaggedArraysController.sortAscMax(arr);
                    System.out.println(arr);
                    System.out.println("===");
                    jaggedArraysController.sortDescMax(arr);
                    System.out.println(arr);
                    System.out.println(resourceBundle.getString("message.task133") + "\n");
                    jaggedArraysController.sortAscMin(arr);
                    System.out.println(arr);
                    System.out.println("===");
                    jaggedArraysController.sortDescMin(arr);
                    System.out.println(arr);
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println(resourceBundle.getString("message.tryAgain"));
        }

    }

    private List<ArraysWrapper> createSeveralArraysView() {
        System.out.println(resourceBundle.getString("message.str19"));
        int numOfArrays = scanner.nextInt();
        return fillArraysView.fillSeveralArrays(numOfArrays);
    }

    public void chooseArray() {
        System.out.println("1.Array\n2.Jagged array");
        int num = scanner.nextInt();
        arraysWrapperController = arraysFactoryController.controllerFactory(num);
        fillArraysView = new FillArraysView(arraysWrapperController, resourceBundle);
        fillArraysView.fillArray();
    }

    private int chooseSortMethod() {
        System.out.println("1-HeapSort\n2-InsertionSort\n3-CombSort");
        return scanner.nextInt();
    }

    public List<ArraysWrapper> sumDifView() {
        System.out.println(resourceBundle.getString("message.str20"));
        return fillArraysView.fillSeveralArrays(2);
    }
}
