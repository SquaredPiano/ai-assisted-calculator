package view;

import usecases.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;


import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorUI {
    private final Scanner scanner;
    private final UseCaseFactory useCaseFactory;

    public CalculatorUI(UseCaseFactory useCaseFactory) {
        scanner = new Scanner(System.in);
        this.useCaseFactory = useCaseFactory;
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exponentiate");
            System.out.println("6. Sine");
            System.out.println("7. Cosine");
            System.out.println("8. Tangent");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 8) {
                    if (choice >= 1 && choice <= 5) {
                        performCalculatorOperation(choice);
                    } else {
                        performTrigonometricOperation(choice);
                    }
                } else if (choice == 9) {
                    running = false;
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private void performCalculatorOperation(int choice) {
        CalculatorUseCase calculatorUseCase = useCaseFactory.createCalculatorUseCase();
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            double result;
            switch (choice) {
                case 1:
                    result = calculatorUseCase.add(a, b);
                    break;
                case 2:
                    result = calculatorUseCase.subtract(a, b);
                    break;
                case 3:
                    result = calculatorUseCase.multiply(a, b);
                    break;
                case 4:
                    result = calculatorUseCase.divide(a, b);
                    break;
                case 5:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    result = calculatorUseCase.exponentiate(base, exponent);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation");
            }

            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private void performTrigonometricOperation(int choice) {
        TrigonometricUseCase trigonometricUseCase = useCaseFactory.createTrigonometricUseCase();
        DoubleUnaryOperator operation = null;
        String operationName = "";

        switch (choice) {
            case 6:
                operation = trigonometricUseCase::sine;
                operationName = "Sine";
                break;
            case 7:
                operation = trigonometricUseCase::cosine;
                operationName = "Cosine";
                break;
            case 8:
                operation = trigonometricUseCase::tangent;
                operationName = "Tangent";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        try {
            System.out.print("Enter angle in degrees: ");
            double angle = scanner.nextDouble();

            double result = operation.applyAsDouble(angle);
            System.out.println(operationName + " Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        UseCaseFactory useCaseFactory = new DefaultUseCaseFactory();
        CalculatorUI calculatorUI = new CalculatorUI(useCaseFactory);
        calculatorUI.run();
    }
}
