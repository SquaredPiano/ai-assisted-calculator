package usecases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometricUseCaseTest {

    private static final double DELTA = 0.001; // Allowed difference for double comparisons
    private final TrigonometricUseCase trigonometricUseCase = new TrigonometricUseCase();

    @Test
    public void testSine() {
        double result = trigonometricUseCase.performOperation(5, 30);
        assertEquals(0.5, result, DELTA);
    }

    @Test
    public void testCosine() {
        double result = trigonometricUseCase.performOperation(6, 60);
        assertEquals(0.5, result, DELTA);
    }

    @Test
    public void testTangent() {
        double result = trigonometricUseCase.performOperation(7, 45);
        assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testSineWithNegativeAngle() {
        double result = trigonometricUseCase.performOperation(5, -30);
        assertEquals(-0.5, result, DELTA);
    }
}
