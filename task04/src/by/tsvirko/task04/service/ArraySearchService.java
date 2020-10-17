package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;

public interface ArraySearchService {
    int findMax(ArraysWrapper wrapper) throws ArrayException;

    int findMin(ArraysWrapper wrapper) throws ArrayException;

    int findElementIndex(ArraysWrapper wrapper, int element);
}
