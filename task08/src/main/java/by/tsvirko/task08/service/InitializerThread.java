package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.MatrixResourceSingleton;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.entity.state.StartState;
import by.tsvirko.task08.entity.state.StateFabric;
import by.tsvirko.task08.entity.state.StopState;
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
                        System.out.println(Thread.currentThread().getName() + "changed" + i + "," + j);
                        TimeUnit.MILLISECONDS.sleep(1000);
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

    public static void main(String[] args) throws ServiceInitException, MatrixException, ArrayException {
        Matrix matrix = new MatrixInitServiceImpl().init("matrix.txt", 2, 2);
        Array array = new ThreadInitServiceImpl().init("threadNumbers.txt", 2, 2);
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < array.getLength(); i++) {
            InitializerThread thread = new InitializerThread(locker, array.getElement(i), array.getLength());
            thread.setName("Thread " + i);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(matrix);
    }
}

