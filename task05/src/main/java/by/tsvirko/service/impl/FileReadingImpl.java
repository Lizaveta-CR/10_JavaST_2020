package main.java.by.tsvirko.service.impl;

import main.java.by.tsvirko.service.FileReading;
import main.java.by.tsvirko.service.exception.FileOpeningException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingImpl implements FileReading {
    private final String FILE_PATH = "task05/src/main/resources/files/";

    public FileReadingImpl() {
    }

    /**
     * Opens file for reading information
     *
     * @param filename
     * @return Scanner
     * @throws FileOpeningException
     */
    private Scanner openFile(final String filename) throws FileOpeningException {
        try {
            return new Scanner(new File(FILE_PATH.concat(filename)));
        } catch (FileNotFoundException e) {
            throw new FileOpeningException("File not found", e);
        }
    }

    /**
     * Reads all information from file
     *
     * @param fileName
     * @return String text
     * @throws FileOpeningException
     */
    @Override
    public String read(final String fileName) throws FileOpeningException {
        Scanner scanner = openFile(fileName);

        StringBuilder text = new StringBuilder();

        while (scanner.hasNext()) {
            text = text.append(scanner.next()).append(" ");
        }

        if (text == null) {
            throw new FileOpeningException("Fill your file with words!");
        }
        return text.toString();
    }
}
