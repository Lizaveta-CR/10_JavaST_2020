package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.exception.MatrixException;

public interface MatrixInitService {
    Matrix init(String fileName) throws MatrixException;
}
