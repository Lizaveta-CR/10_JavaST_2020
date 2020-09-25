package by.tsvirko.task03.controller;

import by.tsvirko.task03.service.BallColour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BallController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            BallColour[] values = BallColour.values();
            System.out.println("Enter number: ");
            for (int i = 0; i < values.length; i++) {
                System.out.println(i + "=" + values[i]);
            }
            int userColorNum = scanner.nextInt();
            System.out.println("Enter weight: ");
            int userWeightNum = scanner.nextInt();
            for (int i = 0; i < values.length; i++) {
                if (userColorNum == i) {
//               new Ball(values[i],)
                }
            }
        } catch (InputMismatchException e) {

        }

//        String answerYesNo = scanner.next();
//        if (answerYesNo ==)
    }
}
