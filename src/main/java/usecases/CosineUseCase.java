package usecases;

public class CosineUseCase implements TrigonometricUseCase {
    @Override
    public double operate(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}
