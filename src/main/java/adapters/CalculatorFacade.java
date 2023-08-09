package adapters;

public interface CalculatorFacade {
    double performOperation(int operationChoice, double a, double b, double base, double exponent);
    double performTrigonometricOperation(int operationChoice, double angle);

    double getAccumulatedResult();
}