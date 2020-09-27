package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.entity.Bucket;

import java.util.*;

public class BucketService {
    private BucketStorage storage;

    public BucketService() {
        this.storage = new BucketStorage();
    }

    public Ball fill(BallColour userColour, int ballWeight) {
        BallPriceCounter ballPriceCounter = new BallPriceCounter();
        double price = ballPriceCounter.countPrice(userColour, ballWeight);
        return new Ball(userColour, ballWeight, price);
    }

    public Bucket finish(List<Ball> balls) {
        Bucket bucket = new Bucket();
        bucket.setBalls(balls);
        storage.setBucket(bucket);
        return bucket;
    }

    public Map<Bucket, Double> countBallsWeight() {
        Map<Bucket, Double> bucketDoubleMap = new HashMap<>();
        List<Bucket> buckets = storage.getBuckets();
        for (Bucket bucket : buckets) {
            List<Ball> balls = bucket.getBalls();
            double totalWeight = 0;
            for (Ball ball : balls) {
                double weight = ball.getWeight();
                totalWeight += weight;
            }
            bucketDoubleMap.put(bucket, totalWeight);
        }
        return bucketDoubleMap;
    }

    public Map<Bucket, Integer> countBallsColour(BallColour ballColour) {
        Map<Bucket, Integer> bucketIntegerMap = new HashMap<>();
        List<Bucket> buckets = storage.getBuckets();
        for (Bucket bucket : buckets) {
            List<Ball> balls = bucket.getBalls();
            int count = 0;
            for (Ball ball : balls) {
                if (ball.getColour().equals(ballColour)) {
                    count++;
                }
            }
            bucketIntegerMap.put(bucket, count);
        }
        return bucketIntegerMap;
    }

    public Map<Bucket, Integer> countSameBalls() {
        Map<Bucket, Integer> bucketMap = new HashMap<>();
        List<Bucket> buckets = storage.getBuckets();
        for (Bucket bucket : buckets) {
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
            bucketMap.put(bucket, count);
        }
        return bucketMap;
    }

    public Map<Bucket, List<Ball>> ballsInfoByPriceAsc() {
        Map<Bucket, List<Ball>> bucketListMap = new HashMap<>();
        List<Bucket> buckets = storage.getBuckets();
        for (Bucket bucket : buckets) {
            List<Ball> balls = bucket.getBalls();
            Collections.sort(balls, new SortByPriceAsc());
            bucketListMap.put(bucket, balls);
        }
        return bucketListMap;
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
