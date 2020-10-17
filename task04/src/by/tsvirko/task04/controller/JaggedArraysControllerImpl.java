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
        int max = 0;
        try {
            max = searchService.findMax(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
        return max;
    }

    public int findMin() {
        int min = 0;
        try {
            min = searchService.findMin(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
        return min;
    }

    public boolean isSameDim(List<ArraysWrapper> wrappers) {
        try {
            return arraysOperationsController.isSameDim(wrappers);
        } catch (ArrayException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isSquare(ArraysWrapper wrapper) {
        boolean isSquare = false;
        try {
            isSquare = arraysOperationsController.isSquare(wrapper);
        } catch (ArrayException e) {
            e.printStackTrace();
        }
        return isSquare;
    }

    public ArraysWrapper getSum(ArraysWrapper wrapper1, ArraysWrapper wrapper2) {
        try {
            return arraysOperationsController.getSum(wrapper1, wrapper2);
        } catch (JaggedArraysDimensionalException | ArrayException e) {
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
        try {
            arraysOperationsController.sortAscSumms(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
    }

    public void sortDescSumms(ArraysWrapper arraysWrapper) {
        try {
            arraysOperationsController.sortDescSumms(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
    }

    public void sortAscMax(ArraysWrapper arraysWrapper) {
        try {
            arraysOperationsController.sortAscMax(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
    }

    public void sortDescMax(ArraysWrapper arraysWrapper) {
        try {
            arraysOperationsController.sortDescMax(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
    }

    public void sortAscMin(ArraysWrapper arraysWrapper) {
        try {
            arraysOperationsController.sortAscMin(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
    }

    public void sortDescMin(ArraysWrapper arraysWrapper) {
        try {
            arraysOperationsController.sortDescMin(arraysWrapper);
        } catch (ArrayException e) {
            System.err.println(rb.getString("message.error5"));
        }
    }
}
