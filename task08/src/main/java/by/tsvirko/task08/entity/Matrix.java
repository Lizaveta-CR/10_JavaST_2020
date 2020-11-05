package by.tsvirko.task08.entity;

import by.tsvirko.task08.entity.exception.MatrixException;

import java.util.*;

public class Matrix extends ArrayWrapper {
    private List<MatrixItem> items;

    public Matrix() {
        this.items = new ArrayList<>();
    }

    public int getVerticalSize() {
        Set<Integer> itemsSize = new HashSet<>();
        for (MatrixItem item : items) {
            itemsSize.add(item.getI());
        }
        return itemsSize.size();
    }

    public int getHorizontalSize() {
        Set<Integer> itemsSize = new HashSet<>();
        for (MatrixItem item : items) {
            itemsSize.add(item.getJ());
        }
        return itemsSize.size();
    }

    public int getElement(int i, int j) throws MatrixException {
        for (MatrixItem item : items) {
            if (item.getI() == i && item.getJ() == j) {
                return item.getValue();
            }
        }
        throw new MatrixException();
    }

    public void setElement(int i, int j, int value) {
        items.add(new MatrixItem(i, j, value));
    }

    public MatrixItem getCell(int i, int j) throws MatrixException {
        for (MatrixItem item : items) {
            if (item.getI() == i && item.getJ() == j) {
                return item;
            }
        }
        throw new MatrixException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Objects.equals(items, matrix.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "Matrix{" + items +
                '}';
    }
}

