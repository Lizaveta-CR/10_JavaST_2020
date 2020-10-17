package by.tsvirko.task04.entity;

import by.tsvirko.task04.exceptions.ArrayException;

import java.util.*;

public class JaggedArray extends ArraysWrapper {
    private List<Array> arrayList;

    public JaggedArray() {
        arrayList = new ArrayList<>();
    }

    public JaggedArray(List<Array> arrayList) {
        this.arrayList = arrayList;
    }

    public JaggedArray(int[][] array) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Array arr = new Array(array[i]);
            arrayList.add(arr);
        }
    }

    public int getArrayListElement(int i, int j) throws ArrayException {
        if (checkRange(i)) {
            return arrayList.get(i).getElement(j);
        }
        throw new ArrayException();
    }

    private boolean checkRange(int i) {
        if (i < 0 || i > arrayList.size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    public Array getArray(int i) {
        return arrayList.get(i);
    }

    public void setArrayListElement(int i, int j, int value) throws ArrayException {
        if (checkRange(i)) {
            arrayList.get(i).setElement(j, value);
        }
    }

    public void setArray(Array array, int i) throws ArrayException {
        if (i > arrayList.size()) {
            throw new ArrayException();
        }
        arrayList.add(i, array);
    }

    public int getVerticalSize() {
        return arrayList.size();
    }

    public int getHorizontalSize(int i) {
        return arrayList.get(i).getLength();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggedArray that = (JaggedArray) o;
        return Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayList);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (Array array : arrayList) {
            sj.add(array.toString());
        }
        return sj.toString();
    }
}
