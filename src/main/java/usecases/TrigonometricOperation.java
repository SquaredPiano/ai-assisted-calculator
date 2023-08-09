package usecases;

/**
 * The TrigonometricOperation interface defines the contract for performing trigonometric calculations.
 * Implementing classes provide the logic for specific trigonometric operations.
 */
public interface TrigonometricOperation {

    /**
     * Executes a trigonometric operation on the provided angle.
     *
     * @param angle The angle in degrees for which to perform the trigonometric operation.
     * @return The result of the trigonometric operation.
     */
    double execute(double angle);
}
