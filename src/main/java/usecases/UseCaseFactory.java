package usecases;

public interface UseCaseFactory {
    CalculatorUseCase createCalculatorUseCase();
    TrigonometricUseCase createTrigonometricUseCase();
}