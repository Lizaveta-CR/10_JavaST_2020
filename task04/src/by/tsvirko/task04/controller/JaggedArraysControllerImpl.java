package by.tsvirko.task04.controller;

import by.tsvirko.task04.entity.ArraysWrapper;
import by.tsvirko.task04.exceptions.ArrayException;
import by.tsvirko.task04.exceptions.FileArrayException;
import by.tsvirko.task04.exceptions.InitConsoleException;
import by.tsvirko.task04.exceptions.JaggedArraysDimensionalException;
import by.tsvirko.task04.service.ArraySearchService;
import by.tsvirko.task04.service.ArraysInitService;
import by.tsvirko.task04.service.factory.ServiceFactory;

import java.util.*;

public class JaggedArraysControllerImpl implements ArraysWrapperController {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ArraysInitService arraysInitService = serviceFactory.getJagArraysInitService();
    private ArraySearchService searchService = serviceFactory.getJagArraySearchService();
    private static ArraysWrapper arraysWrapper;
    private JaggedOperationsController arraysOperationsController = new JaggedOperationsController();
    private static ResourceBundle rb;

    public JaggedArraysControllerImpl() {
    }

    public JaggedArraysControllerImpl(ResourceBundle rb) {
        this.rb = rb;
    }

    @Override
    public ArraysWrapper fillArrayConsole(Scanner scanner, int size) {
        try {
            arraysWrapper = arraysInitService.init(scanner, size);
        } catch (InitConsoleException e) {
            System.err.println(rb.getString("message.error1"));
        }
        arraysOperationsController.setArraysWrapper(arraysWrapper);
        return arraysWrapper;
    }

    @Override
    public ArraysWrapper fillArrayFile(String fileName) {
        try {
            arraysWrapper = arraysInitService.init(fileName);
        } catch (FileArrayException e) {
            System.err.println(rb.getString("message.error2"));
        }
        arraysOperationsController.setArraysWrapper(arraysWrapper);
        return arraysWrapper;
    }

    @Override
    public ArraysWrapper fillArrayRandom() {
        arraysWrapper = arraysInitService.init();
        arraysOperationsController.setArraysWrapper(arraysWrapper);
        return arraysWrapper;
    }

    public int findElementIndex(int element) {
        return searchService.findElementIndex(arraysWrapper, element);
    }

    public int findMax() {
        return searchService.findMax(arraysWrapper);
    }

    public int findMin() {
        return searchService.findMin(arraysWrapper);
    }

    public boolean isSameDim(List<ArraysWrapper> wrappers) {
        return arraysOperationsController.isSameDim(wrappers);
    }

    public boolean isSquare(ArraysWrapper wrapper) {
        return arraysOperationsController.isSquare(wrapper);
    }

    public ArraysWrapper getSum(ArraysWrapper wrapper1, ArraysWrapper wrapper2) {
        try {
            return arraysOperationsController.getSum(wrapper1, wrapper2);
        } catch (JaggedArraysDimensionalException e) {
            System.err.println(rb.getString("message.error61"));
        }
        return null;
    }

    public ArraysWrapper getDif(ArraysWrapper wrapper1, ArraysWrapper wrapper2) {
        try {
            return arraysOperationsController.getDif(wrapper1, wrapper2);
        } catch (JaggedArraysDimensionalException e) {
            System.err.println(rb.getString("message.error6"));
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error8"));
        }
        return null;
    }

    public void multiplyConst(ArraysWrapper arraysWrapper, int num) {
        try {
            arraysOperationsController.multiplyConst(arraysWrapper, num);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error8"));
        }
    }

    public ArraysWrapper getTranspose(ArraysWrapper wrapper1) {
        try {
            return arraysOperationsController.getTranspose(wrapper1);
        } catch (JaggedArraysDimensionalException e) {
            System.err.println(rb.getString("message.error7"));
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error8"));
        }
        return wrapper1;
    }

    public void sortAscSumms(ArraysWrapper arraysWrapper) {
        arraysOperationsController.sortAscSumms(arraysWrapper);
    }

    public void sortDescSumms(ArraysWrapper arraysWrapper) {
        arraysOperationsController.sortDescSumms(arraysWrapper);
    }

    public void sortAscMax(ArraysWrapper arraysWrapper) {
        arraysOperationsController.sortAscMax(arraysWrapper);
    }

    public void sortDescMax(ArraysWrapper arraysWrapper) {
        arraysOperationsController.sortDescMax(arraysWrapper);
    }

    public void sortAscMin(ArraysWrapper arraysWrapper) {
        arraysOperationsController.sortAscMin(arraysWrapper);
    }

    public void sortDescMin(ArraysWrapper arraysWrapper) {
        arraysOperationsController.sortDescMin(arraysWrapper);
    }
}
