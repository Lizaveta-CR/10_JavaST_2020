package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.NoFile;

public interface FileReading {
    ArraysWrapper readArray() throws NoFile, ArrayException;
}
