package usecases;

/**
 * The TangentOperationStrategy class implements the TrigonometricOperation interface and represents a tangent operation strategy.
 * It calculates the tangent of the provided angle in degrees.
 */
public class TangentOperationStrategy implements TrigonometricOperation {

    /**
     * Executes the tangent operation on the provided angle.
     *
     * @param angle The angle in degrees for which to calculate the tangent.
     * @return The tangent of the provided angle.
     */
    @Override
    public double execute(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}
