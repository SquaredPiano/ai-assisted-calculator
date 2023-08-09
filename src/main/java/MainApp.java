import adapters.CalculatorFacade;
import adapters.CalculatorFacadeImpl;
import usecases.DefaultUseCaseFactory;
import usecases.UseCaseFactory;
import view.CalculatorUI;

import javax.swing.*;


public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UseCaseFactory useCaseFactory = new DefaultUseCaseFactory();
            CalculatorFacade calculatorFacade = new CalculatorFacadeImpl(
                    useCaseFactory.createCalculatorUseCase(),
                    useCaseFactory.createTrigonometricUseCase()
            );
            new CalculatorUI(calculatorFacade);
        });
    }
}

