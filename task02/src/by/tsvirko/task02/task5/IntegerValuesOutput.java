package by.tsvirko.task02.task5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerValuesOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter 2 numbers: ");
            int userNum1 = scanner.nextInt();
            int userNum2 = scanner.nextInt();
            System.out.println("Sum: " + sum(userNum1, userNum2)
                    + " Multiplication: " + mult(userNum1, userNum2));
        } catch (InputMismatchException e) {
            System.err.println("Only integers!");
        }
    }

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }

    private static int mult(int num1, int num2) {
        return num1 * num2;
    }
}
