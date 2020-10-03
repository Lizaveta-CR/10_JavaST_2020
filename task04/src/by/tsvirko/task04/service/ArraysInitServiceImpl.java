package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;
import by.tsvirko.task04.exceptions.NoFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysInitServiceImpl implements ArraysInitService {
    private final int MAX_SIZE_ARRAY = 7;

    public ArraysInitServiceImpl() {
    }

    @Override
    public Array init(Scanner scanner, int size) throws InitConsoleException {
        Array array = new Array(size);
        try {
            if (size <= 0) {
                throw new InputMismatchException();
            }
            System.out.println("Enter numbers: ");
            for (int i = 0; i < size; i++) {
                array.setElement(i, scanner.nextInt());
            }
        } catch (ArrayException e) {
            throw new InitConsoleException();
        }
        return array;
    }

    @Override
    public Array init(String fileName) throws FileArrayException {
        try {
            FileReading fileArrayReading = new FileArrayReading(fileName);
            return (Array) fileArrayReading.readArray();
        } catch (ArrayException | NoFile e) {
            throw new FileArrayException();
        }
    }

    @Override
    public Array init() {
        Array array = new Array(MAX_SIZE_ARRAY);
        try {
            for (int i = 0; i < MAX_SIZE_ARRAY; i++) {
                int value = (int) (Math.random() * MAX_SIZE_ARRAY) + 1;
                array.setElement(i, value);
            }
        } catch (ArrayException e) {
        }
        return array;
    }
}
