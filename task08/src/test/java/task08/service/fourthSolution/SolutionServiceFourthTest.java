package task08.service.fourthSolution;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.MatrixInitServiceImpl;
import by.tsvirko.task08.service.exception.ServiceInitException;
import by.tsvirko.task08.service.fourthSolution.SolutionServiceFourth;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SolutionServiceFourthTest {
    private SolutionServiceFourth solutionService = new SolutionServiceFourth();

    @BeforeTest
    public void initStorage() throws ServiceInitException, MatrixException {
        new MatrixInitServiceImpl().init("matrix.txt", 12);
    }

    @DataProvider(name = "correctData")
    public Object[] correctDataAnswer() {
        int[] ints1 = {1, 7, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        return new Object[]{
                new Array(ints1),
        };
    }

    @Test(description = "testing first solution", dataProvider = "correctData")
    public void testIdCorrect(Array array) throws ServiceInitException, ArrayException, MatrixException {
        Array actual = solutionService.compute("threadNumbers.txt", 7);
        Array expected = array;
        assertEquals(actual, expected);
    }
}
