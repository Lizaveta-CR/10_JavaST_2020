package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;

public interface JaggedArraysSortService {
    void sortAscSumLines(ArraysWrapper arraysWrapper) throws ArrayException;

    void sortDescSumLines(ArraysWrapper arraysWrapper) throws ArrayException;

    void sortAscMaxLines(ArraysWrapper arraysWrapper) throws ArrayException;

    void sortDescMaxLines(ArraysWrapper arraysWrapper) throws ArrayException;

    void sortAscMinLines(ArraysWrapper arraysWrapper) throws ArrayException;

    void sortDescMinLines(ArraysWrapper arraysWrapper) throws ArrayException;
}
