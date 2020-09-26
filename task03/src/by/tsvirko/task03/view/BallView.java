package by.tsvirko.task03.view;

import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.entity.Bucket;
import by.tsvirko.task03.service.BucketService;
import by.tsvirko.task03.service.FillBucket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BallView {
    private final String STOP_WORD = "no";
    private Scanner scanner;
    private BallColour[] ballColours;
    private BucketService service;
    private Bucket bucket;

    public BallView() {
        this.ballColours = BallColour.values();
        this.scanner = new Scanner(System.in);
        this.service = new BucketService();
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

    public void fillBallsView() {
        FillBucket bucket = new FillBucket();
        boolean needBall = true;
        while (needBall) {
            BallColour userColor = viewUserColour();
            int ballWeight = viewUserBallWeight();
            bucket.fill(userColor, ballWeight);
            System.out.println("Add one more ball (yes/no)?");
            String answer = scanner.next().toLowerCase();
            if (answer.equals(STOP_WORD)) {
                this.bucket = bucket.finish();
                needBall = false;
            } else {
                System.out.println("Enter one more ball: ");
            }
        }
        System.out.println("Your bucket is ready!");
    }

    public void ballWeightAndColourView() {
        System.out.println("What colour would you like to count?");
        BallColour ballColour = viewUserColour();
        int colourAmount = service.countBallsColour(bucket, ballColour);
        double ballsWeight = service.countBallsWeight(bucket);
        System.out.println("Bucket's balls weight = " + ballsWeight
                + " Number of balls with " + ballColour.toString()
                + " = " + colourAmount);
    }

    public void sameBallsView() {
        int sameBallsAmount = service.countSameBalls(bucket);
        if (sameBallsAmount > 1) {
            System.out.println("There are " + sameBallsAmount + " same balls");
        } else {
            System.out.println("No same balls");
        }
    }
}