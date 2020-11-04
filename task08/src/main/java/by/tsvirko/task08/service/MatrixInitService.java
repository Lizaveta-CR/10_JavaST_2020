package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.exception.ServiceInitException;

public interface MatrixInitService {
    Matrix init(String fileName, int n1, int n2) throws MatrixException, ServiceInitException;
}
