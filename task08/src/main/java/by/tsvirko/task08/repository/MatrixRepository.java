package by.tsvirko.task08.repository;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;

public interface MatrixRepository {
    void add(Matrix matrix);

    Array getPrincipalDiagonal() throws MatrixException, ArrayException;
}
