package usecases;

import java.util.HashMap;

/**
 * The TrigonometricUseCase class represents the use case for performing trigonometric calculations.
 * It utilizes various operation strategies to execute different trigonometric operations.
 */
public class TrigonometricUseCase {
    private final HashMap<Integer, TrigonometricOperation> operationStrategies;

    /**
     * Constructs a TrigonometricUseCase and initializes the operation strategies for trigonometric calculations.
     */
    public TrigonometricUseCase() {
        operationStrategies = new HashMap<>();
        operationStrategies.put(5, new SineOperationStrategy());
        operationStrategies.put(6, new CosineOperationStrategy());
        operationStrategies.put(7, new TangentOperationStrategy());
    }

    /**
     * Performs a trigonometric operation based on the provided operation choice and angle.
     *
     * @param operationChoice The choice representing the trigonometric operation.
     * @param angle           The angle in degrees.
     * @return The result of the trigonometric operation.
     * @throws IllegalArgumentException If the operation choice is not recognized.
     */
    public double performOperation(int operationChoice, double angle) {
        TrigonometricOperation strategy = operationStrategies.get(operationChoice);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid operation");
        }
        return strategy.execute(angle);
    }
}
