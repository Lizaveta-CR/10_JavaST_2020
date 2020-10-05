package by.tsvirko.task04.service.impl;


import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.service.ArraySearchService;
import by.tsvirko.task04.service.JaggedArraysSortService;

import java.util.*;

public class JaggedArraysSortServiceImpl implements JaggedArraysSortService {
    /**
     * Sorts in ascending order depending on sums of the elements of the rows of the matrix,
     * using bubble sort
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortAscSumLines(ArraysWrapper arraysWrapper) {
        JaggedArray array = (JaggedArray) arraysWrapper;
        int[][] jaggedArray = array.getJaggedArray();
        for (int row = 0; row < jaggedArray.length; row++) {
            for (int nextRow = 0; nextRow < jaggedArray.length; nextRow++) {
                if (compareSums(jaggedArray[row], jaggedArray[nextRow]) < 0) {
                    JaggedRowSwapper(jaggedArray, row, nextRow);
                }
            }
        }
        array.setJaggedArray(jaggedArray);
    }

    /**
     * Summing the array elements
     *
     * @param array
     * @return sum of elements
     */
    private int arraySum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Compares the sum of arrays elements
     *
     * @param arr1
     * @param arr2
     * @return 1, if arr1's sum>arr2's sum, -1 - arr1's sum<arr2's sum, 0 - equal
     */
    private int compareSums(int[] arr1, int[] arr2) {
        if (arraySum(arr1) > arraySum(arr2)) {
            return 1;
        } else if (arraySum(arr1) < arraySum(arr2)) {
            return -1;
        } else {
            return 0;
        }
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
     * Sorts in ascending order depending on max values in each array
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortAscMaxLines(ArraysWrapper arraysWrapper) {
        JaggedArray array = (JaggedArray) arraysWrapper;
        int[][] jaggedArray = array.getJaggedArray();
        for (int row = 0; row < jaggedArray.length; row++) {
            for (int nextRow = 0; nextRow < jaggedArray.length; nextRow++) {
                if (compareLargestValues(jaggedArray[row], jaggedArray[nextRow]) < 0) {
                    JaggedRowSwapper(jaggedArray, row, nextRow);
                }
            }
        }
        array.setJaggedArray(jaggedArray);
    }

    /**
     * Compares largest values in given arrays
     *
     * @param arrayF
     * @param arrayS
     * @return
     */
    public int compareLargestValues(int[] arrayF, int[] arrayS) {
        ArraySearchService service = new ArraysSearchServiceImpl();
        if (service.findMax(new Array(arrayF)) > service.findMax(new Array(arrayS))) {
            return 1;
        } else if (service.findMax(new Array(arrayS)) > service.findMax(new Array(arrayF))) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Sorts in descending order depending on max values in each array
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortDescMaxLines(ArraysWrapper arraysWrapper) {
        sortAscSumLines(arraysWrapper);
        reverse((JaggedArray) arraysWrapper);
    }

    /**
     * Sorts in ascending order depending on min values in each array
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortAscMinLines(ArraysWrapper arraysWrapper) {
        JaggedArray array = (JaggedArray) arraysWrapper;
        int[][] jaggedArray = array.getJaggedArray();
        for (int row = 0; row < jaggedArray.length; row++) {
            for (int nextRow = 0; nextRow < jaggedArray.length; nextRow++) {
                if (compareMinValues(jaggedArray[row], jaggedArray[nextRow]) < 0) {
                    JaggedRowSwapper(jaggedArray, row, nextRow);
                }
            }
        }
        array.setJaggedArray(jaggedArray);
    }

    /**
     * Compares minimum values in given arrays
     *
     * @param arrayF
     * @param arrayS
     * @return
     */
    private int compareMinValues(int[] arrayF, int[] arrayS) {
        ArraySearchService service = new ArraysSearchServiceImpl();
        if (service.findMin(new Array(arrayF)) > service.findMin(new Array(arrayS))) {
            return 1;
        } else if (service.findMin(new Array(arrayS)) > service.findMin(new Array(arrayF))) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Sorts in descending order depending on min values in each array
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortDescMinLines(ArraysWrapper arraysWrapper) {
        sortAscMinLines(arraysWrapper);
        reverse((JaggedArray) arraysWrapper);
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

    /**
     * Swaps jagged array's arrays
     *
     * @param jagged
     * @param rowLength
     * @param nextRowLength
     */
    private void JaggedRowSwapper(int[][] jagged, int rowLength, int nextRowLength) {
        int[] jaggedArrayRowSwap = new int[jagged[rowLength].length];

        jaggedArrayRowSwap = jagged[nextRowLength];
        jagged[nextRowLength] = jagged[rowLength];
        jagged[rowLength] = jaggedArrayRowSwap;

    }
}
