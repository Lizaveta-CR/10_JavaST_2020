package by.tsvirko.task04.entity;

import java.util.*;

public class JaggedArray extends ArraysWrapper {
    private List<Array> arrayList = new ArrayList<>();

    public JaggedArray() {
    }

    public JaggedArray(List<Array> arrayList) {
        this.arrayList = arrayList;
    }

    public JaggedArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            Array arr = new Array(array[i]);
            arrayList.add(arr);
        }
    }

    public List<Array> getArrayList() {
        return arrayList;
    }

    public int[][] getJaggedArray() {
        int[][] ints = new int[arrayList.size()][];
        for (int i = 0; i < ints.length; i++) {
            int[] array = arrayList.get(i).getArray();
            ints[i] = array;
        }
        return ints;
    }

    public void setArrayList(List<Array> arrayList) {
        this.arrayList = arrayList;
    }

    public void setJaggedArray(int[][] array) {
        arrayList.clear();
        for (int i = 0; i < array.length; i++) {
            Array arr = new Array(array[i]);
            arrayList.add(arr);
        }
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
