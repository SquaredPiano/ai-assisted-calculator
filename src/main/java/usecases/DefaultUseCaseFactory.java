package usecases;

public class DefaultUseCaseFactory implements UseCaseFactory {
    @Override
    public CalculatorUseCase createCalculatorUseCase() {
        return new CalculatorUseCase();
    }

    @Override
    public TrigonometricUseCase createTrigonometricUseCase() {
        return new TrigonometricUseCase();
    }
}
