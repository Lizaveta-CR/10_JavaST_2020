package by.tsvirko.task04.controller;

import by.tsvirko.task04.service.ArraysInitService;
import by.tsvirko.task04.service.ArraysInitServiceImpl;

import java.util.Scanner;


public class ArraysController {
    private final ArraysInitService arraysService;

    public ArraysController() {
        arraysService = new ArraysInitServiceImpl();
    }

    public void fillArrayConsole(Scanner scanner, int size) {
        arraysService.init(scanner, size);
    }

    public void fillArrayFile(String fileName) {
        arraysService.init(fileName);
    }

    public void fillArrayRandom() {
        arraysService.init();
    }
}
