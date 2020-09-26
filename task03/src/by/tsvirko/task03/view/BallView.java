package by.tsvirko.task03.view;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.service.BallPriceCounter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BallView {
    private BallColour[] ballColours;
    private Scanner scanner;

    public BallView() {
        this.ballColours = BallColour.values();
        this.scanner = new Scanner(System.in);
    }

    public BallColour viewUserColour() {
        System.out.println("Enter number: ");
        for (int i = 0; i < ballColours.length; i++) {
            System.out.println(i + "=" + ballColours[i]);
        }
        int userColorNum = scanner.nextInt();
        if (userColorNum > ballColours.length - 1) {
            throw new InputMismatchException();
        }
        return ballColours[userColorNum];

    }

    public int viewUserBallWeight() {
        System.out.println("Enter weight: ");
        return scanner.nextInt();
    }
}