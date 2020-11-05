package by.tsvirko.task08.entity;

import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;

import java.util.concurrent.locks.ReentrantLock;

public class MatrixResourceSingleton {
    private static MatrixResourceSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();
    private Matrix matrix;

    private MatrixResourceSingleton() {
    }

    public static MatrixResourceSingleton getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new MatrixResourceSingleton();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public MatrixItem getPrincipalDiagonalElement(int index) throws MatrixException {
        try {
            return matrix.getCell(index, index);
        } catch (MatrixException e) {
            throw new MatrixException("Principal diagonal getting exception");
        }
    }

    public void setPrincipalDiagonalElement(int index, int value) throws MatrixException {
        MatrixItem cell = matrix.getCell(index, index);
        cell.setValue(value);
    }

    public int matrixDiagonalSize() {
        return matrix.getHorizontalSize();
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public void setMatrixElement(int i, int j, int value) {
        matrix.setElement(i, j, value);
    }
}
