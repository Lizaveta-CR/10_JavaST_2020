package by.tsvirko.entity;

public class WildGrowingFlower extends FlowerType {
    private int life_term;
    private String origin;

    public WildGrowingFlower() {
    }

    public void setLife_term(int life_term) {
        this.life_term = life_term;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
