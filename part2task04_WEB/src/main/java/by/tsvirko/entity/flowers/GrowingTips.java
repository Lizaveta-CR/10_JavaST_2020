package by.tsvirko.entity.flowers;

import java.util.Date;
import java.util.Objects;

public class GrowingTips {
    private int temperature;
    private boolean light;
    private Date first_watering;
    private double watering;

    public GrowingTips() {
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public void setFirst_watering(Date first_watering) {
        this.first_watering = first_watering;
    }

    public void setWatering(double watering) {
        this.watering = watering;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isLight() {
        return light;
    }

    public Date getFirst_watering() {
        return first_watering;
    }

    public double getWatering() {
        return watering;
    }

    @Override
    public String toString() {
        return "GrowingTips{" +
                "temperature=" + temperature +
                ", light=" + light +
                ", first_watering=" + first_watering +
                ", watering=" + watering +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowingTips that = (GrowingTips) o;
        return temperature == that.temperature &&
                light == that.light &&
                Double.compare(that.watering, watering) == 0 &&
                Objects.equals(first_watering, that.first_watering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, light, first_watering, watering);
    }
}
