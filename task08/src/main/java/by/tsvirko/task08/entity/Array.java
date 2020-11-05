package by.tsvirko.task08.entity;

import by.tsvirko.task08.entity.exception.ArrayException;

import java.util.Arrays;

public class Array extends ArrayWrapper{
    private int[] array;

    public Array() {
    }

    public Array(int size) {
        array = new int[size];
    }

    public Array(int[] array) {
        this.array = array;
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
        Array array1 = (Array) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
