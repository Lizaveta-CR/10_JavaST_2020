package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.entity.Bucket;

import java.math.BigDecimal;
import java.util.*;

public class BucketService {
    private BucketStorage storage;

    public BucketService() {
        this.storage = new BucketStorage();
    }

    public Ball fill(BallColour userColour, int ballWeight) {
        BallPriceCounter ballPriceCounter = new BallPriceCounter();
        BigDecimal price = ballPriceCounter.countPrice(userColour, ballWeight);
        if (ballWeight <= 0 || price.compareTo(BigDecimal.ZERO) == 0) {
            throw new InputMismatchException();
        }
        return new Ball(userColour, ballWeight, price);
    }

    /**
     * This method finishes creating bucket
     *
     * @param balls
     * @return bucket
     */
    public Bucket finishBucketCreating(List<Ball> balls) {
        Bucket bucket = new Bucket();
        bucket.setBalls(balls);
        storage.setBucket(bucket);
        return bucket;
    }

    /**
     * Counts total ball's weight in basket, using Basket Storage
     *
     * @return Map<Bucket, Double>, where Basket is our basket and
     * Double represents total weight
     */
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

    /**
     * Counts balls with same colour
     *
     * @param ballColour
     * @return Map<Bucket, Integer>, where Integer represents number of coincidences
     */
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

    /**
     * Counts same balls in every Basket in Basket Storage
     *
     * @return Map<Bucket, Integer>, where Integer represents number of coincidences
     */
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

    /**
     * Sorts Balls in Basket Storage by price
     *
     * @return Map<Bucket, List < Ball>>, where List<Ball> is our balls in ascending order
     */
    public Map<Bucket, List<Ball>> ballsInfoByPriceAsc() {
        Map<Bucket, List<Ball>> bucketListMap = new HashMap<>();
        List<Bucket> buckets = storage.getBuckets();
        for (Bucket bucket : buckets) {
            List<Ball> balls = bucket.getBalls();
            Collections.sort(balls, new PriceComparator());
            bucketListMap.put(bucket, balls);
        }
        return bucketListMap;
    }

    /**
     * Counts same Baskets in Basket Storage
     *
     * @return int - number of same baskets
     */
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
