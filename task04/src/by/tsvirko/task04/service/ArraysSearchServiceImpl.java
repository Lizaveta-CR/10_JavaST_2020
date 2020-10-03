package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;

public class ArraysSearchServiceImpl implements ArraySearchService {

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
}
