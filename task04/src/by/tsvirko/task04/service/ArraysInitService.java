package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;

import java.util.Scanner;

public interface ArraysInitService {
    ArraysWrapper init(Scanner scanner, int size);

    void init(String filename);

    void init();
}
