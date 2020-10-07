package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.service.*;
import by.tsvirko.task04.service.factory.ServiceFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArraysOperationsController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ArraysWrapper arraysWrapper;
    private ResourceBundle rb;

    public ArraysOperationsController() {
    }

    public ArraysOperationsController(ResourceBundle rb) {
        this.rb = rb;
    }

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
            System.err.println(rb.getString("message.error4"));
        }
        return arraysWrapper;
    }

    public int binarySearch(int key) {
        ArrayBinarySearchService binarySearchService = serviceFactory.getArrayBinarySearchService();
        int index = 0;
        try {
            index = binarySearchService.binarySearch(arraysWrapper, key);
        } catch (ClassCastException e) {
            System.err.println(rb.getString("message.error4"));
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
            System.err.println(rb.getString("message.error5"));
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
            System.err.println(rb.getString("message.error5"));
        }
        return numbers;
    }

    public void setArraysWrapper(ArraysWrapper arraysWrapper) {
        this.arraysWrapper = arraysWrapper;
    }
}
