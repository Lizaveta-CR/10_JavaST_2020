package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;

import java.util.Scanner;

public interface ArraysInitService {
    ArraysWrapper init(Scanner scanner, int size) throws InitConsoleException;

    ArraysWrapper init(String filename) throws FileArrayException;

    ArraysWrapper init();
}
