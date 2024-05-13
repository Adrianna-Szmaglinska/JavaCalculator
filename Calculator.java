import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean startAgain = true;
        
        while (startAgain) {
            System.out.println("------------------------------");
            System.out.println("Welcome to Simple Calculator!\n");

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            System.out.println("Select operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0);
            
            double result = 0;
            
            switch(operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num1 != 0 && num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("\nError! Division by zero is not allowed.");
                        startAgain = askToStartAgain(scanner);
                        if (!startAgain) {
                            System.out.println("Goodbye!");
                            return;
                        }
                        continue;
                    }
                    break;
                default:
                    System.out.println("\nError! Invalid operation.");
                    startAgain = askToStartAgain(scanner);
                    if (!startAgain) {
                        System.out.println("\nGoodbye!");
                        return;
                    }
                    continue;
            }
            
            System.out.println("\n1Result: " + result);
            startAgain = askForAnotherCalculation(scanner);
        }
        
        scanner.close();
    }
    
    private static boolean askToStartAgain(Scanner scanner) {
        System.out.print("\nStart again? (y/n): ");
        String choice = scanner.next().toLowerCase();
        while (!choice.equals("y") && !choice.equals("n")) {
            System.out.print("\nInvalid response, please type \"y\" if you want to continue, and \"n\" if you want to exit: ");
            choice = scanner.next().toLowerCase();
        }

        return choice.equals("y");
    }
    
    private static boolean askForAnotherCalculation(Scanner scanner) {
        System.out.print("\nDo another calculation? (y/n): ");
        String choice = scanner.next().toLowerCase();
        while (!choice.equals("y") && !choice.equals("n")) {
            System.out.print("\nInvalid response, please type \"y\" if you want to continue, and \"n\" if you want to exit: ");
            choice = scanner.next().toLowerCase();
        }

        if(choice.equals("n")){
            System.out.println("\nGoodbye!");
        }

        return choice.equals("y");
    }
}
