package by.tsvirko.task04.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class JaggedArray extends ArraysWrapper {
    private int[][] array;

    public JaggedArray() {
    }

    public JaggedArray(Array arr, int size) {
        for (int i = 0; i < size; i++) {
            int[] array = arr.getArray();
            for (int j = 0; j < array.length; j++) {
                this.array[j] = array;
            }
        }
    }

    public JaggedArray(int[][] array) {
        this.array = array;
    }


    public JaggedArray(int sizeN, int[] array) {
        for (int i = 0; i < sizeN; i++) {
            this.array[i] = array;
        }
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggedArray that = (JaggedArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("Jagged Array[");
        for (int[] row : array) {
            sj.add(Arrays.toString(row));
        }
        sj.add("]");
        return sj.toString();
    }
}
