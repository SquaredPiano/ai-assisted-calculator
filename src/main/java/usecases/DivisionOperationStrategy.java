package usecases;

/**
 * The DivisionOperationStrategy class extends ArithmeticOperation and represents a division operation strategy.
 * It performs the division of two operands.
 */
public class DivisionOperationStrategy extends ArithmeticOperation {
    /**
     * Executes the division operation on the provided operands.
     *
     * @param a The numerator operand.
     * @param b The denominator operand (non-zero).
     * @return The result of dividing the numerator by the denominator.
     * @throws ArithmeticException If the denominator is zero.
     */
    @Override
    public double execute(double a, double b) {
        if (b == 0){
            throw new IllegalArgumentException("Division By Zero");
        }
        return a / b;
    }
}
