package view;

import adapters.CalculatorFacade;
import adapters.CalculatorFacadeImpl;
import usecases.DefaultUseCaseFactory;
import usecases.UseCaseFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame {
    private final CalculatorFacade calculatorFacade;
    private final JTextField displayField;
    private String currentOperator = "";
    private double previousResult = 0.0;
    private boolean isOperatorClicked = false;

    public CalculatorUI(CalculatorFacade calculatorFacade) {
        this.calculatorFacade = calculatorFacade;
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        // Create and layout components
        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+",
                "sin", "cos", "tan"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                if (isOperatorClicked) {
                    displayField.setText(command);
                    isOperatorClicked = false;
                } else {
                    displayField.setText(displayField.getText() + command);
                }
            } else if ("+-*/".contains(command)) {
                if (currentOperator.isEmpty()) {
                    currentOperator = command;
                    previousResult = Double.parseDouble(displayField.getText()); // Store the previous result
                    isOperatorClicked = true;
                }
            } else if ("sin".equals(command) || "cos".equals(command) || "tan".equals(command)) {
                performTrigonometricOperation(command);
            } else if (command.equals("=")) {
                if (!currentOperator.isEmpty()) {
                    double newValue = Double.parseDouble(displayField.getText());
                    double result = performArithmeticOperation(currentOperator, previousResult, newValue); // Use previousResult as the first operand
                    displayField.setText(String.valueOf(result));
                    currentOperator = "";
                    previousResult = result; // Store the result for chaining
                    isOperatorClicked = true;
                }
            } else if (command.equals("C")) {
                displayField.setText("");
                currentOperator = "";
                previousResult = 0.0; // Reset the previous result
                isOperatorClicked = false;
            }
        }
    }

    private double performArithmeticOperation(String operator, double a, double b) {
        return switch (operator) {
            case "+" -> calculatorFacade.performOperation(1, a, b, 0, 0);
            case "-" -> calculatorFacade.performOperation(2, a, b, 0, 0);
            case "*" -> calculatorFacade.performOperation(3, a, b, 0, 0);
            case "/" -> calculatorFacade.performOperation(4, a, b, 0, 0);
            default -> 0.0;
        };
    }

    private void performTrigonometricOperation(String operation) {
        try {
            String input = displayField.getText();
            double result;

            double angleDegrees = Double.parseDouble(input.trim());
            double angleRadians = Math.toRadians(angleDegrees);

            switch (operation) {
                case "sin" -> result = Math.sin(angleRadians);
                case "cos" -> result = Math.cos(angleRadians);
                case "tan" -> result = Math.tan(angleRadians);
                default -> {
                    displayField.setText("Invalid operation");
                    return;
                }
            }

            displayField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            displayField.setText("Invalid input");
        }
    }


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

