package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.JaggedArray;

import java.util.Scanner;

public class JaggedArraysInitImpl implements ArraysInitService {
    private final int MAX_SIZE_ARRAY = 4;

    public JaggedArraysInitImpl() {
    }

    @Override
    public JaggedArray init(Scanner scanner, int size) {
        ArraysInitServiceImpl service = new ArraysInitServiceImpl();
        int[][] newArr = new int[size][];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter number of elements: ");
            int arrSize = scanner.nextInt();
            Array init = service.init(scanner, arrSize);
            newArr[i] = init.getArray();
        }
        return new JaggedArray(newArr);
    }

    @Override
    public JaggedArray init(String filename) {
        FileReading reading = new FileJaggedArrayReading(filename);
        return (JaggedArray) reading.readArray();
    }

    @Override
    public JaggedArray init() {
        int[][] array = new int[MAX_SIZE_ARRAY][];
        for (int i = 0; i < array.length; i++) {
            int[] ints = new int[(int) (Math.random() * MAX_SIZE_ARRAY) + 1];
            for (int i1 = 0; i1 < ints.length; i1++) {
                ints[i1] = (int) (Math.random() * MAX_SIZE_ARRAY) + 1;
            }
            array[i] = ints;
        }
        return new JaggedArray(array);
    }
}
