package by.tsvirko.task04.service.impl;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.service.SortArrayService;

public class SortArrayServiceImpl implements SortArrayService {
    @Override
    public void heapSort(ArraysWrapper wrapper) throws ClassCastException, ArrayException {
        Array array = (Array) wrapper;

        int n = array.getLength();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array.getElement(0);
            array.setElement(0, array.getElement(i));
            array.setElement(i, temp);

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    /**
     * This method is to to heapify a subtree rooted with node i which is
     * an index in arr[]
     *
     * @param arr - given array
     * @param n   - arr length
     * @param i   - node, which is an index in arr[]
     */
    private void heapify(Array arr, int n, int i) throws ArrayException {
        int largest = i;//initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr.getElement(left) > arr.getElement(largest))
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr.getElement(right) > arr.getElement(largest))
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr.getElement(i);
            arr.setElement(i, arr.getElement(largest));
            arr.setElement(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    @Override
    public void insertionSort(ArraysWrapper wrapper) throws ClassCastException, ArrayException {
        Array arr = (Array) wrapper;

        int n = arr.getLength();

        for (int i = 1; i < n; ++i) {
            int key = arr.getElement(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr.getElement(j) > key) {
                arr.setElement(j + 1, arr.getElement(j));
                j = j - 1;
            }
            arr.setElement(j + 1, key);
        }
    }

    @Override
    public void combSort(ArraysWrapper wrapper) throws ClassCastException, ArrayException {
        Array arr = (Array) wrapper;

        int n = arr.getLength();
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped == true) {
            // Find next gap
            gap = getNextGap(gap);

            swapped = false;

            // Compare all elements with current gap
            for (int i = 0; i < n - gap; i++) {
                if (arr.getElement(i) > arr.getElement(gap + i)) {
                    int temp = arr.getElement(i);
                    arr.setElement(i, arr.getElement(i + gap));
                    arr.setElement(i + gap, temp);
                    swapped = true;
                }
            }
        }
    }

    /**
     * To find gap between elements
     *
     * @param gap - given gap
     * @return gap between elements
     */
    private int getNextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }
}
