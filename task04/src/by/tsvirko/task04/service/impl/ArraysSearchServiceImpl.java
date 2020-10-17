package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.service.ArraySearchService;

import java.util.stream.IntStream;

public class ArraysSearchServiceImpl implements ArraySearchService {
    /**
     * Finds maximum value in given array
     *
     * @param wrapper
     * @return max
     */
    @Override
    public int findMax(ArraysWrapper wrapper) throws ArrayException {
        Array array = (Array) wrapper;
        int max = 0;
        for (int i = 0; i < array.getLength(); i++) {
            int element = array.getElement(i);
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Finds minimum value in given array
     *
     * @param wrapper
     * @return min
     */
    @Override
    public int findMin(ArraysWrapper wrapper) throws ArrayException {
        Array array = (Array) wrapper;
        int min = array.getElement(0);
        for (int i = 0; i < array.getLength(); i++) {
            int element = array.getElement(i);
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    @Override
    public int findElementIndex(ArraysWrapper wrapper, int element) {
        Array array = (Array) wrapper;
        return IntStream.range(0, array.getLength())
                .filter(i -> {
                    try {
                        return element == array.getElement(i);
                    } catch (ArrayException e) {
                        return false;
                    }
                })
                .findFirst()
                .orElse(-1);
    }
}
