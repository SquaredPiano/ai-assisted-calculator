package usecases;

/**
 * The AddOperationStrategy class extends ArithmeticOperation and represents an addition operation strategy.
 * It performs the addition of two operands.
 */
public class AddOperationStrategy extends ArithmeticOperation {

    /**
     * Executes the addition operation on the provided operands.
     *
     * @param a The first operand.
     * @param b The second operand.
     * @return The result of adding the two operands.
     */
    @Override
    public double execute(double a, double b) {
        return a + b;
    }

}
