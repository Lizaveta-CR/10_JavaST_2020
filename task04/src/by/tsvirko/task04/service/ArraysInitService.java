package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;

import java.io.IOException;
import java.util.Scanner;

public interface ArraysInitService {
    ArraysWrapper init(Scanner scanner, int size);

    ArraysWrapper init(String filename) throws IOException;

    void init();
}
