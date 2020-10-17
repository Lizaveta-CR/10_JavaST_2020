package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.service.impl.SortArrayServiceImpl;

public class ArrayBinarySearchService {
    private SortArrayService service = new SortArrayServiceImpl();

    /**
     * Method compares the key value with the middle element of the array; if they are unequal,
     * the half in which the key cannot be part of is eliminated, and the search continues for
     * the remaining half until it succeeds.
     *
     * @param wrapper - given array
     * @param key
     * @return index of key element
     */
    public int binarySearch(ArraysWrapper wrapper, int key) throws ClassCastException, ArrayException {
        Array array = (Array) wrapper;
        if (!isArraySorted(array, array.getLength())) {
            service.heapSort(array);
        }
        int index = -1;
        int low = 0;
        int high = array.getLength();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array.getElement(mid) < key) {
                low = mid + 1;
            } else if (array.getElement(mid) > key) {
                high = mid - 1;
            } else if (array.getElement(mid) == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    /**
     * Checks if array is sorted or not
     *
     * @param arr
     * @param n
     * @return true - sorted, false -not sorted
     */
    private boolean isArraySorted(Array arr, int n) throws ArrayException {
        if (n == 0 || n == 1) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (arr.getElement(i - 1) > arr.getElement(i)) {
                return false;
            }
        }
        return true;
    }
}
