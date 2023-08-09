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
        double result = calculatorUseCase.performOperation(1, 5, 3);
        assertEquals(8, result);

        result = calculatorUseCase.performOperation(1, -1230, 2930);
        assertEquals(1700, result);
    }

    @Test
    public void testSubtract() {
        double result = calculatorUseCase.performOperation(2, 8, 3);
        assertEquals(5, result);

        result = calculatorUseCase.performOperation(2, 10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        double result = calculatorUseCase.performOperation(3, 4, 3);
        assertEquals(12, result);

        result = calculatorUseCase.performOperation(3, 5, 4);
        assertEquals(20, result);
    }

    @Test
    public void testDivide() {
        double result = calculatorUseCase.performOperation(4, 10, 2);
        assertEquals(5, result);

        result = calculatorUseCase.performOperation(4, 899, 3);
        assertEquals(299.6666666666667, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatorUseCase.performOperation(4, 10, 0));
    }
}
