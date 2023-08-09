package adapters;

/**
 * The CalculatorFacade interface defines a simplified interface for performing arithmetic and trigonometric calculations.
 * Implementing classes provide the actual calculation logic for these operations.
 */
public interface CalculatorFacade {

    /**
     * Performs arithmetic operations based on the provided operation choice.
     *
     * @param operationChoice The choice representing the arithmetic operation.
     * @param a               The first operand for the arithmetic operation.
     * @param b               The second operand for the arithmetic operation.
     * @return The result of the arithmetic operation.
     * @throws IllegalArgumentException If the operation choice is not recognized.
     */
    double performOperation(int operationChoice, double a, double b);

    /**
     * Performs trigonometric operations based on the provided operation choice.
     *
     * @param operationChoice The choice representing the trigonometric operation.
     * @param angle           The angle for the trigonometric operation.
     * @return The result of the trigonometric operation.
     * @throws IllegalArgumentException If the operation choice is not recognized.
     */
    double performTrigonometricOperation(int operationChoice, double angle);

}