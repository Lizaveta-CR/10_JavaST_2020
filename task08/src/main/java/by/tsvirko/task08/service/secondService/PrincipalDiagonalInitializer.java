package by.tsvirko.task08.service.secondService;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.firstSolution.MatrixResourceSingletonFirst;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.entity.state.StateFabric;
import by.tsvirko.task08.service.MatrixInitServiceImpl;
import by.tsvirko.task08.service.ThreadInitServiceImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//я пыталась сделать рекурсивно, но спустя множетсво часов так и не разобралась в правильном алгоритме

public class PrincipalDiagonalInitializer extends RecursiveAction {
    private static Array initNumbers;
    private MatrixResourceSingletonFirst resourceSingleton = MatrixResourceSingletonFirst.getInstance();
    private int number;
    int start, end;

    public PrincipalDiagonalInitializer(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public PrincipalDiagonalInitializer(int start, int end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }


    public static void setInitNumbers(Array initNumbers) {
        PrincipalDiagonalInitializer.initNumbers = initNumbers;
    }

    @Override
    protected void compute() {
        int limit = initNumbers.getLength();
        if ((end - start) < limit) {
//            if (start != limit) {
            if (start > end) {
                int temp = 0;
                temp = start;
                start = end;
                end = temp;
            }
            for (int i = start; i < end; i++) {
                try {
                    if (resourceSingleton.getPrincipalDiagonalElement(i).getState().equals(StateFabric.getState().getStartState())) {
                        resourceSingleton.setPrincipalDiagonalElement(i, number);
                        resourceSingleton.getPrincipalDiagonalElement(i).setState(StateFabric.getState().getStopState());
                    }
                } catch (MatrixException e) {
//                    e.printStackTrace();
                }
            }
        } else {
            try {
                int mid = (end - start) / limit;

                if (start < limit) {
                    PrincipalDiagonalInitializer left = new PrincipalDiagonalInitializer(start, mid, initNumbers.getElement(start));
                    PrincipalDiagonalInitializer right = new PrincipalDiagonalInitializer(mid, end / mid + 1, initNumbers.getElement(mid - 1));
                    left.fork();
                    left.join();
                    right.fork();
                    right.join();
                } else {
                    for (int i = 0; i < resourceSingleton.matrixDiagonalSize(); i++) {
                        try {
                            if (resourceSingleton.getPrincipalDiagonalElement(i).getState().equals(StateFabric.getState().getStartState())) {
                                PrincipalDiagonalInitializer initializer = new PrincipalDiagonalInitializer(i, i + 1, initNumbers.getElement(limit - 1));
                                initializer.fork();
                                initializer.join();
                            }
                        } catch (MatrixException | ArrayException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            } catch (ArrayException e) {
            }
        }
    }
}
