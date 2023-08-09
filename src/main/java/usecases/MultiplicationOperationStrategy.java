package usecases;

public class MultiplicationOperationStrategy extends ArithmeticOperation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}
