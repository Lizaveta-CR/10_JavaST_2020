package task08.service.thirdSolution;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.MatrixInitServiceImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;
import by.tsvirko.task08.service.thirdService.SolutionServiceThird;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SolutionServiceThirdTest {
    private SolutionServiceThird serviceThird = new SolutionServiceThird();

    @BeforeTest
    public void initStorage() throws ServiceInitException, MatrixException {
        new MatrixInitServiceImpl().init("matrix.txt", 11);
    }

    @DataProvider(name = "correctData")
    public Object[] correctDataAnswer() {
        int[] ints = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
        return new Object[]{
                new Array(ints)};
    }

    @Test(description = "testing first solution", dataProvider = "correctData")
    public void testIdCorrect(Array array) throws ServiceInitException, ArrayException, MatrixException {
        Array actual = serviceThird.compute("threadNumbers.txt", 5);
        Array expected = array;
        assertEquals(actual, expected);
    }
}
