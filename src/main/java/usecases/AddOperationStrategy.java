package usecases;

public class AddOperationStrategy extends ArithmeticOperation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}

