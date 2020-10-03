package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;
import by.tsvirko.task04.service.*;

import java.util.Scanner;


public class ArraysController {
    private ArraysInitService arraysInitService;
    private ArraySearchService searchService;
    private SortArrayService sortService;
    private ArrayBinarySearchService binarySearchService;
    private ArraysWrapper arraysWrapper;

    public ArraysController() {
    }

    public ArraysController(int serviceNum) {
        servicesFactory(serviceNum);
        sortService = new SortArrayServiceImpl();
        binarySearchService = new ArrayBinarySearchService();
    }

    public void servicesFactory(int num) {
        switch (num) {
            case 1:
                this.arraysInitService = new ArraysInitServiceImpl();
                this.searchService = new ArraysSearchServiceImpl();
                break;
            case 2:
                this.arraysInitService = new JaggedArraysInitImpl();
                this.searchService = new JaggedArraysSearchServiceImpl();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }
    }

    public ArraysWrapper fillArrayConsole(Scanner scanner, int size) {
        try {
            arraysWrapper = arraysInitService.init(scanner, size);
        } catch (InitConsoleException e) {
            System.err.println("Error while initializing file");
        }
        return arraysWrapper;
    }

    public ArraysWrapper fillArrayFile(String fileName) {
        try {
            arraysWrapper = arraysInitService.init(fileName);
        } catch (FileArrayException e) {
            System.err.println("Check your array and file!");
        }
        return arraysWrapper;
    }

    public ArraysWrapper fillArrayRandom() {
        arraysWrapper = arraysInitService.init();
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
        try {
            switch (sortOption) {
                case 1:
                    sortService.heapSort(arraysWrapper);
                case 2:
                    sortService.insertionSort(arraysWrapper);
                case 3:
                    sortService.combSort(arraysWrapper);
            }
        } catch (ClassCastException e) {
            System.err.println("This is only for Array!! Read tasks correctly");
        }
        return arraysWrapper;
    }

    public int binarySearch(int key) {
        int index = 0;
        try {
            index = binarySearchService.binarySearch(arraysWrapper, key);
        } catch (ClassCastException e) {
            System.err.println("This is only for Array!! Read tasks correctly");
        }
        return index;
    }
}
