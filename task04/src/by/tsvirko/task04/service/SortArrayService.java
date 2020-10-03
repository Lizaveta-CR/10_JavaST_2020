package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;

public interface SortArrayService {
    void heapSort(ArraysWrapper arraysWrapper);

    void insertionSort(ArraysWrapper arraysWrapper);

    void combSort(ArraysWrapper arraysWrapper);
}
