package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.service.JaggedArrayOperationsService;
import by.tsvirko.task04.service.factory.ServiceFactory;

import java.util.List;

public class JaggedOperationsController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ArraysWrapper arraysWrapper;

    public static void setArraysWrapper(ArraysWrapper arraysWrapper) {
        JaggedOperationsController.arraysWrapper = arraysWrapper;
    }


    public boolean isSameDim(List<ArraysWrapper> wrappers) {
        JaggedArrayOperationsService service = serviceFactory.getJaggedArrayOperationsService();
        return service.isSameDim(wrappers);
    }

    public boolean isSquare(ArraysWrapper arraysWrapper) {
        JaggedArrayOperationsService service = serviceFactory.getJaggedArrayOperationsService();
        return service.isSquare(arraysWrapper);
    }
}
