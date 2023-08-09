package usecases;

/**
 * The SubtractOperationStrategy class extends ArithmeticOperation and represents a subtraction operation strategy.
 * It performs the subtraction of the second operand from the first operand.
 */
public class SubtractOperationStrategy extends ArithmeticOperation {

    /**
     * Executes the subtraction operation on the provided operands.
     *
     * @param a The minuend operand (the number to subtract from).
     * @param b The subtrahend operand (the number to subtract).
     * @return The result of subtracting the subtrahend from the minuend.
     */
    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}
