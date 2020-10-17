package by.tsvirko.task04.service.impl;


import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.exceptions.ArrayException;
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
    public void sortAscSumLines(ArraysWrapper arraysWrapper) throws ArrayException {
        JaggedArray array = (JaggedArray) arraysWrapper;
        for (int row = 0; row < array.getVerticalSize(); row++) {
            for (int nextRow = 0; nextRow < array.getVerticalSize(); nextRow++) {
                if (compareSums(array.getArray(row), array.getArray(nextRow)) < 0) {
                    JaggedRowSwapper(array, row, nextRow);
                }
            }
        }
    }

    /**
     * Summing the array elements
     *
     * @param array
     * @return sum of elements
     */
    private int arraySum(Array array) throws ArrayException {
        int sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            sum += array.getElement(i);
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
    private int compareSums(Array arr1, Array arr2) throws ArrayException {
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
    public void sortDescSumLines(ArraysWrapper arraysWrapper) throws ArrayException {
        sortAscSumLines(arraysWrapper);
        reverse((JaggedArray) arraysWrapper);
    }

    /**
     * Sorts in ascending order depending on max values in each array
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortAscMaxLines(ArraysWrapper arraysWrapper) throws ArrayException {
        JaggedArray array = (JaggedArray) arraysWrapper;
        for (int row = 0; row < array.getVerticalSize(); row++) {
            for (int nextRow = 0; nextRow < array.getVerticalSize(); nextRow++) {
                if (compareLargestValues(array.getArray(row), array.getArray(nextRow)) < 0) {
                    JaggedRowSwapper(array, row, nextRow);
                }
            }
        }
    }

    /**
     * Compares largest values in given arrays
     *
     * @param arrayF
     * @param arrayS
     * @return
     */
    public int compareLargestValues(Array arrayF, Array arrayS) throws ArrayException {
        ArraySearchService service = new ArraysSearchServiceImpl();
        if (service.findMax(arrayF) > service.findMax(arrayS)) {
            return 1;
        } else if (service.findMax(arrayS) > service.findMax(arrayF)) {
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
    public void sortDescMaxLines(ArraysWrapper arraysWrapper) throws ArrayException {
        sortAscSumLines(arraysWrapper);
        reverse((JaggedArray) arraysWrapper);
    }

    /**
     * Sorts in ascending order depending on min values in each array
     *
     * @param arraysWrapper - given array
     */
    @Override
    public void sortAscMinLines(ArraysWrapper arraysWrapper) throws ArrayException {
        JaggedArray array = (JaggedArray) arraysWrapper;
        for (int row = 0; row < array.getVerticalSize(); row++) {
            for (int nextRow = 0; nextRow < array.getVerticalSize(); nextRow++) {
                if (compareMinValues(array.getArray(row), array.getArray(nextRow)) < 0) {
                    JaggedRowSwapper(array, row, nextRow);
                }
            }
        }
    }

    /**
     * Compares minimum values in given arrays
     *
     * @param arrayF
     * @param arrayS
     * @return
     */
    private int compareMinValues(Array arrayF, Array arrayS) throws ArrayException {
        ArraySearchService service = new ArraysSearchServiceImpl();
        if (service.findMin(arrayF) > service.findMin(arrayS)) {
            return 1;
        } else if (service.findMin(arrayS) > service.findMin(arrayF)) {
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
    public void sortDescMinLines(ArraysWrapper arraysWrapper) throws ArrayException {
        sortAscMinLines(arraysWrapper);
        reverse((JaggedArray) arraysWrapper);
    }

    /**
     * Reverses rows of jagged array
     *
     * @param array
     */
    private void reverse(JaggedArray array) throws ArrayException {
        List<Array> arrayList = new ArrayList<>();
        for (int i = 0; i < array.getVerticalSize(); i++) {
            arrayList.add(array.getArray(i));
        }
        Collections.reverse(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            array.setArray(arrayList.get(i), i);
        }
    }

    /**
     * Swaps jagged array's arrays
     *
     * @param jagged
     * @param rowLength
     * @param nextRowLength
     */
    private void JaggedRowSwapper(JaggedArray jagged, int rowLength, int nextRowLength) throws ArrayException {
        Array jaggedArrayRowSwap = new Array(jagged.getArray(rowLength).getLength());

        Array arrayNextRow = jagged.getArray(nextRowLength);
        for (int j = 0; j < arrayNextRow.getLength(); j++) {
            jaggedArrayRowSwap.setElement(j, arrayNextRow.getElement(j));
        }
        Array arrayRow = jagged.getArray(rowLength);
        for (int j = 0; j < arrayRow.getLength(); j++) {
            arrayNextRow.setElement(j, arrayRow.getElement(j));
        }
        for (int i = 0; i < jaggedArrayRowSwap.getLength(); i++) {
            arrayRow.setElement(i, jaggedArrayRowSwap.getElement(i));
        }
    }
}
