package by.tsvirko.task08.repository;

import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.MatrixResourceSingleton;

public class MatrixRepositoryImpl implements MatrixRepository {
    private MatrixResourceSingleton resourceSingleton = MatrixResourceSingleton.getInstance();

    @Override
    public void add(Matrix matrix) {
        resourceSingleton.setMatrix(matrix);
    }
}
