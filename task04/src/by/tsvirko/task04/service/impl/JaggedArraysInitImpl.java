package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;
import by.tsvirko.task04.exceptions.NoFile;
import by.tsvirko.task04.service.ArraysInitService;
import by.tsvirko.task04.service.FileReading;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JaggedArraysInitImpl extends ArraysSearchServiceImpl implements ArraysInitService {
    private final int MAX_SIZE_ARRAY = 4;

    public JaggedArraysInitImpl() {
    }

    /**
     * jagged array initialization from console
     *
     * @param scanner
     * @param size
     * @return JaggedArray
     * @throws InitConsoleException
     */
    @Override
    public JaggedArray init(Scanner scanner, int size) throws InitConsoleException {
        if (size <= 0) {
            throw new InitConsoleException();
        }
        ArraysInitServiceImpl service = new ArraysInitServiceImpl();
        List<Array> newArrays = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter number of elements: ");
            int arrSize = scanner.nextInt();
            Array init = service.init(scanner, arrSize);
            newArrays.add(i, init);
        }
        return new JaggedArray(newArrays);
    }

    /**
     * jagged array initialization from file
     *
     * @param filename
     * @return JaggedArray
     * @throws FileArrayException
     */
    @Override
    public JaggedArray init(String filename) throws FileArrayException {
        try {
            FileReading reading = new FileJaggedArrayReadingImpl(filename);
            return (JaggedArray) reading.readArray();
        } catch (ArrayException | NoFile e) {
            throw new FileArrayException();
        }
    }

    /**
     * Random jagged array initialization
     *
     * @return JaggedArray
     */
    @Override
    public JaggedArray init() {
        ArraysInitServiceImpl service = new ArraysInitServiceImpl();
        List<Array> arrays = new ArrayList<>(MAX_SIZE_ARRAY);
        for (int i = 0; i < MAX_SIZE_ARRAY; i++) {
            Array init = service.init();
            arrays.add(init);
        }
        return new JaggedArray(arrays);
    }
}
