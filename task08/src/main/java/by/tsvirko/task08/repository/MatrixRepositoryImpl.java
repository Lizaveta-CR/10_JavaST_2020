package by.tsvirko.task08.repository;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.firstSolution.MatrixResourceSingletonFirst;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;

public class MatrixRepositoryImpl implements MatrixRepository {
    private MatrixResourceSingletonFirst resourceSingleton = MatrixResourceSingletonFirst.getInstance();

    @Override
    public void add(Matrix matrix) {
        resourceSingleton.setMatrix(matrix);
    }

    @Override
    public Array getPrincipalDiagonal() throws MatrixException, ArrayException {
        int size = resourceSingleton.matrixDiagonalSize();
        Array array = new Array(size);
        for (int i = 0; i < size; i++) {
            array.setElement(i, resourceSingleton.getPrincipalDiagonalElement(i).getValue());
        }
        return array;
    }
}
