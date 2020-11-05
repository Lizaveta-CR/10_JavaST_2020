package by.tsvirko.task08.entity;

import by.tsvirko.task08.entity.state.Context;
import by.tsvirko.task08.entity.state.StartState;
import by.tsvirko.task08.entity.state.State;
import by.tsvirko.task08.entity.state.StateFabric;

import java.util.Objects;

public class MatrixItem extends Context {
    private State state;
    private int value;
    int i;
    int j;

    public MatrixItem(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
        this.state = StateFabric.getState().getStartState();
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getValue() {
        return value;
    }

    public void setMatrixItem(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixItem that = (MatrixItem) o;
        return value == that.value &&
                i == that.i &&
                j == that.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, i, j);
    }

    @Override
    public String toString() {
        return "[value=" + value +
                ", i=" + i +
                ", j=" + j + "]";
    }
}
