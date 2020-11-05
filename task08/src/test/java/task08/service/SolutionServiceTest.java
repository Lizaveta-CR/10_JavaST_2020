package task08.service;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.InitializerThread;
import by.tsvirko.task08.service.MatrixInitServiceImpl;
import by.tsvirko.task08.service.SolutionService;
import by.tsvirko.task08.service.ThreadInitServiceImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SolutionServiceTest {
    private SolutionService solutionService = new SolutionService();

    @BeforeTest
    public void initStorage() throws ServiceInitException, MatrixException {
        new MatrixInitServiceImpl().init("matrix.txt", 5, 5);
    }

    @DataProvider(name = "correctData")
    public Object[] correctDataAnswer() {
        int[] ints = {1, 1, 2, 2, 666};
        return new Object[]{
                new Array(ints)};
    }

    @Test(description = "testing first solution initializing", dataProvider = "correctData")
    public void testIdCorrect(Array array) throws ServiceInitException, ArrayException, MatrixException {
        Array actual = solutionService.compute("threadNumbers.txt", 2, 2);
        Array expected = array;
        assertEquals(actual, expected);
    }
}
