package adapters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ButtonClickListener implements ActionListener {
    private boolean isOperatorClicked = false;
    private String currentOperator = "";
    private double previousResult = 0.0;
    private final CalculatorFacade calculatorFacade;
    private final JTextField displayField;
    private HashMap<String, Integer> operatorMap = new HashMap<>();
    {
        operatorMap.put("+", 1);
        operatorMap.put("-", 2);
        operatorMap.put("*", 3);
        operatorMap.put("/", 4);
        operatorMap.put("sin", 5);
        operatorMap.put("cos", 6);
        operatorMap.put("tan", 7);
    }

    public ButtonClickListener(CalculatorFacade calculatorFacade, JTextField displayField) {
        this.calculatorFacade = calculatorFacade;
        this.displayField = displayField;
    }

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

    private void handleNumberInput(String command) {
        displayField.setText(displayField.getText() + command);
        if (!isOperatorClicked) {
            previousResult = Double.parseDouble(displayField.getText().trim());
        }
    }

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

    private void handleClear() {
        displayField.setText("");
        currentOperator = "";
        previousResult = 0.0;
        isOperatorClicked = false;
    }

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