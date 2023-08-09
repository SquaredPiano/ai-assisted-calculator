package usecases;

/**
 * The CosineOperationStrategy class implements the TrigonometricOperation interface and represents a cosine operation strategy.
 * It calculates the cosine of the provided angle in degrees.
 */
public class CosineOperationStrategy implements TrigonometricOperation {
    /**
     * Executes the cosine operation on the provided angle.
     *
     * @param angle The angle in degrees for which to calculate the cosine.
     * @return The cosine of the provided angle.
     */
    @Override
    public double execute(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}
