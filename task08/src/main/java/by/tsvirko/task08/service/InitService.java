package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.ArrayWrapper;
import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.exception.ServiceInitException;

public interface InitService {
    ArrayWrapper init(String fileName, int n1, int n2) throws MatrixException, ServiceInitException, ArrayException;
}
