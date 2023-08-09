package usecases;

/**
 * The DefaultUseCaseFactory class implements the UseCaseFactory interface to create instances of use case classes.
 * It provides default implementations for creating calculator and trigonometric use cases.
 */
public class DefaultUseCaseFactory implements UseCaseFactory {
    /**
     * Creates a CalculatorUseCase instance.
     *
     * @return A CalculatorUseCase instance.
     */
    @Override
    public CalculatorUseCase createCalculatorUseCase() {
        return new CalculatorUseCase();
    }

    /**
     * Creates a TrigonometricUseCase instance.
     *
     * @return A TrigonometricUseCase instance.
     */
    @Override
    public TrigonometricUseCase createTrigonometricUseCase() {
        return new TrigonometricUseCase();
    }
}
