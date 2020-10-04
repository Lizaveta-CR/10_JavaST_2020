package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;
import by.tsvirko.task04.service.ArraySearchService;
import by.tsvirko.task04.service.ArraysInitService;
import by.tsvirko.task04.service.factory.ServiceFactory;
import by.tsvirko.task04.service.impl.ArraysInitServiceImpl;
import by.tsvirko.task04.service.impl.ArraysSearchServiceImpl;
import by.tsvirko.task04.service.impl.JaggedArraysInitImpl;
import by.tsvirko.task04.service.impl.JaggedArraysSearchServiceImpl;

import java.util.Scanner;

public class JaggedArraysController implements ArraysWrapperController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ArraysInitService arraysInitService = new JaggedArraysInitImpl();
    private ArraySearchService searchService = new JaggedArraysSearchServiceImpl();
    private static ArraysWrapper arraysWrapper;
    private JaggedOperationsController arraysOperationsController = new JaggedOperationsController();


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
}
