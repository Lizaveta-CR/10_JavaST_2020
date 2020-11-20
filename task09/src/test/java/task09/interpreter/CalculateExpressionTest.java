package task09.interpreter;

import by.tsvirko.task09.interpreter.CalculateExpression;
import by.tsvirko.task09.interpreter.exception.NoExpressionException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class CalculateExpressionTest {
    private CalculateExpression calculate;

    @DataProvider(name = "correct_data")
    public Object[] createCorrectData() {
        return new Object[][]{
                {"0", 0},
                {"12 << 1 | 11 | (12 >>> 3 ^ 2)", 12 << 1 | 11 | (12 >>> 3 ^ 2)},
                {"13<<2", 13 << 2},
                {"30>>>3", 30 >>> 3},
                {"~6&9|(3&4)", ~6 & 9 | (3 & 4)},
                {"5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)"
                        , 5 | (1 & 2 & (3 | (4 & (25 ^ 5 | 6 & 47) | 3) | 2) | 1)},
                {"(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78"
                        , (~71 & (2 & 3 | (3 | (2 & 1 >> 2 | 2) & 2) | 10 & 2)) | 78},
                {"(8^5|1&2<<(2|5>>2&71))|1200", (8 ^ 5 | 1 & 2 << (2 | 5 >> 2 & 71)) | 1200}
        };
    }

    @DataProvider(name = "incorrect_data")
    public Object[] createInCorrectData() {
        return new Object[]{
                "", null
        };
    }

    @Test(description = "Testing CalculateExpressions' parse() method",
            dataProvider = "correct_data")
    public void testCalculateCor(String expr, int result) throws NoExpressionException {
        calculate = new CalculateExpression(expr);
        int actual = this.calculate.calculate();
        int expected = result;

        assertEquals(actual, expected);
    }

    @Test(description = "Testing CalculateExpressions' parse() method",
            dataProvider = "incorrect_data")
    public void testCalculateInCor(String expr) {
        assertThrows(NoExpressionException.class, () -> new CalculateExpression(expr).calculate());
    }
}
