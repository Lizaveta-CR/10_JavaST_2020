package by.tsvirko.task08.service.firstService;

import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.firstSolution.MatrixResourceSingletonFirst;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.entity.state.StateFabric;

public class ThreadController {
    private int initNumber = 666;
    private MatrixResourceSingletonFirst resourceSingleton = MatrixResourceSingletonFirst.getInstance();

    public ThreadController() {
    }

    public void control() throws MatrixException {
        for (int i = 0; i < resourceSingleton.matrixDiagonalSize(); i++) {
            MatrixItem element = resourceSingleton.getPrincipalDiagonalElement(i);
            if (element.getState().equals(StateFabric.getState().getStartState())) {
                element.setValue(initNumber);
                element.setState(StateFabric.getState().getStopState());
            }
        }
    }
}
