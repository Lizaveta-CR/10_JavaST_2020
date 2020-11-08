package by.tsvirko.task08.service.fourthSolution;

import by.tsvirko.task08.entity.MatrixItem;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.entity.firstSolution.MatrixResourceSingletonFirst;
import by.tsvirko.task08.entity.state.StateFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadInitializer extends Thread {
    private static final Logger logger = LogManager.getLogger(ThreadInitializer.class);

    private int beginIndex;
    private int endIndex;
    private int value;
    private ReentrantLock lock;
    private MatrixResourceSingletonFirst resource = MatrixResourceSingletonFirst.getInstance();

    public ThreadInitializer(int beginIndex, int endIndex, int value, ReentrantLock lock) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.value = value;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            try {
                if (beginIndex == 0) {
                    initialize(beginIndex, endIndex);
                } else {
                    beginIndex += endIndex - 1;
                    endIndex += endIndex;
                    initialize(beginIndex, endIndex);
                }
            } catch (MatrixException e) {
            }
            TimeUnit.MILLISECONDS.sleep(100);
            logger.info(Thread.currentThread().getName() + "works");
        } catch (InterruptedException e) {
            logger.info("InterruptedException happened");
        } finally {
            lock.unlock();
        }

    }

    private void initialize(int beginIndex, int endIndex) throws MatrixException {
        for (int i = beginIndex; i < endIndex; i++) {
            MatrixItem item1 = resource.getPrincipalDiagonalElement(i);
            if (!item1.getState().equals(StateFabric.getState().getStopState())) {
                item1.setValue(value);
                item1.setState(StateFabric.getState().getStopState());
            }
        }
    }
}
