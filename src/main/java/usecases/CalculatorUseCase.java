package usecases;

import java.util.HashMap;

/**
 * The CalculatorUseCase class represents the use case for performing arithmetic calculations.
 * It utilizes various operation strategies to execute different arithmetic operations.
 */
public class CalculatorUseCase {
    private final HashMap<Integer, ArithmeticOperation> operationStrategies;

    /**
     * Constructs a CalculatorUseCase and initializes the operation strategies for arithmetic calculations.
     */
    public CalculatorUseCase() {
        operationStrategies = new HashMap<>();
        operationStrategies.put(1, new AddOperationStrategy());
        operationStrategies.put(2, new SubtractOperationStrategy());
        operationStrategies.put(3, new MultiplicationOperationStrategy());
        operationStrategies.put(4, new DivisionOperationStrategy());
    }

    /**
     * Performs an arithmetic operation based on the provided operation choice.
     *
     * @param operationChoice The choice representing the arithmetic operation.
     * @param a               The first operand.
     * @param b               The second operand.
     * @return The result of the arithmetic operation.
     * @throws IllegalArgumentException If the operation choice is not recognized.
     */
    public double performOperation(int operationChoice, double a, double b) {
        ArithmeticOperation strategy = operationStrategies.get(operationChoice);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid operation");
        }
        return strategy.execute(a, b);
    }
}