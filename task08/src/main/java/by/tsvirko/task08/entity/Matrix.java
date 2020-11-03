package by.tsvirko.task08.entity;

import by.tsvirko.task08.entity.exception.MatrixException;

public class Matrix {
    private int[][] array;

    public Matrix(int n, int m) throws MatrixException {
        if ((n < 1) || (m < 1)) {
            throw new MatrixException();
        }
        array = new int[n][m];
    }

    public int getVerticalSize() {
        return array.length;
    }

    public int getHorizontalSize() {
        return array[0].length;
    }

    public int getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) {
            return array[i][j];
        }
        throw new MatrixException();
    }

    public void setElement(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) {
            array[i][j] = value;
        } else {
            throw new MatrixException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nMatrix :" + array.length + "x" + array[0].length + "\n");
        for (int[] row : array) {
            for (int value : row) {
                sb.append(value + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean checkRange(int i, int j) {
        if (i < 0 || i > array.length - 1 || j < 0 || j > array[0].length - 1) {
            return false;
        } else {
            return true;
        }
    }
}

