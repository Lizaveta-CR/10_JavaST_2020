package by.tsvirko.task04.view;

import by.tsvirko.task04.controller.ArraysControllerImpl;
import by.tsvirko.task04.controller.ArraysFactoryController;
import by.tsvirko.task04.controller.ArraysWrapperController;
import by.tsvirko.task04.controller.JaggedArraysControllerImpl;
import by.tsvirko.task04.entity.ArraysWrapper;

import java.io.IOException;
import java.util.*;

public class ArraysView {
    private ArraysFactoryController arraysFactoryController = new ArraysFactoryController();
    private ArraysControllerImpl arraysController = new ArraysControllerImpl();
    private JaggedArraysControllerImpl jaggedArraysController = new JaggedArraysControllerImpl();
    private ArraysWrapperController arraysWrapperController;
    private FillArraysView fillArraysView;
    private Scanner scanner;
    private ResourceBundle resourceBundle;

    public ArraysView() {
//        locale = Locale.getDefault();
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
        resourceBundle = ResourceBundle.getBundle("messages", new Locale(language, country));
    }

    public void showTasks() {

        try {
            chooseArray();
            System.out.println("" +
//                    "0. Выберете язык\n " +
                    "1.\tОсуществлять поиск элемента массива равного x. \n"
                    + "2.\tНаходить максимальный; 3. минимальный элементы массива.\n"
                    + "4.\tСортировать массив типа Array тремя способами\n"
                    + "5. Осуществлять бинарный поиск элемента массива типа Array\n"
                    + "6. Получить все простые числа, находящиеся в массиве типа Array.\n"
                    + "7. Получить все числа Фибонначчи, находящиеся в массиве типа Array\n"
                    + "8.\tПолучить все трехзначные числа, в десятичной записи которых нет одинаковых цифр " +
                    "в массиве типа Array.\n"
                    + "9. Выполнить операции над объектами типа JaggedArray:\n" +
                    "9.1 сравнения размерностей\n"
                    + "9.2 проверки является ли массив квадратной матрицей\n"
                    + "10.\tсложения,вычитания\n" +
                    "11.транспонирование\n"
                    + "12.умножение на константу"
                    + "13.в порядке возрастания (убывания) сумм элементов строк матрицы;\n" +
                    "в порядке возрастания (убывания) максимальных элементов строк матрицы;\n" +
                    "в порядке возрастания (убывания) минимальных элементов строк матрицы.\n")
            ;
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    chooseLocale();
                    break;
                case 1:
                    System.out.println("message.str1 ");
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
                case 10:
                    List<ArraysWrapper> list = sumDifView();
                    System.out.println("Subtraction= " + jaggedArraysController.getDif(list.get(0), list.get(1)));
                    System.out.println("Sum= " + jaggedArraysController.getSum(list.get(0), list.get(1)));
                    break;
                case 11:
                    ArraysWrapper arraysWrapper = fillArraysView.fillArray();
                    System.out.println("Transposed: " + jaggedArraysController.getTranspose(arraysWrapper));
                    break;
                case 12:
                    ArraysWrapper arrMult = fillArraysView.fillArray();
                    System.out.println("Enter const: ");
                    int constNum = scanner.nextInt();
                    jaggedArraysController.multiplyConst(arrMult, constNum);
                    System.out.println(arrMult);
                    break;
                case 13:
                    ArraysWrapper arr = fillArraysView.fillArray();
                    System.out.println("в порядке возрастания (убывания) сумм элементов строк матрицы:");
                    jaggedArraysController.sortAscSumms(arr);
                    System.out.println(arr);
                    System.out.println("===");
                    jaggedArraysController.sortDescSumms(arr);
                    System.out.println(arr);
                    System.out.println("в порядке возрастания (убывания) максимальных элементов строк матрицы");
                    jaggedArraysController.sortAscMax(arr);
                    System.out.println(arr);
                    System.out.println("===");
                    jaggedArraysController.sortDescMax(arr);
                    System.out.println(arr);
                    System.out.println("в порядке возрастания (убывания) минимальных элементов строк матрицы");
                    jaggedArraysController.sortAscMin(arr);
                    System.out.println(arr);
                    System.out.println("===");
                    jaggedArraysController.sortDescMin(arr);
                    System.out.println(arr);
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

    public List<ArraysWrapper> sumDifView() {
        System.out.println("Let's create two arrays:");
        return fillArraysView.fillSeveralArrays(2);
    }
}
