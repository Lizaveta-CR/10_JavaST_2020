package by.tsvirko.task03.entity;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Objects;

public class Ball {
    private BallColour colour;
    private double weight;
    private BigDecimal price;

    public Ball(BallColour colour, double weight, BigDecimal price) {
        if (weight <= 0 || price.compareTo(BigDecimal.ZERO) == 0) {
            throw new InputMismatchException();
        }
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                colour == ball.colour &&
                Objects.equals(price, ball.price);
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
                ", price=" + String.format("%2.1f", price) +
                '}';
    }
}
