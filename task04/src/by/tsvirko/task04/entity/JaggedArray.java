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
        sj.add("Jagged Array[");
        for (Array array : arrayList) {
            sj.add(array.toString());
        }
        sj.add("]");
        return sj.toString();
    }

    public Map<Integer, Integer> findElementIndex(int element) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Array array = arrayList.get(i);
            int elementIndexArray = array.findElementIndex(element);
            if (elementIndexArray != -1) {
                map.put(i, elementIndexArray);
            }
        }
        return map;
    }
}
