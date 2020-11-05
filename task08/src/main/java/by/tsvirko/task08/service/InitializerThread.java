package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.MatrixResourceSingleton;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.entity.state.StateFabric;
import by.tsvirko.task08.service.exception.ServiceInitException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class InitializerThread extends Thread {
    private int initNumber;
    private int threadAmount;
    private MatrixResourceSingleton resource = MatrixResourceSingleton.getInstance();
    private ReentrantLock locker;

    public InitializerThread(ReentrantLock locker, int number, int threadAmount) {
        this.locker = locker;
        this.initNumber = number;
        this.threadAmount = threadAmount;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            StateFabric state = StateFabric.getState();
            int diagonalSize = resource.matrixDiagonalSize();
            for (int i = 0; i < diagonalSize; i++) {
                int j = 0;
                while (j != diagonalSize / threadAmount) {
                    MatrixItem element = resource.getPrincipalDiagonalElement(i);
                    if (!element.getState().equals(state.getStopState())) {
                        element.setState(state.getStopState());
                        resource.setPrincipalDiagonalElement(element.getI(), initNumber);
                        element.setState(state.getStopState());
                        System.out.println(Thread.currentThread().getName() + " changed " + i + ", " + j
                                + "with " + initNumber);
                        TimeUnit.MILLISECONDS.sleep(10);
                        j++;
                    }
                    i++;
                }
                break;
            }
        } catch (MatrixException | InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}

