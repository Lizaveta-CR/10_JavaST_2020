package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.service.*;
import by.tsvirko.task04.service.factory.ServiceFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ArraysOperationsController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ArraysWrapper arraysWrapper;

    public ArraysWrapper sort(int sortOption) {
        SortArrayService sortService = serviceFactory.getSortArrayService();
        try {
            switch (sortOption) {
                case 2:
                    sortService.insertionSort(arraysWrapper);
                    break;
                case 3:
                    sortService.combSort(arraysWrapper);
                    break;
                default:
                    sortService.heapSort(arraysWrapper);
            }
        } catch (ClassCastException e) {
            System.err.println("This is only for Array!! Read tasks correctly");
        }
        return arraysWrapper;
    }

    public int binarySearch(int key) {
        ArrayBinarySearchService binarySearchService = serviceFactory.getArrayBinarySearchService();
        int index = 0;
        try {
            index = binarySearchService.binarySearch(arraysWrapper, key);
        } catch (ClassCastException e) {
            System.err.println("This is only for Array!! Read tasks correctly");
        }
        return index;
    }

    public List<Integer> getPtimesInArray() {
        List<Integer> primes = new ArrayList<>();
        try {
            ArrayPrimeNumberService primeNumberService = serviceFactory.getPrimeNumberService();
            List<Integer> primeNumbersInArray = primeNumberService.findPrimeNumbersInArray(arraysWrapper);
            primes.addAll(primeNumbersInArray);
        } catch (ArrayException e) {
            System.err.println("Something is with array, check it");
        }
        return primes;
    }

    public List<Integer> getFibonacciNumInArray() {
        ArrayFibonacciService fibonacciService = serviceFactory.getFibonacciService();
        return fibonacciService.findFibNumbers(arraysWrapper);
    }

    public List<Integer> getNumbersWithThreeDifDigits() {
        List<Integer> numbers = new ArrayList<>();
        try {
            NumbersWithThreeDifferentDigitsService differentDigitsService = serviceFactory.getDifferentDigitsService();
            numbers.addAll(differentDigitsService.findNumbersWithThreeDifferentDigits(arraysWrapper));
        } catch (ParseException e) {
            System.err.println("Something is with array, check it");
        }
        return numbers;
    }

    public void setArraysWrapper(ArraysWrapper arraysWrapper) {
        this.arraysWrapper = arraysWrapper;
    }
}
