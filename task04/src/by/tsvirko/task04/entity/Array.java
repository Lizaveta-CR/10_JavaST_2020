package by.tsvirko.task04.entity;

import java.util.Arrays;

public class Array {
    private int[] array;

    public Array() {
    }

    public Array(int size) {
        array = new int[size];
    }

    public Array(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array that = (Array) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "ArrayWrapper{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
