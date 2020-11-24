package by.tsvirko.entity;

public class CultivatedFlower extends FlowerType {
    private GrowingTips tips;

    public CultivatedFlower() {
    }

    public void setTips(GrowingTips tips) {
        this.tips = tips;
    }


    @Override
    public String toString() {
        String string = super.toString();
        return string.concat(" ,").concat(tips.toString());
    }
}
