package by.tsvirko.entity;

public class FlowerType {
    private String name;
    private String soil;
    private String multiplying;

    private VisualParameters parameters;

    public void setName(String name) {
        this.name = name;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public void setParameters(VisualParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "FlowerType{" +
                "name='" + name + '\'' +
                ", soil='" + soil + '\'' +
                ", multiplying='" + multiplying + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
