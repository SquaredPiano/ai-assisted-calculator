package usecases;

public class DivisionOperationStrategy extends ArithmeticOperation {
    @Override
    public double execute(double a, double b) {
        return a / b;
    }
}
