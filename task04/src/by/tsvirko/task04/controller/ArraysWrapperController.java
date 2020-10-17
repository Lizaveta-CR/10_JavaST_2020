package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;

import java.util.Scanner;

public interface ArraysWrapperController {
    ArraysWrapper fillArrayConsole(Scanner scanner, int size);

    ArraysWrapper fillArrayFile(String fileName);

    ArraysWrapper fillArrayRandom();

    int findElementIndex(int element);

    int findMax();

    int findMin();
}
