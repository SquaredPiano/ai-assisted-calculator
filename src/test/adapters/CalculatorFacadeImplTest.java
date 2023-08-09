package adapters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.CalculatorUseCase;
import usecases.TrigonometricUseCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorFacadeImplTest {

    private CalculatorFacade calculatorFacade;

    @BeforeEach
    public void setup() {
        CalculatorUseCase calculatorUseCase = new CalculatorUseCase();
        TrigonometricUseCase trigonometricUseCase = new TrigonometricUseCase();

        calculatorFacade = new CalculatorFacadeImpl(calculatorUseCase, trigonometricUseCase);
    }

    @Test
    public void testPerformOperation_Add() {
        double result = calculatorFacade.performOperation(1, 5, 3, 0, 0);
        assertEquals(8, result);
    }

    @Test
    public void testPerformOperation_Subtract() {
        double result = calculatorFacade.performOperation(2, 8, 3, 0, 0);
        assertEquals(5, result);
    }

    @Test
    public void testPerformOperation_Multiply() {
        double result = calculatorFacade.performOperation(3, 4, 3, 0, 0);
        assertEquals(12, result);
    }

    @Test
    public void testPerformOperation_Divide() {
        double result = calculatorFacade.performOperation(4, 10, 2, 0, 0);
        assertEquals(5, result);
    }

    @Test
    public void testPerformTrigonometricOperation_Sine() {
        double result = calculatorFacade.performTrigonometricOperation(6, 30);
        assertEquals(0.5, result, 0.001);
    }

    @Test
    public void testPerformTrigonometricOperation_Cosine() {
        double result = calculatorFacade.performTrigonometricOperation(7, 60);
        assertEquals(0.5, result, 0.001);
    }

    @Test
    public void testPerformTrigonometricOperation_Tangent() {
        double result = calculatorFacade.performTrigonometricOperation(8, 45);
        assertEquals(1, result, 0.001);
    }

}
