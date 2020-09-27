package by.tsvirko.task03.view;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.entity.Bucket;
import by.tsvirko.task03.service.BucketService;

import java.util.*;

public class BallView {
    private final String STOP_WORD = "no";
    private Scanner scanner;
    private BallColour[] ballColours;
    private BucketService service;
    private List<Bucket> bucket;

    public BallView() {
        this.ballColours = BallColour.values();
        this.scanner = new Scanner(System.in);
        this.service = new BucketService();
        this.bucket = new ArrayList<>();
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

    public Bucket fillBallsView() {
        boolean needBall = true;
        while (needBall) {
            BallColour userColor = viewUserColour();
            int ballWeight = viewUserBallWeight();
            service.fill(userColor, ballWeight);
            System.out.println("Add one more ball (yes/no)?");
            String answer = scanner.next().toLowerCase();
            if (answer.equals(STOP_WORD)) {
                needBall = false;
                Bucket finishedBucked = service.finish();
                this.bucket.add(finishedBucked);
                return finishedBucked;
            } else {
                System.out.println("Enter one more ball: ");
            }
        }
        System.out.println("Your bucket is ready!");
        return null;
    }

    public void ballWeightAndColourView() {
        System.out.println("What colour would you like to count?");
        BallColour ballColour = viewUserColour();
        int colourAmount = service.countBallsColour(bucket.get(0), ballColour);
        double ballsWeight = service.countBallsWeight(bucket.get(0));
        System.out.println("Bucket's balls weight = " + ballsWeight
                + " Number of balls with " + ballColour.toString()
                + " = " + colourAmount);
    }

    public void sameBallsView() {
        int sameBallsAmount = service.countSameBalls(bucket.get(0));
        if (sameBallsAmount > 1) {
            System.out.println("There are " + sameBallsAmount + " same balls");
        } else {
            System.out.println("No same balls");
        }
    }

    public void ballsAscPrice() {
        List<Ball> balls = service.ballsInfoByPriceAsc(bucket.get(0));
        System.out.println("Balls in ascending order of price:  ");
        for (Ball ball : balls) {
            System.out.println(ball);
        }
    }

    public List<Bucket> createSeveralBuckets() {
        List<Bucket> buckets = new ArrayList<>();
        System.out.println("How many buckets do you want to create? (Enter number): ");
        int numberOfBuckets = scanner.nextInt();
        for (int i = 0; i < numberOfBuckets; i++) {
            System.out.println("Fill bucket");
            Bucket bucket = fillBallsView();
            buckets.add(bucket);
        }
        System.out.println("Buckets were created");
        return buckets;
    }

    public void showSameBallsBuckets() {
        int sameBucketsAmount = service.countSameBuckets();
        if (sameBucketsAmount > 1) {
            System.out.println("There are " + sameBucketsAmount + " same buckets");
        } else {
            System.out.println("No same buckets");
        }
    }
}