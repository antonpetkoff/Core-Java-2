package pack.calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCalculator {

    @Test
    public void testExpressions() {
        assertEquals(Calculator.evaluateExpression("2^3 + (5+3)^2^2"), "4104.0");
        assertEquals(Calculator.evaluateExpression("(2*3 + 1*3)!"), "362880.0");
        assertEquals(Calculator.evaluateExpression("2^3! + 5*((3+2!)^2)"), "189.0");
        assertEquals(Calculator.evaluateExpression("(2*3\\ + %%1*3__)!"), "362880.0");
    }

}
