package by.tsvirko.task04.service;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public interface ArraysInitService {
    void init(Scanner scanner, int size);

    void init(String filename);

    void init();
}
