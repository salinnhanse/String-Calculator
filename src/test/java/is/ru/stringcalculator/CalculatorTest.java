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
    	assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
    	assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void testAnyNumbers() {
    	assertEquals(206, Calculator.add("23,1,58,38,2,52,32"));
    }

    @Test
    public void testNewLine() {
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testNegativeException() {
    	try {
    		assertEquals(3, Calculator.add("1,2,-3"));
    	}
    	catch (IllegalArgumentException i) {
    		System.out.println(i);
    	}
    }

    @Test
    public void testTallNumbers() {
    	assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testDiffDelimiter() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}
