package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;
import by.tsvirko.task04.service.ArraysInitService;
import by.tsvirko.task04.service.ArraysInitServiceImpl;
import by.tsvirko.task04.service.JaggedArraysInitImpl;

import java.util.Scanner;


public class ArraysController {
    private ArraysInitService arraysInitService;
    private ArraysWrapper arraysWrapper;

    public ArraysController() {
    }

    public ArraysController(int serviceNum) {
        arraysInitService = servicesFactory(serviceNum);
    }

    public ArraysInitService servicesFactory(int num) {
        ArraysInitService service;
        switch (num) {
            case 1:
                service = new ArraysInitServiceImpl();
                break;
            case 2:
                service = new JaggedArraysInitImpl();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }
        return service;
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
}
