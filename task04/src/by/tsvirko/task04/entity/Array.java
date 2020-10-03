package by.tsvirko.task04.entity;

import by.tsvirko.task04.exceptions.ArrayException;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Array extends ArraysWrapper {
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

    public int getElement(int i) throws ArrayException {
        if (checkRange(i)) {
            return array[i];
        }
        throw new ArrayException();
    }

    public void setElement(int i, int value) throws ArrayException {
        if (checkRange(i)) {
            array[i] = value;
        } else {
            throw new ArrayException();
        }
    }

    private boolean checkRange(int i) {
        if (i >= 0 && i < array.length) {
            return true;
        } else {
            return false;
        }
    }

    public int getLength() {
        return array.length;
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
        return Arrays.toString(array);
    }


    @Override
    public int findElementIndex(int element) {
        return IntStream.range(0, array.length)
                .filter(i -> element == array[i])
                .findFirst()
                .orElse(-1);
    }
}
