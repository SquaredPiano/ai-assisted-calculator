package usecases;

public class AddUseCase implements CalculatorUseCase {
    @Override
    public double operate(double a, double b) {
        return a + b;
    }
}