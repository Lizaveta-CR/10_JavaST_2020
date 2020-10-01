package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;

import java.util.Scanner;

public class ArraysInitServiceImpl implements ArraysInitService {
    private final int MAX_SIZE_ARRAY = 7;

    public ArraysInitServiceImpl() {
    }

    @Override
    public void init(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        Array newArray = new Array(array);
    }

    @Override
    public void init(String fileName) {
        FileArrayReading fileArrayReading = new FileArrayReading(fileName);
        fileArrayReading.readArray();
    }

    @Override
    public void init() {
        int[] array = new int[MAX_SIZE_ARRAY];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * MAX_SIZE_ARRAY) + 1;
        }
    }
}
