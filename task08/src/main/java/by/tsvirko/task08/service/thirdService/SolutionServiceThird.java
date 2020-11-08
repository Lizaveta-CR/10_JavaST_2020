package by.tsvirko.task08.service.thirdService;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.Matrix;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.repository.MatrixRepository;
import by.tsvirko.task08.repository.MatrixRepositoryImpl;
import by.tsvirko.task08.service.MatrixInitServiceImpl;
import by.tsvirko.task08.service.ThreadInitServiceImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;
import by.tsvirko.task08.service.firstService.ThreadController;

import java.util.concurrent.Semaphore;

public class SolutionServiceThird {
    private MatrixRepository repository = new MatrixRepositoryImpl();

    public Array compute(String fileName, int m) throws ServiceInitException, ArrayException, MatrixException {
        Array array = (Array) new ThreadInitServiceImpl().init(fileName, m);
        Semaphore sem = new Semaphore(1);
        int length = array.getLength();
        int i = 0;
        do {
            if (i == length) {
                InitializerThreadThird initializer = new InitializerThreadThird(sem, array.getElement(length - 1), array.getLength());
                initializer.start();
                try {
                    initializer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                InitializerThreadThird thread = new InitializerThreadThird(sem, array.getElement(i), array.getLength());
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
        new ThreadController().control();
        return repository.getPrincipalDiagonal();
    }
}
