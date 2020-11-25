package by.tsvirko.entity.flowers;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WildGrowingFlower that = (WildGrowingFlower) o;
        return life_term == that.life_term;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), life_term);
    }
}
