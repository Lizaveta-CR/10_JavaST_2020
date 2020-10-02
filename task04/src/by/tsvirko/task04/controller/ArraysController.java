package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.service.ArraysInitService;
import by.tsvirko.task04.service.ArraysInitServiceImpl;
import by.tsvirko.task04.service.JaggedArraysInitImpl;

import java.io.IOException;
import java.util.Scanner;


public class ArraysController {
    private ArraysInitService arraysService;

    public ArraysController() {
    }

    public ArraysController(int serviceNum) {
        arraysService = servicesFactory(serviceNum);
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

    public void fillArrayConsole(Scanner scanner, int size) {
        arraysService.init(scanner, size);
    }

    public void fillArrayFile(String fileName) throws IOException {
        ArraysWrapper init = arraysService.init(fileName);
    }

    public void fillArrayRandom() {
        arraysService.init();
    }
}
