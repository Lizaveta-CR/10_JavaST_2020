package by.tsvirko.task04.service.impl;


import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.service.JaggedArraysSortService;

import java.util.*;

public class JaggedArraysSortServiceImpl implements JaggedArraysSortService {
    /**
     * Sorts in ascending order of the sums of the elements of the rows of the matrix
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortAscSumLines(ArraysWrapper arraysWrapper) {
        JaggedArray array = (JaggedArray) arraysWrapper;
        List<Array> arrayList = array.getArrayList();
        Map<Integer, Array> map = arraysSum(arrayList);
        arrayList.clear();
        for (Map.Entry<Integer, Array> entry : map.entrySet()) {
            Array value = entry.getValue();
            arrayList.add(value);
        }
        array.setArrayList(arrayList);
    }

    /**
     * Sorts in descending order of the sums of the elements of the rows of the matrix
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortDescSumLines(ArraysWrapper arraysWrapper) {
        sortAscSumLines(arraysWrapper);
        reverse((JaggedArray) arraysWrapper);
    }

    /**
     * Summing the array elements in each array
     *
     * @param arrayList - list of Arrays in Jagged Array
     * @return Map<Integer, Array> - integer - sum, Array - given array
     */
    private Map<Integer, Array> arraysSum(List<Array> arrayList) {
        Map<Integer, Array> map = new HashMap<>();
        for (Array array : arrayList) {
            int[] arr = array.getArray();
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            map.put(sum, array);
        }
        return new TreeMap<>(map);
    }

    /**
     * Reverses rows of jagged array
     *
     * @param array
     */
    private void reverse(JaggedArray array) {
        List<Array> arrayList = array.getArrayList();
        Collections.reverse(arrayList);
        array.setArrayList(arrayList);
    }
}
