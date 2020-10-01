package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;

import java.util.Random;
import java.util.Scanner;

public class ArraysInitServiceImpl implements ArraysInitService {
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
    public void init(Random random) {

    }
}
