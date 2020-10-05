package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;

public interface JaggedArraysSortService {
    void sortAscSumLines(ArraysWrapper arraysWrapper);

    void sortDescSumLines(ArraysWrapper arraysWrapper);

    void sortAscMaxLines(ArraysWrapper arraysWrapper);

    void sortDescMaxLines(ArraysWrapper arraysWrapper);

    void sortAscMinLines(ArraysWrapper arraysWrapper);

    void sortDescMinLines(ArraysWrapper arraysWrapper);
}
