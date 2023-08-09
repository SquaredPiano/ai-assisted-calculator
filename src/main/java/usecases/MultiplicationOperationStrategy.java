package usecases;

/**
 * The MultiplicationOperationStrategy class extends ArithmeticOperation and represents a multiplication operation strategy.
 * It performs the multiplication of two operands.
 */
public class MultiplicationOperationStrategy extends ArithmeticOperation {

    /**
     * Executes the multiplication operation on the provided operands.
     *
     * @param a The first operand.
     * @param b The second operand.
     * @return The result of multiplying the two operands.
     */
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}
