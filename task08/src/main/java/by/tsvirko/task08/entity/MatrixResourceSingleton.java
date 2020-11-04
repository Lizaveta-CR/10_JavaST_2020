package by.tsvirko.task08.entity;

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

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
