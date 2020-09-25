package by.tsvirko.task03.controller;

import by.tsvirko.task03.service.Ball;
import by.tsvirko.task03.service.BallColour;
import by.tsvirko.task03.service.BallPriceCounter;

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
            if (userColorNum > values.length-1) {
                throw new InputMismatchException();
            }
            System.out.println("Enter weight: ");
            int userWeightNum = scanner.nextInt();
            BallPriceCounter ballPriceCounter = new BallPriceCounter();
            for (int i = 0; i < values.length; i++) {
                if (userColorNum == i) {
                    Ball ball = new Ball(values[i], userWeightNum,
                            ballPriceCounter.countPrice(values[i], userWeightNum));
                    System.out.println(ball);
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Try again..");
        }
    }
}
