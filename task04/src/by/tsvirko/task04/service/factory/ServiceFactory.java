package by.tsvirko.task04.service.factory;

import by.tsvirko.task04.service.ArrayBinarySearchService;
import by.tsvirko.task04.service.ArrayFibonacciService;
import by.tsvirko.task04.service.ArrayPrimeNumberService;
import by.tsvirko.task04.service.SortArrayService;
import by.tsvirko.task04.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ArrayBinarySearchService arrayBinarySearchService = new ArrayBinarySearchService();
    private final SortArrayService sortArrayService = new SortArrayServiceImpl();
    private final ArrayPrimeNumberService primeNumberService = new ArrayPrimeNumberService();
    private final ArrayFibonacciService fibonacciService = new ArrayFibonacciService();

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
}
