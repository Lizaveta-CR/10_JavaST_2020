package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;

public interface ArraySearchService {
    int findMax(ArraysWrapper wrapper);

    int findMin(ArraysWrapper wrapper);

    int findElementIndex(ArraysWrapper wrapper, int element);
}
