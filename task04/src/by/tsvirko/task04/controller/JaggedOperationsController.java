package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.JaggedArraysDimensionalException;
import by.tsvirko.task04.service.JaggedArrayOperationsService;
import by.tsvirko.task04.service.JaggedArraysSortService;
import by.tsvirko.task04.service.factory.ServiceFactory;

import java.util.List;
import java.util.ResourceBundle;

public class JaggedOperationsController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ArraysWrapper arraysWrapper;
    private ResourceBundle rb;

    public JaggedOperationsController() {
    }

    public JaggedOperationsController(ResourceBundle rb) {
        this.rb = rb;
    }

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

    public ArraysWrapper getSum(ArraysWrapper wrapper1, ArraysWrapper wrapper2) throws JaggedArraysDimensionalException {
        JaggedArrayOperationsService service = serviceFactory.getJaggedArrayOperationsService();
        return service.sum(wrapper1, wrapper2);
    }

    public ArraysWrapper getDif(ArraysWrapper wrapper1, ArraysWrapper wrapper2) throws JaggedArraysDimensionalException, ArrayException {
        JaggedArrayOperationsService service = serviceFactory.getJaggedArrayOperationsService();
        return service.subtract(wrapper1, wrapper2);
    }

    public void multiplyConst(ArraysWrapper wrapper, int num) throws ArrayException {
        JaggedArrayOperationsService service = serviceFactory.getJaggedArrayOperationsService();
        service.constMultiplication(wrapper, num);
    }

    public ArraysWrapper getTranspose(ArraysWrapper arraysWrapper) throws JaggedArraysDimensionalException, ArrayException {
        JaggedArrayOperationsService service = serviceFactory.getJaggedArrayOperationsService();
        return service.transpose(arraysWrapper);
    }

    public void sortAscSumms(ArraysWrapper arraysWrapper) {
        JaggedArraysSortService jaggedArraysSortService = serviceFactory.getJaggedArraysSortService();
        jaggedArraysSortService.sortAscSumLines(arraysWrapper);
    }

    public void sortDescSumms(ArraysWrapper arraysWrapper) {
        JaggedArraysSortService jaggedArraysSortService = serviceFactory.getJaggedArraysSortService();
        jaggedArraysSortService.sortDescSumLines(arraysWrapper);
    }

    public void sortAscMax(ArraysWrapper arraysWrapper) {
        JaggedArraysSortService jaggedArraysSortService = serviceFactory.getJaggedArraysSortService();
        jaggedArraysSortService.sortAscMaxLines(arraysWrapper);
    }

    public void sortDescMax(ArraysWrapper arraysWrapper) {
        JaggedArraysSortService jaggedArraysSortService = serviceFactory.getJaggedArraysSortService();
        jaggedArraysSortService.sortDescMaxLines(arraysWrapper);
    }

    public void sortAscMin(ArraysWrapper arraysWrapper) {
        JaggedArraysSortService jaggedArraysSortService = serviceFactory.getJaggedArraysSortService();
        jaggedArraysSortService.sortAscMinLines(arraysWrapper);
    }

    public void sortDescMin(ArraysWrapper arraysWrapper) {
        JaggedArraysSortService jaggedArraysSortService = serviceFactory.getJaggedArraysSortService();
        jaggedArraysSortService.sortDescMinLines(arraysWrapper);
    }
}
