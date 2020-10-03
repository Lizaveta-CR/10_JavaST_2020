package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.NoFile;
import by.tsvirko.task04.service.FileReading;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileArrayReadingImpl implements FileReading {
    private String filename;
    private final String FILE_PATH = "/Users/elizaveta/Downloads/10_JavaST_2020/task04/resources/";
    private final String FILE_EXT = ".txt";

    public FileArrayReadingImpl(String filename) {
        this.filename = FILE_PATH.concat(filename).concat(FILE_EXT);
    }

    private Scanner openFile(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename));
    }

    public Array readArray() throws NoFile, ArrayException {
        try {
            Scanner scanner = openFile(filename);
            ArrayList<Integer> fileNumbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                fileNumbers.add(scanner.nextInt());
            }
            int size = fileNumbers.size();
            Array array = new Array(size);
            for (int i = 0; i < size; i++) {
                int value = fileNumbers.get(i);
                array.setElement(i, value);
            }
            return array;
        } catch (FileNotFoundException e) {
            throw new NoFile();
        } catch (ArrayException e) {
            throw new ArrayException();
        }
    }
}
