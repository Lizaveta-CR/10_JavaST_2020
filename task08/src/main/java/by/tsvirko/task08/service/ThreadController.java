package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.MatrixResourceSingleton;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.entity.state.StateFabric;

import java.util.Random;

public class ThreadController {
    private MatrixResourceSingleton resourceSingleton = MatrixResourceSingleton.getInstance();

    public ThreadController() {
    }

    public void control() throws MatrixException {
        for (int i = 0; i < resourceSingleton.matrixDiagonalSize(); i++) {
            MatrixItem element = resourceSingleton.getPrincipalDiagonalElement(i);
            if (element.getState().equals(StateFabric.getState().getStartState())) {
                element.setValue(new Random().nextInt(10));
                element.setState(StateFabric.getState().getStopState());
            }
        }
    }
}
