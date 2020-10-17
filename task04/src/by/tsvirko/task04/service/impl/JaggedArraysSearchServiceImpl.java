package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.service.ArraySearchService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JaggedArraysSearchServiceImpl extends ArraysSearchServiceImpl implements ArraySearchService {
    /**
     * Finds maximum value in given jagged array
     *
     * @param wrapper
     * @return min
     */
    @Override
    public int findMax(ArraysWrapper wrapper) throws ArrayException {
        JaggedArray jaggedArray = (JaggedArray) wrapper;
        List<Integer> maximums = new ArrayList<>();
        for (int i = 0; i < jaggedArray.getVerticalSize(); i++) {
            int max = super.findMax(jaggedArray.getArray(i));
            maximums.add(max);
        }
        return Collections.max(maximums);
    }

    /**
     * Finds minimum value in given jagged array
     *
     * @param wrapper
     * @return min
     */
    @Override
    public int findMin(ArraysWrapper wrapper) throws ArrayException {
        JaggedArray jaggedArray = (JaggedArray) wrapper;
        List<Integer> minimums = new ArrayList<>();
        for (int i = 0; i < jaggedArray.getVerticalSize(); i++) {
            int min = super.findMin(jaggedArray.getArray(i));
            minimums.add(min);
        }
        return Collections.min(minimums);
    }

    public int findElementIndex(ArraysWrapper wrapper, int element) {
        JaggedArray jaggedArray = (JaggedArray) wrapper;
        int index = 0;
        for (int i = 0; i < jaggedArray.getVerticalSize(); i++) {
            index = super.findElementIndex(jaggedArray.getArray(i), element);
            if (index == -1) {
                continue;
            } else {
                return index;
            }
        }
        return index;
    }
}

