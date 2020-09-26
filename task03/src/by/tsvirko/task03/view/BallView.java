package by.tsvirko.task03.view;

import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.service.FillBucket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BallView {
    private final String STOP_WORD = "no";
    private BallColour[] ballColours;
    private Scanner scanner;

    public BallView() {
        this.ballColours = BallColour.values();
        this.scanner = new Scanner(System.in);
    }

    private BallColour viewUserColour() {
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

    private int viewUserBallWeight() {
        System.out.println("Enter weight: ");
        return scanner.nextInt();
    }

    public void viewBallsFilling() {
        FillBucket bucket = new FillBucket();
        boolean needBall = true;
        while (needBall) {
            BallColour userColor = viewUserColour();
            int ballWeight = viewUserBallWeight();
            bucket.fill(userColor, ballWeight);
            System.out.println("Add one more ball (yes/no)?");
            String answer = scanner.next().toLowerCase();
            if (answer.equals(STOP_WORD)) {
                needBall = false;
                bucket.finish();
            } else {
                System.out.println("Enter one more ball: ");
            }
        }
    }
}