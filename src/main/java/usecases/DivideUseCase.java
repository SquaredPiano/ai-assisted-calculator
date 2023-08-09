package usecases;

public class DivideUseCase implements CalculatorUseCase {
    @Override
    public double operate(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}