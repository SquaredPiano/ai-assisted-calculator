package usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorUseCaseTest {

    private CalculatorUseCase calculatorUseCase;

    @BeforeEach
    public void setup() {
        calculatorUseCase = new CalculatorUseCase();
    }

    @Test
    public void testAdd() {
        double result = calculatorUseCase.add(5, 3);
        assertEquals(8, result);

        result = calculatorUseCase.add(-1230, 2930);
        assertEquals(1700, result);
    }

    @Test
    public void testSubtract() {
        double result = calculatorUseCase.subtract(8, 3);
        assertEquals(5, result);

        result = calculatorUseCase.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        double result = calculatorUseCase.multiply(4, 3);
        assertEquals(12, result);

        result = calculatorUseCase.multiply(5, 4);
        assertEquals(20, result);
    }

    @Test
    public void testDivide() {
        double result = calculatorUseCase.divide(10, 2);
        assertEquals(5, result);

        result = calculatorUseCase.divide(899, 3);
        assertEquals(299.6666666666667, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatorUseCase.divide(10, 0));
    }

    @Test
    public void testExponentiate() {
        double result = calculatorUseCase.exponentiate(2, 3);
        assertEquals(8, result);
        result = calculatorUseCase.exponentiate(4, 0.5);
        assertEquals(2, result);
    }

}
