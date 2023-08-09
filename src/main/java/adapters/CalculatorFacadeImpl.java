package adapters;

import usecases.CalculatorUseCase;
import usecases.TrigonometricUseCase;

public class CalculatorFacadeImpl implements CalculatorFacade {
    private final CalculatorUseCase calculatorUseCase;
    private final TrigonometricUseCase trigonometricUseCase;

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