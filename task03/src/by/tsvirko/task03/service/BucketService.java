package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.entity.Bucket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BucketService {
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
}
