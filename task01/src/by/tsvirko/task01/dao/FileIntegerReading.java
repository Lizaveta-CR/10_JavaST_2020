package by.tsvirko.task01.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIntegerReading implements IntegerReading {
    private String filename;

    public FileIntegerReading(String filename) {
        this.filename = filename;
    }

    private Scanner openFile(final String filename) {
        try {
            return new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("File not found " + e.getMessage());
        }
        return null;
    }

    @Override
    public long readNumber() {
        Scanner scanner = openFile(filename);
        ArrayList<Integer> fileNumbers = new ArrayList<>();
        int finalNumber = 0;
        try {
            while (scanner.hasNextInt()) {
                fileNumbers.add(scanner.nextInt());
            }
            if (fileNumbers.size() > 1 || fileNumbers.isEmpty()) {
                throw new IllegalArgumentException("1 number must be in file!");
            } else {
                finalNumber = fileNumbers.get(0);
            }
        } catch (NullPointerException e) {
            System.err.println("Check file name!");
        }
        return finalNumber;
    }
}
