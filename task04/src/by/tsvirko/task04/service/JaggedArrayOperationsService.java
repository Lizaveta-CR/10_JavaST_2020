package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;

import java.util.*;

public class JaggedArrayOperationsService {
    /**
     * Checks if Jagged Arrays have same dimensions
     *
     * @param wrappers - given arrays
     * @return boolean value: tru, if Jagged Arrays are of same dimensions, else - false
     */
    public boolean isSameDim(ArraysWrapper... wrappers) {
        Set<Array> dimensionsList = new HashSet<>();
        for (int i = 0; i < wrappers.length; i++) {
            int[] dimensions = getDimensions(wrappers[i]);
            Array array = new Array(dimensions);
            dimensionsList.add(array);
        }
        return dimensionsList.stream()
                .distinct()
                .count() <= 1;
    }

    /**
     * Gives dimensions of Jagged array arrays
     *
     * @param wrapper - input array
     * @return int[] - dimensions of each array
     */
    private int[] getDimensions(ArraysWrapper wrapper) {
        JaggedArray jaggedArray = (JaggedArray) wrapper;
        int[][] multiDimensionalArray = jaggedArray.getJaggedArray();
        int[] arrayOfLengths = new int[multiDimensionalArray.length];
        for (int i = 0; i < multiDimensionalArray.length; i++) {
            arrayOfLengths[i] = multiDimensionalArray[i].length;
        }
        return arrayOfLengths;
    }
}
