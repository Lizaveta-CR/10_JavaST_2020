package by.tsvirko.task04.service;

import by.tsvirko.task04.entity.Array;
import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.entity.JaggedArray;
import by.tsvirko.task04.exceptions.JaggedArraysDimensionalException;

import java.util.*;

public class JaggedArrayOperationsService {
    /**
     * Checks if Jagged Arrays have same dimensions
     *
     * @param wrappers - given arrays
     * @return boolean value: tru, if Jagged Arrays are of same dimensions, else - false
     */
    public boolean isSameDim(List<ArraysWrapper> wrappers) {
        Set<Array> dimensionsList = new HashSet<>();
        for (int i = 0; i < wrappers.size(); i++) {
            int[] dimensions = getDimensions(wrappers.get(i));
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

    /**
     * Checks is given array is a square matrix
     *
     * @param arraysWrapper
     * @return boolean value: true, if array is a square matrix, else - false
     */
    public boolean isSquare(ArraysWrapper arraysWrapper) {
        JaggedArray jaggedArray = (JaggedArray) arraysWrapper;
        int[][] multiDimensionalArray = jaggedArray.getJaggedArray();
        for (int i = 0, l = multiDimensionalArray.length; i < l; i++) {
            if (multiDimensionalArray[i].length != l) {
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
    public JaggedArray sum(ArraysWrapper arr1, ArraysWrapper arr2) throws JaggedArraysDimensionalException {
        if (!Arrays.equals(getDimensions(arr1), getDimensions(arr2))) {
            throw new JaggedArraysDimensionalException();
        }
        JaggedArray jagArr1 = (JaggedArray) arr1;
        JaggedArray jagArr2 = (JaggedArray) arr2;
        int[][] jaggedArrayF = jagArr1.getJaggedArray();
        int[][] jaggedArrayS = jagArr2.getJaggedArray();
        int[][] sum = new int[jaggedArrayF.length][];
        for (int i = 0; i < 3; i++) {
            int size = jaggedArrayF[i].length;
            sum[i] = new int[size];
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] = jaggedArrayF[i][j] + jaggedArrayS[i][j];
            }

        }
        return new JaggedArray(sum);
    }

    /**
     * Method subtracts two Jagged Arrays
     *
     * @param arr1
     * @param arr2
     * @return JaggedArray - difference of two Jagged Arrays
     * @throws JaggedArraysDimensionalException
     */
    public JaggedArray subtract(ArraysWrapper arr1, ArraysWrapper arr2) throws JaggedArraysDimensionalException {
        if (!Arrays.equals(getDimensions(arr1), getDimensions(arr2))) {
            throw new JaggedArraysDimensionalException();
        }
        JaggedArray jagArr1 = (JaggedArray) arr1;
        JaggedArray jagArr2 = (JaggedArray) arr2;
        int[][] jaggedArrayF = jagArr1.getJaggedArray();
        int[][] jaggedArrayS = jagArr2.getJaggedArray();
        int[][] dif = new int[jaggedArrayF.length][];
        for (int i = 0; i < 3; i++) {
            int size = jaggedArrayF[i].length;
            dif[i] = new int[size];
            for (int j = 0; j < dif[i].length; j++) {
                dif[i][j] = jaggedArrayF[i][j] - jaggedArrayS[i][j];
            }

        }
        return new JaggedArray(dif);
    }

    public void constMultiplication(ArraysWrapper arraysWrapper, int num) {
        JaggedArray jagArr1 = (JaggedArray) arraysWrapper;
        int[][] jaggedArray = jagArr1.getJaggedArray();
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] *= num;
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
    public JaggedArray transpose(ArraysWrapper arr1) throws JaggedArraysDimensionalException {
        if (!isRectangular(arr1)) {
            throw new JaggedArraysDimensionalException();
        }
        JaggedArray jagArr1 = (JaggedArray) arr1;
        int[][] jaggedArrayF = jagArr1.getJaggedArray();

        int width = jaggedArrayF.length;
        int height = jaggedArrayF[0].length;

        int[][] array_new = new int[height][width];

        for (
                int x = 0;
                x < width; x++) {
            for (int y = 0; y < height; y++) {
                array_new[y][x] = jaggedArrayF[x][y];
            }
        }
        return new

                JaggedArray(array_new);

    }

    /**
     * Validates if given jagged array is rectangular
     *
     * @param arraysWrapper
     * @return
     */
    private boolean isRectangular(ArraysWrapper arraysWrapper) {
        HashSet<Integer> set = new HashSet<>();
        int[] dimensions = getDimensions(arraysWrapper);
        for (int i = 0; i < dimensions.length; i++) {
            set.add(dimensions[i]);
        }
        return set.size() == 1;
    }
}
