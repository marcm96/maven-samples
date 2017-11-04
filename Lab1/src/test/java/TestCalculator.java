import model.Calculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCalculator {

    private Calculator calculator = new Calculator();

    @Test
    public void testAddition(){
        double left = 1;
        double right = 1;
        String sign = "+";

        double result = calculator.calculate(left, right, sign);
        assertEquals(2.0, result);
    }

    @Test
    public void testSubtraction(){
        double left = 3;
        double right = 1;
        String sign = "-";

        double result = calculator.calculate(left, right, sign);
        assertEquals(2.0, result);
    }

    @Test
    public void testMultiplication(){
        double left = 2;
        double right = 1;
        String sign = "*";

        double result = calculator.calculate(left, right, sign);
        assertEquals(2.0, result);
    }

    @Test
    public void testDivision(){
        double left = 2.5;
        double right = 2.5;
        String sign = "/";

        double result = calculator.calculate(left, right, sign);
        assertEquals(2.0, result);
    }
}
