package by.tsvirko.task04.service.factory;

import by.tsvirko.task04.service.*;
import by.tsvirko.task04.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ArraysInitService arraysInitService = new ArraysInitServiceImpl();
    private final ArraysInitService jagArraysInitService = new JaggedArraysInitImpl();
    private final ArrayBinarySearchService arrayBinarySearchService = new ArrayBinarySearchService();
    private final SortArrayService sortArrayService = new SortArrayServiceImpl();
    private final ArrayPrimeNumberService primeNumberService = new ArrayPrimeNumberService();
    private final ArrayFibonacciService fibonacciService = new ArrayFibonacciService();
    private final NumbersWithThreeDifferentDigitsService differentDigitsService = new NumbersWithThreeDifferentDigitsService();
    private final JaggedArrayOperationsService jaggedArrayOperationsService = new JaggedArrayOperationsService();
    private final JaggedArraysSortService jaggedArraysSortService = new JaggedArraysSortServiceImpl();
    private final ArraySearchService jagArraySearchService = new JaggedArraysSearchServiceImpl();
    private final ArraySearchService arraySearchService = new ArraysSearchServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ArrayBinarySearchService getArrayBinarySearchService() {
        return arrayBinarySearchService;
    }

    public SortArrayService getSortArrayService() {
        return sortArrayService;
    }

    public ArrayPrimeNumberService getPrimeNumberService() {
        return primeNumberService;
    }

    public ArrayFibonacciService getFibonacciService() {
        return fibonacciService;
    }

    public NumbersWithThreeDifferentDigitsService getDifferentDigitsService() {
        return differentDigitsService;
    }

    public JaggedArrayOperationsService getJaggedArrayOperationsService() {
        return jaggedArrayOperationsService;
    }

    public ArraysInitService getArraysInitService() {
        return arraysInitService;
    }

    public ArraysInitService getJagArraysInitService() {
        return jagArraysInitService;
    }

    public JaggedArraysSortService getJaggedArraysSortService() {
        return jaggedArraysSortService;
    }

    public ArraySearchService getJagArraySearchService() {
        return jagArraySearchService;
    }

    public ArraySearchService getArraySearchService() {
        return arraySearchService;
    }
}
