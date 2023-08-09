import usecases.DefaultUseCaseFactory;
import usecases.UseCaseFactory;
import view.CalculatorUI;

public class Main {
    public static void main(String[] args) {
        UseCaseFactory useCaseFactory = new DefaultUseCaseFactory();
        CalculatorUI calculatorUI = new CalculatorUI(useCaseFactory);
        calculatorUI.run();
    }
}
