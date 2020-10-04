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

    public void setArrayList(List<Array> arrayList) {
        this.arrayList = arrayList;
    }

    public int[][] getJaggedArray() {
        int[][] ints = new int[arrayList.size()][];
        for (int i = 0; i < ints.length; i++) {
            int[] array = arrayList.get(i).getArray();
            ints[i] = array;
        }
        return ints;
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

    public int findElementIndex(int element) {
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Array array = arrayList.get(i);
            index = array.findElementIndex(element);
            if (index == -1) {
                continue;
            } else {
                return index;
            }
        }
        return index;
    }
}
