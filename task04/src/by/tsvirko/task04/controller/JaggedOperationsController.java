package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.service.factory.ServiceFactory;

public class JaggedOperationsController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ArraysWrapper arraysWrapper;

    public static void setArraysWrapper(ArraysWrapper arraysWrapper) {
        JaggedOperationsController.arraysWrapper = arraysWrapper;
    }
}
