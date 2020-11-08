package by.tsvirko.task08.entity.firstSolution;

import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.exception.MatrixException;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Is used for first solution
 */
public class MatrixResourceSingletonFirst {
    private static MatrixResourceSingletonFirst instance = null;
    private static ReentrantLock lock = new ReentrantLock();
    private Matrix matrix;

    private MatrixResourceSingletonFirst() {
    }

    public static MatrixResourceSingletonFirst getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new MatrixResourceSingletonFirst();
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
