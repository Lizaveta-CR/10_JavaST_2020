package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.entity.Bucket;

import java.util.*;

public class BucketService {
    private List<Ball> ballsList;
    private BucketStorage storage;

    public BucketService() {
        this.storage = new BucketStorage();
        this.ballsList = new ArrayList<>();
    }

    public void fill(BallColour userColour, int ballWeight) {
        BallPriceCounter ballPriceCounter = new BallPriceCounter();
        double price = ballPriceCounter.countPrice(userColour, ballWeight);
        Ball userBall = new Ball(userColour, ballWeight, price);
        ballsList.add(userBall);
    }

    public Bucket finish() {
        Bucket bucket = new Bucket();
        bucket.setBalls(ballsList);
        storage.setBucket(bucket);
        return bucket;
    }

    public double countBallsWeight(Bucket bucket) {
        List<Ball> balls = bucket.getBalls();
        double totalWeight = 0;
        for (Ball ball : balls) {
            double weight = ball.getWeight();
            totalWeight += weight;
        }
        return totalWeight;
    }

    public int countBallsColour(Bucket bucket, BallColour ballColour) {
        List<Ball> balls = bucket.getBalls();
        int count = 0;
        for (Ball ball : balls) {
            if (ball.getColour().equals(ballColour)) {
                count++;
            }
        }
        return count;
    }

    public int countSameBalls(Bucket bucket) {
        List<Ball> balls = bucket.getBalls();
        Set<Ball> ballsSet = new HashSet<>();
        boolean flag;
        int count = 0;
        for (Ball ball : balls) {
            flag = ballsSet.add(ball);
            if (!flag) {
                count++;
            }
        }
        return count;
    }

    public List<Ball> ballsInfoByPriceAsc(Bucket bucket) {
        List<Ball> balls = bucket.getBalls();
        Collections.sort(balls, new SortByPriceAsc());
        return balls;
    }

    public int countSameBuckets() {
        List<Bucket> buckets = storage.getBuckets();
        Set<Bucket> bucketSet = new HashSet<>();
        boolean flag;
        int count = 0;
        for (Bucket bucket : buckets) {
            flag = bucketSet.add(bucket);
            if (!flag) {
                count++;
            }
        }
        return count;
    }
}
