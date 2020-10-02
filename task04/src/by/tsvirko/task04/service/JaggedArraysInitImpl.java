package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.JaggedArray;

import java.util.Scanner;

public class JaggedArraysInitImpl implements ArraysInitService {

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
        JaggedArray jaggedArray = new JaggedArray(newArr);
        System.out.println(jaggedArray);
        return jaggedArray;
    }

    @Override
    public void init(String filename) {

    }

    @Override
    public void init() {

    }
}
