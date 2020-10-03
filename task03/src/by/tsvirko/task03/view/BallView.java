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
    private BucketService bucketService;

    public BallView() {
        this.ballColours = BallColour.values();
        this.scanner = new Scanner(System.in);
        this.bucketService = new BucketService();
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
//TODO
    private int viewUserBallWeight() {
        System.out.println("Enter weight: ");
        return scanner.nextInt();
    }

    public Bucket fillBallsView() {
        List<Ball> balls = new ArrayList<>();
        boolean needBall = true;
        while (needBall) {
            BallColour userColor = viewUserColour();
            int ballWeight = viewUserBallWeight();
            Ball ball = bucketService.fill(userColor, ballWeight);
            balls.add(ball);
            System.out.println("Add one more ball (yes/no)?");
            String answer = scanner.next().toLowerCase();
            if (answer.equals(STOP_WORD)) {
                needBall = false;
                System.out.println("Your bucket is ready!");
                return bucketService.finish(balls);
            } else {
                System.out.println("Enter one more ball: ");
            }
        }
        return null;
    }
//TODO: different
    public void ballWeightAndColourView() {
        System.out.println("What colour would you like to count?");
        BallColour ballColour = viewUserColour();
        Map<Bucket, Integer> bucketIntegerMap = bucketService.countBallsColour(ballColour);
        for (Map.Entry<Bucket, Integer> bucketIntegerEntry : bucketIntegerMap.entrySet()) {
            System.out.println("Bucket " + bucketIntegerEntry.getKey() + " has "
                    + bucketIntegerEntry.getValue() + " ball(s) with " + ballColour.toString());
        }
        Map<Bucket, Double> bucketDoubleMap = bucketService.countBallsWeight();
        for (Map.Entry<Bucket, Double> bucketDoubleEntry : bucketDoubleMap.entrySet()) {
            System.out.println("Bucket's " + bucketDoubleEntry.getKey() + " balls total weight = "
                    + bucketDoubleEntry.getValue());
        }
    }

    public void sameBallsView() {
        Map<Bucket, Integer> bucketIntegerMap = bucketService.countSameBalls();
        for (Map.Entry<Bucket, Integer> bucketIntegerEntry : bucketIntegerMap.entrySet()) {
            if (bucketIntegerEntry.getValue() > 1) {
                System.out.println("Bucket " + bucketIntegerEntry.getKey()
                        + "has " + bucketIntegerEntry.getValue() + " same balls");

            } else {
                System.out.println("No same balls");
            }
        }
    }

    public void ballsAscPrice() {
        Map<Bucket, List<Ball>> bucketListMap = bucketService.ballsInfoByPriceAsc();
        for (Map.Entry<Bucket, List<Ball>> bucketListEntry : bucketListMap.entrySet()) {
            System.out.println("Balls in ascending order of price:  ");
            Bucket bucket = bucketListEntry.getKey();
            System.out.println(bucket + " 's balls:");
            List<Ball> value = bucketListEntry.getValue();
            value.forEach(System.out::println);
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
        int sameBucketsAmount = bucketService.countSameBuckets();
        if (sameBucketsAmount > 1) {
            System.out.println("There are " + sameBucketsAmount + " same buckets");
        } else {
            System.out.println("No same buckets");
        }
    }
}