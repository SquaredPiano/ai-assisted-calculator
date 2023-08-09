package usecases;

public class SubtractUseCase implements CalculatorUseCase {
    @Override
    public double operate(double a, double b) {
        return a - b;
    }
}