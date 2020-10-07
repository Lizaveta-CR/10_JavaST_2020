package by.tsvirko.task04.controller;


import java.util.ResourceBundle;

public class ArraysFactoryController {
    private ArraysWrapperController arraysWrapperController;
    private ResourceBundle rb;

    public ArraysFactoryController(ResourceBundle rb) {
        this.rb = rb;
    }

    public ArraysWrapperController controllerFactory(int num) {
        switch (num) {
            case 1:
                arraysWrapperController = new ArraysControllerImpl(rb);
                return arraysWrapperController;
            case 2:
                arraysWrapperController = new JaggedArraysControllerImpl(rb);
                return arraysWrapperController;
            default:
                throw new IllegalStateException(rb.getString("message.error3") + num);
        }
    }
}
