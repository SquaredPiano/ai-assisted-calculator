package view;

import adapters.ButtonClickListener;
import adapters.CalculatorFacade;
import adapters.CalculatorFacadeImpl;
import usecases.DefaultUseCaseFactory;
import usecases.UseCaseFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CalculatorUI extends JFrame {
    private final CalculatorFacade calculatorFacade;
    private final JTextField displayField;

    public CalculatorUI(CalculatorFacade calculatorFacade) {
        this.calculatorFacade = calculatorFacade;

        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

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

        ButtonClickListener buttonClickListener = new ButtonClickListener(calculatorFacade, displayField);

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(buttonClickListener);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
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

