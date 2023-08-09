package usecases;

public class ExponentiateUseCase implements CalculatorUseCase {
    @Override
    public double operate(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}