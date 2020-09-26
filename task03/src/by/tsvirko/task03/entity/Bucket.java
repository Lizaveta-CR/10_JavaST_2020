package by.tsvirko.task03.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bucket {
    private List<Ball> balls;

    public Bucket() {
    }

    public Bucket(List<Ball> balls) {
        this.balls = new ArrayList<>();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(balls, bucket.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "balls=" + balls +
                '}';
    }
}
