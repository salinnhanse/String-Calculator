package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testEmptyString() {
	assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber() {
    	assertEquals(42, Calculator.add("42"));
    }

    @Test
    public void testTwoNumbers() {
    	assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void testAnyNumbers() {
    	assertEquals(206, Calculator.add("23,1,58,38,2,52,32"));
    }
}
