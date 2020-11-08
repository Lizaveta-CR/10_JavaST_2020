package by.tsvirko.task08.service.thirdService;

import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.entity.firstSolution.MatrixResourceSingletonFirst;
import by.tsvirko.task08.entity.state.StateFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class InitializerThreadThird extends Thread {
    private static final Logger logger = LogManager.getLogger(InitializerThreadThird.class);

    private int initNumber;
    private int threadAmount;
    private MatrixResourceSingletonFirst resource = MatrixResourceSingletonFirst.getInstance();
    private Semaphore sem;

    public InitializerThreadThird() {
    }

    public InitializerThreadThird(Semaphore semaphore, int number, int threadAmount) {
        this.sem = semaphore;
        this.initNumber = number;
        this.threadAmount = threadAmount;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
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
                        logger.info(Thread.currentThread().getName() + " changed " + i + ", " + j
                                + "with " + initNumber);
                        TimeUnit.MILLISECONDS.sleep(10);
                        j++;
                    }
                    i++;
                }
                break;
            }
        } catch (MatrixException | InterruptedException ex) {
            logger.info("Exception happened");
        } finally {
            sem.release();
        }
    }
}

