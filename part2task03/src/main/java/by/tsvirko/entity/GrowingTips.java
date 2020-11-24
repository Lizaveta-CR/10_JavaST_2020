package by.tsvirko.entity;

import java.util.Date;
public class GrowingTips {
    private int temperature;
    private String light;
    private Date first_watering;
    private double watering;

    public GrowingTips() {
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public void setFirst_watering(Date first_watering) {
        this.first_watering = first_watering;
    }

    public void setWatering(double watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        return "GrowingTips{" +
                "temperature=" + temperature +
                ", light='" + light + '\'' +
                ", first_watering=" + first_watering +
                ", watering=" + watering +
                '}';
    }
}
