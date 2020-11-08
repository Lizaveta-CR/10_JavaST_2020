package by.tsvirko.task08.service.firstService;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.repository.MatrixRepository;
import by.tsvirko.task08.repository.MatrixRepositoryImpl;
import by.tsvirko.task08.service.ThreadInitServiceImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class SolutionService {
    private MatrixRepository repository = new MatrixRepositoryImpl();

    public Array compute(String fileName, int m) throws ServiceInitException, ArrayException, MatrixException {
        ReentrantLock lock = new ReentrantLock();
        Array array = (Array) new ThreadInitServiceImpl().init(fileName, m);
        for (int i = 0; i < array.getLength(); i++) {
            InitializerThread thread = new InitializerThread(lock, array.getElement(i), array.getLength());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        new ThreadController().control();
        return repository.getPrincipalDiagonal();
    }
}
