package usecases;

public class MultiplyUseCase implements CalculatorUseCase {
    @Override
    public double operate(double a, double b) {
        return a * b;
    }
}