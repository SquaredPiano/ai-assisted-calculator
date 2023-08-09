package usecases;

public class TangentOperationStrategy implements TrigonometricOperation {
    @Override
    public double execute(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}
