package adapters;

import usecases.CalculatorUseCase;
import usecases.TrigonometricUseCase;

public class CalculatorFacadeImpl implements CalculatorFacade {
    private double accumulatedResult = 0.0;
    private final CalculatorUseCase calculatorUseCase;
    private final TrigonometricUseCase trigonometricUseCase;

    public CalculatorFacadeImpl(CalculatorUseCase calculatorUseCase, TrigonometricUseCase trigonometricUseCase) {
        this.calculatorUseCase = calculatorUseCase;
        this.trigonometricUseCase = trigonometricUseCase;
    }

    @Override
    public double performOperation(int operationChoice, double a, double b, double base, double exponent) {
        double result = switch (operationChoice) {
            case 1 -> calculatorUseCase.add(a, b);
            case 2 -> calculatorUseCase.subtract(a, b);
            case 3 -> calculatorUseCase.multiply(a, b);
            case 4 -> calculatorUseCase.divide(a, b);
            case 5 -> calculatorUseCase.exponentiate(base, exponent);
            default -> throw new IllegalArgumentException("Invalid operation");
        };

        accumulatedResult = result;
        return result;
    }

    @Override
    public double getAccumulatedResult() {
        return accumulatedResult;
    }

    @Override
    public double performTrigonometricOperation(int operationChoice, double angle) {
        double result = switch (operationChoice) {
            case 6 -> trigonometricUseCase.sine(angle);
            case 7 -> trigonometricUseCase.cosine(angle);
            case 8 -> trigonometricUseCase.tangent(angle);
            default -> throw new IllegalArgumentException("Invalid operation");
        };

        accumulatedResult = result;
        return result;
    }
}