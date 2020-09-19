package by.tsvirko.task01.service.readers;
//TODO: classname convention

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIntegerReader implements IntegerReader {
    private String filename;

    public FileIntegerReader(String filename) {
        this.filename = filename;
    }

    @Override
    public int readNumber() {
        Scanner scanner = openFile(filename);
        ArrayList<Integer> fileNumbers = new ArrayList<>();
        int finalNumber = 0;
        try {
            while (scanner.hasNextInt()) {
                fileNumbers.add(scanner.nextInt());
            }
            if (fileNumbers.size() > 1 || fileNumbers.size() == 0) {
                throw new IllegalArgumentException("1 number must be in file!");
            } else {
                finalNumber = fileNumbers.get(0);
            }
        } catch (NullPointerException e) {
            System.err.println("Check file name!");
        }
        return finalNumber;
    }

    private Scanner openFile(final String filename) {
        try {
            return new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("File not found " + e.getMessage());
        }
        return null;
    }

//    private List<Integer> getNumbers(Scanner scanner) {
//        List<Integer> numbers = new ArrayList<>();
//        try {
//            while (scanner.hasNextInt()) {
//                numbers.add(scanner.nextInt());
//            }
//        } catch (NullPointerException e) {
//            System.err.println("Check file name!");
//            return null;
//        }
//        return numbers;
//    }
}
