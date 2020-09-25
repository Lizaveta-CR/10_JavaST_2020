package by.tsvirko.task03;

import java.util.Objects;

public class Ball {
    private BallColour colour;
    private int weight;
    private float price;

    public Ball(BallColour colour, int weight, float price) {
        this.colour = colour;
        this.weight = weight;
        this.price = price;
    }

    public BallColour getColour() {
        return colour;
    }

    public void setColour(BallColour colour) {
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return weight == ball.weight &&
                Float.compare(ball.price, price) == 0 &&
                colour == ball.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, weight, price);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "colour=" + colour +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
