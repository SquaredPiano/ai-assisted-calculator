package usecases;

/**
 * The UseCaseFactory interface defines a factory contract for creating instances of calculator and trigonometric use cases.
 * Implementing classes provide concrete implementations for creating these use cases.
 */
public interface UseCaseFactory {

    /**
     * Creates a CalculatorUseCase instance.
     *
     * @return A CalculatorUseCase instance.
     */
    CalculatorUseCase createCalculatorUseCase();

    /**
     * Creates a TrigonometricUseCase instance.
     *
     * @return A TrigonometricUseCase instance.
     */
    TrigonometricUseCase createTrigonometricUseCase();
}