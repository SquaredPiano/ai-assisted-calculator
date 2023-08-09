/**
 * ActionListener implementation for handling button clicks in a calculator app.
 */
package adapters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    // Private fields for tracking calculator state
    private boolean isOperatorClicked = false;
    private String currentOperator = "";
    private double previousResult = 0.0;
    // Instance of CalculatorFacade for performing calculations
    private final CalculatorFacade calculatorFacade;
    // JTextField for displaying the calculator input and output
    private final JTextField displayField;

    public ButtonClickListener(CalculatorFacade calculatorFacade, JTextField displayField) {
        this.calculatorFacade = calculatorFacade;
        this.displayField = displayField;
    }

    /**
     * Handles button click events.
     *
     * @param e The ActionEvent triggered by the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            handleNumberInput(command);
        } else if ("+-*/".contains(command)) {
            handleOperator(command);
        } else if ("sin".equals(command) || "cos".equals(command) || "tan".equals(command)) {
            handleOperator(command);
        } else if (command.equals("=")) {
            handleEquals();
        } else if (command.equals("C")) {
            handleClear();
        }
    }

    /**
     * Handles numeric input.
     *
     * @param command The input digit as a String.
     */
    private void handleNumberInput(String command) {
        displayField.setText(displayField.getText() + command);
        if (!isOperatorClicked) {
            previousResult = Double.parseDouble(displayField.getText().trim());
        }
    }

    /**
     * Handles operator input (both arithmetic and trigonometric).
     *
     * @param operator The input operator as a String.
     */
    private void handleOperator(String operator) {
        if (!isOperatorClicked) {
            currentOperator = operator;
            if (operator.equals("sin") || operator.equals("cos") || operator.equals("tan")) {
                displayField.setText(operator + "(");
            } else {
                displayField.setText(displayField.getText() + operator);
            }
            isOperatorClicked = true;
        }
    }

    /**
     * Handles the "Equals" button click.
     */
    private void handleEquals() {
        if (isOperatorClicked) {
            if (currentOperator.equals("cos") || currentOperator.equals("sin") || currentOperator.equals("tan")) {
                double angleDegrees = Double.parseDouble(displayField.getText().trim().substring(4));
                double result = performTrigonometricOperation(currentOperator, angleDegrees);
                displayField.setText(String.valueOf(result));
                previousResult = result;
                currentOperator = "";
                isOperatorClicked = false;
            } else {
                double newValue = Double.parseDouble(displayField.getText().trim().substring(displayField.getText().lastIndexOf(currentOperator) + 1));
                double result = performArithmeticOperation(currentOperator, previousResult, newValue);
                displayField.setText(String.valueOf(result));
                currentOperator = "";
                previousResult = result;
                isOperatorClicked = false;
            }
        } else {
            displayField.setText(String.valueOf(previousResult));
        }
    }

    /**
     * Handles the "C" (Clear) button click.
     */
    private void handleClear() {
        displayField.setText("");
        currentOperator = "";
        previousResult = 0.0;
        isOperatorClicked = false;
    }

    /**
     * Returns the arithmetic operation result.
     */
    private double performArithmeticOperation(String operator, double a, double b) {
        if (operator.equals("+")) {
            return calculatorFacade.performOperation(1, a, b);
        } else if (operator.equals("-")) {
            return calculatorFacade.performOperation(2, a, b);
        } else if (operator.equals("*")) {
            return calculatorFacade.performOperation(3, a, b);
        } else {
            return calculatorFacade.performOperation(4, a, b);
        }
    }

    /**
     * Returns the trigonometric opertion result.
     */
    private double performTrigonometricOperation(String operation, double angle) {
        if (operation.equals("sin")) {
            return calculatorFacade.performTrigonometricOperation(5, angle);
        } else if (operation.equals("cos")) {
            return calculatorFacade.performTrigonometricOperation(6, angle);
        } else {
            return calculatorFacade.performTrigonometricOperation(7, angle);
        }
    }
}