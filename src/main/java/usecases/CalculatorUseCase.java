package usecases;

import java.util.HashMap;

public class CalculatorUseCase {
    private final HashMap<Integer, ArithmeticOperation> operationStrategies;

    public CalculatorUseCase() {
        operationStrategies = new HashMap<>();
        operationStrategies.put(1, new AddOperationStrategy());
        operationStrategies.put(2, new SubtractOperationStrategy());
        operationStrategies.put(3, new MultiplicationOperationStrategy());
        operationStrategies.put(4, new DivisionOperationStrategy());
    }

    public double performOperation(int operationChoice, double a, double b) {
        ArithmeticOperation strategy = operationStrategies.get(operationChoice);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid operation");
        }
        return strategy.execute(a, b);
    }
}