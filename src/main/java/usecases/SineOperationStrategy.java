package usecases;

/**
 * The SineOperationStrategy class implements the TrigonometricOperation interface and represents a sine operation strategy.
 * It calculates the sine of the provided angle in degrees.
 */
public class SineOperationStrategy implements TrigonometricOperation {

    /**
     * Executes the sine operation on the provided angle.
     *
     * @param angle The angle in degrees for which to calculate the sine.
     * @return The sine of the provided angle.
     */
    @Override
    public double execute(double angle) {
        return Math.sin(Math.toRadians(angle));
    }
}
