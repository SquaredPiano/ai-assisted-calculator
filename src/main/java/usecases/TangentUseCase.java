package usecases;

public class TangentUseCase implements TrigonometricUseCase {
    @Override
    public double operate(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}
