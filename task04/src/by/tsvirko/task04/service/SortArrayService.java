package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;

public interface SortArrayService {
    void heapSort(ArraysWrapper arraysWrapper) throws ArrayException;

    void insertionSort(ArraysWrapper arraysWrapper) throws ArrayException;

    void combSort(ArraysWrapper arraysWrapper) throws ArrayException;
}
