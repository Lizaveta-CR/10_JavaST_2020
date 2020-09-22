package by.tsvirko.task02.task3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        try {
            Scanner scannerNum = new Scanner(System.in);
            System.out.println("Enter number");
            int userNumber = scannerNum.nextInt();
            if (userNumber < 0) {
                System.err.println("Only positive!");
            } else {
                int[] randomNumbers = randomNumbers(userNumber);
                Scanner scannerView = new Scanner(System.in);
                System.out.println("Press 1 - see numbers in one line\n" +
                        "Press 2 - new line");
                int numView = scannerView.nextInt();
                showNumbers(randomNumbers, numView);
            }
        } catch (InputMismatchException e) {
            System.err.println("Only numbers");
        }
    }

    private static int[] randomNumbers(int quantity) {
        if (quantity == 0) {
            throw new IllegalArgumentException("Not 0!");
        }
        int[] finalArr = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            finalArr[i] = i * i;
        }
        return finalArr;
    }

    private static void showNumbers(int[] numbers, int userNumView) {
        switch (userNumView) {
            case 1:
                System.out.println(Arrays.toString(numbers));
                break;
            case 2:
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println(numbers[i]);
                }
                break;
            default:
                throw new IllegalArgumentException("Only 1 or 2!");
        }
    }
}
