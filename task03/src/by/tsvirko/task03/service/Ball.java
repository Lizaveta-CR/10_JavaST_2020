package by.tsvirko.task03.service;

import java.util.Objects;

public class Ball {
    private BallColour colour;
    private double weight;
    private double price;

    public Ball(BallColour colour, double weight, double price) {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                Double.compare(ball.price, price) == 0 &&
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
