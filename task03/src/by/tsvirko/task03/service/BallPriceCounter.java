package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.BallColour;

import java.math.BigDecimal;

public class BallPriceCounter {
    private double blueCoeff = 1.2;
    private double redCoeff = 1.3;
    private double greenCoeff = 1.4;
    private double purpleCoeff = 1.5;

    /**
     * Counts total ball's price
     *
     * @param colour
     * @param weight
     * @return ball's price
     */
    public BigDecimal countPrice(BallColour colour, double weight) {
        switch (colour) {
            case BLUE:
                return BigDecimal.valueOf(weight * blueCoeff);
            case GREEN:
                return BigDecimal.valueOf(weight * greenCoeff);
            case PURPLE:
                return BigDecimal.valueOf(weight * purpleCoeff);
            case RED:
                return BigDecimal.valueOf(weight * redCoeff);
            default:
                return BigDecimal.ZERO;
        }
    }
}
