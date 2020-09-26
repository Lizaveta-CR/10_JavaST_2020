package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Ball;
import by.tsvirko.task03.entity.BallColour;
import by.tsvirko.task03.entity.Bucket;

import java.util.ArrayList;
import java.util.List;

public class FillBucket {
    private List<Ball> balls;
    private Bucket bucket;

    public FillBucket() {
        this.balls = new ArrayList<>();
        this.bucket = new Bucket();
    }

    public void fill(BallColour userColour, int ballWeight) {
        BallPriceCounter ballPriceCounter = new BallPriceCounter();
        double price = ballPriceCounter.countPrice(userColour, ballWeight);
        Ball userBall = new Ball(userColour, ballWeight, price);
        balls.add(userBall);
    }

    public Bucket finish() {
        bucket.setBalls(balls);
        return bucket;
    }
}
