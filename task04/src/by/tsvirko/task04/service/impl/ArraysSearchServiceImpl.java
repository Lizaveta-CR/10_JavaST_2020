package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
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
    public int findMax(ArraysWrapper wrapper) {
        Array array = (Array) wrapper;
        int[] arr = array.getArray();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
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
    public int findMin(ArraysWrapper wrapper) {
        Array array = (Array) wrapper;
        int[] arr = array.getArray();
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    @Override
    public int findElementIndex(ArraysWrapper wrapper, int element) {
        Array array = (Array) wrapper;
        return IntStream.range(0, array.getLength())
                .filter(i -> element == array.getArray()[i])
                .findFirst()
                .orElse(-1);
    }
}
