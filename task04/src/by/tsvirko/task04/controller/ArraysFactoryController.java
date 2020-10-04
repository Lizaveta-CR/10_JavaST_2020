package by.tsvirko.task04.controller;


public class ArraysFactoryController {
    private ArraysWrapperController arraysWrapperController;

    public ArraysFactoryController() {
    }

    public ArraysWrapperController controllerFactory(int num) {
        switch (num) {
            case 1:
                arraysWrapperController = new ArraysControllerImpl();
                return arraysWrapperController;
            case 2:
                arraysWrapperController = new JaggedArraysControllerImpl();
                return arraysWrapperController;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }
    }
}
