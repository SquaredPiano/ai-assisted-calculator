package adapters;

import usecases.CalculatorUseCase;
import usecases.TrigonometricUseCase;

/**
 * The CalculatorFacadeImpl class implements the CalculatorFacade interface, providing a simplified interface for
 * performing arithmetic and trigonometric calculations. It delegates the actual calculation logic to use cases.
 */
public class CalculatorFacadeImpl implements CalculatorFacade {

    private final CalculatorUseCase calculatorUseCase;
    private final TrigonometricUseCase trigonometricUseCase;

    /**
     * Constructs a CalculatorFacadeImpl with the necessary use cases.
     *
     * @param calculatorUseCase     The use case for arithmetic calculations.
     * @param trigonometricUseCase  The use case for trigonometric calculations.
     */
    public CalculatorFacadeImpl(CalculatorUseCase calculatorUseCase, TrigonometricUseCase trigonometricUseCase) {
        this.calculatorUseCase = calculatorUseCase;
        this.trigonometricUseCase = trigonometricUseCase;
    }

    @Override
    public double performOperation(int operationChoice, double a, double b) {
        if (operationChoice >= 1 && operationChoice <= 4) {
            return calculatorUseCase.performOperation(operationChoice, a, b);
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
    }

    @Override
    public double performTrigonometricOperation(int operationChoice, double angle) {
        if (operationChoice >= 5 && operationChoice <= 7) {
            return trigonometricUseCase.performOperation(operationChoice, angle);
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
    }

}