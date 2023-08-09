package usecases;

public class SineUseCase implements TrigonometricUseCase {
    @Override
    public double operate(double angle) {
        return Math.sin(Math.toRadians(angle));
    }
}