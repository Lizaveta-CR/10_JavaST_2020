package by.tsvirko.task08.service.fourthSolution;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.repository.MatrixRepository;
import by.tsvirko.task08.repository.MatrixRepositoryImpl;
import by.tsvirko.task08.service.ThreadInitServiceImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;

import java.util.concurrent.locks.ReentrantLock;

public class SolutionServiceFourth {
    private MatrixRepository repository = new MatrixRepositoryImpl();

    public Array compute(String fileName, int m) throws ServiceInitException, ArrayException, MatrixException {
        ReentrantLock lock = new ReentrantLock();
        Array array = new ThreadInitServiceImpl().init(fileName, m);
        int length = array.getLength();
        int i = 0;
        do {
            if (i == length) {
                ThreadInitializer initializer = new ThreadInitializer(0
                        , repository.getPrincipalDiagonal().getLength()
                        , array.getElement(length - 1), lock);
                initializer.start();
                try {
                    initializer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                ThreadInitializer thread = new ThreadInitializer(i
                        , repository.getPrincipalDiagonal().getLength() / length + i
                        , array.getElement(i), lock);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
        while (i != length + 1);
        return repository.getPrincipalDiagonal();
    }
}
