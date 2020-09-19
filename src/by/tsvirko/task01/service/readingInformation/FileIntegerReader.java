package by.tsvirko.task01.service.readingInformation;
//TODO: classname convention

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIntegerReader implements IntegerReader {
    private String filename;

    public FileIntegerReader(String filename) {
        this.filename = filename;
    }

    @Override
    public int readNumber() {
        Scanner scanner = openFile(filename);
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        if (numbers.size() > 1) {
            throw new IllegalArgumentException("Only 1 number in file!");
        }
        return numbers.get(0);
    }

    private Scanner openFile(final String filename) {
        try {
            return new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("File not found" + e.getMessage());
            return null;
        }
    }
}
