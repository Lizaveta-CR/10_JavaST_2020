package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.JaggedArraysDimensionalException;

import java.util.*;

public class JaggedArrayOperationsService {
    /**
     * Checks if Jagged Arrays have same dimensions
     *
     * @param wrappers - given arrays
     * @return boolean value: tru, if Jagged Arrays are of same dimensions, else - false
     */
    public boolean isSameDim(List<ArraysWrapper> wrappers) throws ArrayException {
        Set<Array> dimensionsList = new HashSet<>();
        for (int i = 0; i < wrappers.size(); i++) {
            Array dimensions = getDimensions(wrappers.get(i));
            dimensionsList.add(dimensions);
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
    private Array getDimensions(ArraysWrapper wrapper) throws ArrayException {
        JaggedArray jaggedArray = (JaggedArray) wrapper;
        int verticalSize = jaggedArray.getVerticalSize();
        Array dimensions = new Array(verticalSize);
        for (int i = 0; i < verticalSize; i++) {
            int length = jaggedArray.getArray(i).getLength();
            dimensions.setElement(i, length);
        }
        return dimensions;
    }

    /**
     * Checks is given array is a square matrix
     *
     * @param arraysWrapper
     * @return boolean value: true, if array is a square matrix, else - false
     */
    public boolean isSquare(ArraysWrapper arraysWrapper) throws ArrayException {
        JaggedArray jaggedArray = (JaggedArray) arraysWrapper;
        for (int i = 0, l = jaggedArray.getVerticalSize(); i < l; i++) {
            if (jaggedArray.getArray(i).getLength() != l) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method adds two Jagged Arrays
     *
     * @param arr1
     * @param arr2
     * @return JaggedArray - sum of two Jagged Arrays
     * @throws JaggedArraysDimensionalException
     */
    public JaggedArray sum(ArraysWrapper arr1, ArraysWrapper arr2) throws JaggedArraysDimensionalException, ArrayException {
        if (!getDimensions(arr1).equals(getDimensions(arr2))) {
            throw new JaggedArraysDimensionalException();
        }
        JaggedArray jagArr1 = (JaggedArray) arr1;
        JaggedArray jagArr2 = (JaggedArray) arr2;
        JaggedArray jaggedArray = new JaggedArray();
        for (int i = 0; i < jagArr1.getVerticalSize(); i++) {
            int length = jagArr1.getArray(i).getLength();
            Array sum = new Array(length);
            jaggedArray.setArray(sum, i);
            for (int j = 0; j < sum.getLength(); j++) {
                int i1 = jagArr1.getArrayListElement(i, j) + jagArr2.getArrayListElement(i, j);
                jaggedArray.setArrayListElement(i, j, i1);
            }
        }
        return jaggedArray;
    }

    /**
     * Method subtracts two Jagged Arrays
     *
     * @param arr1
     * @param arr2
     * @return JaggedArray - difference of two Jagged Arrays
     * @throws JaggedArraysDimensionalException
     */
    public JaggedArray subtract(ArraysWrapper arr1, ArraysWrapper arr2) throws
            JaggedArraysDimensionalException, ArrayException {
        if (!getDimensions(arr1).equals(getDimensions(arr2))) {
            throw new JaggedArraysDimensionalException();
        }
        JaggedArray jagArr1 = (JaggedArray) arr1;
        JaggedArray jagArr2 = (JaggedArray) arr2;
        JaggedArray jaggedArray = new JaggedArray();
        for (int i = 0; i < jagArr1.getVerticalSize(); i++) {
            int length = jagArr1.getArray(i).getLength();
            Array sum = new Array(length);
            jaggedArray.setArray(sum, i);
            for (int j = 0; j < sum.getLength(); j++) {
                int i1 = jagArr1.getArrayListElement(i, j) - jagArr2.getArrayListElement(i, j);
                jaggedArray.setArrayListElement(i, j, i1);
            }
        }
        return jaggedArray;
    }

    public void constMultiplication(ArraysWrapper arraysWrapper, int num) throws ArrayException {
        if (arraysWrapper instanceof Array) {
            throw new ArrayException();
        }
        JaggedArray jagArr1 = (JaggedArray) arraysWrapper;
        for (int i = 0; i < jagArr1.getVerticalSize(); i++) {
            Array array = jagArr1.getArray(i);
            for (int j = 0; j < array.getLength(); j++) {
                array.setElement(j, array.getElement(j) * num);
            }
        }
    }

    /**
     * Method transposes given rectangular Jagged array
     *
     * @param arr1
     * @return JaggedArray - transposed array
     * @throws JaggedArraysDimensionalException
     */
    public JaggedArray transpose(ArraysWrapper arr1) throws JaggedArraysDimensionalException, ArrayException {
        if (arr1 instanceof Array) {
            throw new ArrayException();
        }
        if (!isRectangular(arr1)) {
            throw new JaggedArraysDimensionalException();
        }
        JaggedArray jagArr1 = (JaggedArray) arr1;

        int width = jagArr1.getVerticalSize();
        for (int i = 0; i < width; i++) {
            Array array = jagArr1.getArray(i);
            for (int j = 0; j < array.getLength(); j++) {
                int element = array.getElement(j);
                jagArr1.setArrayListElement(j, i, element);
            }
        }
        return jagArr1;
    }

    /**
     * Validates if given jagged array is rectangular
     *
     * @param arraysWrapper
     * @return
     */
    private boolean isRectangular(ArraysWrapper arraysWrapper) throws ArrayException {
        HashSet<Integer> set = new HashSet<>();
        Array dimensions = getDimensions(arraysWrapper);
        for (int i = 0; i < dimensions.getLength(); i++) {
            set.add(dimensions.getElement(i));
        }
        return set.size() == 1;
    }
}
