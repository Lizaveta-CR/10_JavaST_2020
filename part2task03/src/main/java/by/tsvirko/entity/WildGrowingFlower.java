package by.tsvirko.entity;

public class WildGrowingFlower extends Flower {
    private int life_term;

    public WildGrowingFlower() {
    }

    public void setLife_term(int life_term) {
        this.life_term = life_term;
    }

    @Override
    public String toString() {
        return super.toString().concat(", life_term=" + life_term);
    }
}
