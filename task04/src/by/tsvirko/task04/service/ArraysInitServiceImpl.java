package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysInitServiceImpl implements ArraysInitService {
    private final int MAX_SIZE_ARRAY = 7;

    public ArraysInitServiceImpl() {
    }

    @Override
    public Array init(Scanner scanner, int size) {
        if (size <= 0) {
            throw new InputMismatchException();
        }
        int[] array = new int[size];
        System.out.println("Enter numbers: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return new Array(array);
    }

    @Override
    public Array init(String fileName) {
        FileReading fileArrayReading = new FileArrayReading(fileName);
        return (Array) fileArrayReading.readArray();
    }

    @Override
    public Array init() {
        int[] array = new int[MAX_SIZE_ARRAY];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * MAX_SIZE_ARRAY) + 1;
        }
        return new Array(array);
    }
}
