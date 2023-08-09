package usecases;

public class SineOperationStrategy implements TrigonometricOperation {
    @Override
    public double execute(double angle) {
        return Math.sin(Math.toRadians(angle));
    }
}
