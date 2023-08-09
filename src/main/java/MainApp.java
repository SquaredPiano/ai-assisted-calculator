import adapters.CalculatorFacade;
import adapters.CalculatorFacadeImpl;
import usecases.DefaultUseCaseFactory;
import usecases.UseCaseFactory;
import view.CalculatorUI;

import javax.swing.*;

/**
 * The MainApp class serves as the entry point for the calculator application.
 * It initializes the application components and sets up the graphical user interface.
 */
public class MainApp {

    /**
     * The main method to start the calculator application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure GUI components are created on the event dispatch thread.
        SwingUtilities.invokeLater(() -> {
            // Create a use case factory to produce calculator and trigonometric use cases.
            UseCaseFactory useCaseFactory = new DefaultUseCaseFactory();

            // Create a calculator facade using the use case factory.
            CalculatorFacade calculatorFacade = new CalculatorFacadeImpl(
                    useCaseFactory.createCalculatorUseCase(),
                    useCaseFactory.createTrigonometricUseCase()
            );

            // Initialize the calculator user interface with the calculator facade.
            new CalculatorUI(calculatorFacade);
        });
    }
}

