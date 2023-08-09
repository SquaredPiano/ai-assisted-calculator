package view;

import usecases.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorUI {
    private final Scanner scanner;

    public CalculatorUI() {
        scanner = new Scanner(System.in);
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
                    CalculatorUseCase useCase = null;
                    if (choice <= 5) {
                        useCase = createUseCase(choice);
                    } else {
                        performTrigonometricOperation(choice);
                    }
                    if (useCase != null) {
                        performOperation(useCase);
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

    private CalculatorUseCase createUseCase(int choice) {
        switch (choice) {
            case 1:
                return new AddUseCase();
            case 2:
                return new SubtractUseCase();
            case 3:
                return new MultiplyUseCase();
            case 4:
                return new DivideUseCase();
            case 5:
                return new ExponentiateUseCase();
            default:
                return null;
        }
    }


    private void performOperation(CalculatorUseCase useCase) {
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        double result;

        try {
            result = useCase.operate(a, b);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void performTrigonometricOperation(int choice) {
        TrigonometricUseCase useCase = createTrigonometricUseCase(choice);
        if (useCase != null) {
            try {
                System.out.print("Enter angle in degrees: ");
                double angle = scanner.nextDouble();

                double result = useCase.operate(angle);
                System.out.println("Result: " + result);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private TrigonometricUseCase createTrigonometricUseCase(int choice) {
        switch (choice) {
            case 6:
                return new SineUseCase();
            case 7:
                return new CosineUseCase();
            case 8:
                return new TangentUseCase();
            default:
                return null;
        }
    }
}