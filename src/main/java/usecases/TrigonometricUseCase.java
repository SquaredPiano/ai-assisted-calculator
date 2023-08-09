package usecases;

import java.util.HashMap;

public class TrigonometricUseCase {
    private final HashMap<Integer, TrigonometricOperation> operationStrategies;

    public TrigonometricUseCase() {
        operationStrategies = new HashMap<>();
        operationStrategies.put(5, new SineOperationStrategy());
        operationStrategies.put(6, new CosineOperationStrategy());
        operationStrategies.put(7, new TangentOperationStrategy());
    }

    public double performOperation(int operationChoice, double angle) {
        TrigonometricOperation strategy = operationStrategies.get(operationChoice);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid operation");
        }
        return strategy.execute(angle);
    }
}
