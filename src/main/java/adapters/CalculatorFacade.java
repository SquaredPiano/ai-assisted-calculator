package adapters;

public interface CalculatorFacade {
    double performOperation(int operationChoice, double a, double b);
    double performTrigonometricOperation(int operationChoice, double angle);

}