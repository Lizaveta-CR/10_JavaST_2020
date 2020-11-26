package by.tsvirko.entity.flowers;

import java.util.Objects;

public class CultivatedFlower extends Flower {
    private GrowingTips tips;

    public CultivatedFlower() {
        this.tips = new GrowingTips();
    }

    public void setTips(GrowingTips tips) {
        this.tips = tips;
    }

    public GrowingTips getTips() {
        return tips;
    }

    @Override
    public String toString() {
        String string = super.toString();
        return string.concat(" ,").concat(tips.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CultivatedFlower that = (CultivatedFlower) o;
        return Objects.equals(tips, that.tips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tips);
    }
}
