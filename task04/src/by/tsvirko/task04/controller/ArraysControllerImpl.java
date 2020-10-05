package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;
import by.tsvirko.task04.service.*;
import by.tsvirko.task04.service.impl.ArraysInitServiceImpl;
import by.tsvirko.task04.service.impl.ArraysSearchServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ArraysControllerImpl implements ArraysWrapperController {
    private ArraysInitService arraysInitService = new ArraysInitServiceImpl();
    private ArraySearchService searchService = new ArraysSearchServiceImpl();
    private static ArraysWrapper arraysWrapper;
    private ArraysOperationsController arraysOperationsController = new ArraysOperationsController();


    @Override
    public ArraysWrapper fillArrayConsole(Scanner scanner, int size) {
        try {
            arraysWrapper = arraysInitService.init(scanner, size);
        } catch (InitConsoleException e) {
            System.err.println("Error while initializing file");
        }
        arraysOperationsController.setArraysWrapper(arraysWrapper);
        return arraysWrapper;
    }

    @Override
    public ArraysWrapper fillArrayFile(String fileName) {
        try {
            arraysWrapper = arraysInitService.init(fileName);
        } catch (FileArrayException e) {
            System.err.println("Check your array and file!");
        }
        arraysOperationsController.setArraysWrapper(arraysWrapper);
        return arraysWrapper;
    }

    @Override
    public ArraysWrapper fillArrayRandom() {
        arraysWrapper = arraysInitService.init();
        arraysOperationsController.setArraysWrapper(arraysWrapper);
        return arraysWrapper;
    }

    public int findElementIndex(int element) {
        return arraysWrapper.findElementIndex(element);
    }

    public int findMax() {
        return searchService.findMax(arraysWrapper);
    }

    public int findMin() {
        return searchService.findMin(arraysWrapper);
    }

    public ArraysWrapper sort(int sortOption) {
        return arraysOperationsController.sort(sortOption);
    }

    public int binarySearch(int key) {
        return arraysOperationsController.binarySearch(key);
    }

    public List<Integer> getPtimesInArray() {
        return arraysOperationsController.getPtimesInArray();
    }

    public List<Integer> getFibonacciNumInArray() {
        return arraysOperationsController.getFibonacciNumInArray();
    }

    public List<Integer> getNumbersWithThreeDifDigits() {
        return arraysOperationsController.getNumbersWithThreeDifDigits();
    }
}
