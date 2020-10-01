package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileArrayReading {
    private String filename;
    private final String FILE_PATH = "task04/resources/";
    private final String FILE_EXT = ".txt";

    public FileArrayReading(String filename) {
        this.filename = FILE_PATH.concat(filename).concat(FILE_EXT);
    }

    private Scanner openFile(final String filename) {
        try {
            return new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("File not found " + e.getMessage());
        }
        return null;
    }

    public Array readArray() {
        Scanner scanner = openFile(filename);
        ArrayList<Integer> fileNumbers = new ArrayList<>();
        try {
            while (scanner.hasNextInt()) {
                fileNumbers.add(scanner.nextInt());
            }
        } catch (NullPointerException e) {
            System.err.println("Check file name!");
        }
        int[] ints = new int[fileNumbers.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = fileNumbers.get(i);
        }
        return new Array(ints);
    }
}
