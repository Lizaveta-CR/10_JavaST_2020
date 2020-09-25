package by.tsvirko.task03.service;

public class BallPriceCounter {
    private double blueCoeff = 1.2;
    private double redCoeff = 1.3;
    private double greenCoeff = 1.4;
    private double purpleCoeff = 1.5;

    public double countPrice(BallColour colour, double weight) {
        switch (colour) {
            case BLUE:
                return weight * blueCoeff;
            case GREEN:
                return weight * greenCoeff;
            case PURPLE:
                return weight * purpleCoeff;
            case RED:
                return weight * redCoeff;
            default:
                return 0;
        }
    }
}
