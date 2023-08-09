package usecases;

/**
 * The ArithmeticOperation class is an abstract base class that represents a generic arithmetic operation strategy.
 * Subclasses are expected to implement the execute method to perform specific arithmetic calculations.
 */
public abstract class ArithmeticOperation {
    /**
     * Executes the arithmetic operation on the provided operands.
     *
     * @param a The first operand.
     * @param b The second operand.
     * @return The result of the arithmetic operation.
     */
    public abstract double execute(double a, double b);
}