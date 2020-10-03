package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;

public class ArrayBinarySearchService {
    /**
     * Method compares the key value with the middle element of the array; if they are unequal,
     * the half in which the key cannot be part of is eliminated, and the search continues for
     * the remaining half until it succeeds.
     *
     * @param wrapper - given array
     * @param key
     * @return index of key element
     */
    public int binarySearch(ArraysWrapper wrapper, int key) throws ClassCastException {
        Array array = (Array) wrapper;
        int[] sortedArray = array.getArray();
        int index = Integer.MAX_VALUE;
        int low = 0;
        int high = sortedArray.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
