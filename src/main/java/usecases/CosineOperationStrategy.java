package usecases;

public class CosineOperationStrategy implements TrigonometricOperation {
    @Override
    public double execute(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}
