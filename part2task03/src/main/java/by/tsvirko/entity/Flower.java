package by.tsvirko.entity;

public class Flower {
    private String id;
    private String name;
    private Soil soil;
    private String multiplying;
    private String origin;

    private VisualParameters parameters;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public void setParameters(VisualParameters parameters) {
        this.parameters = parameters;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", soil=" + soil.value() +
                ", multiplying='" + multiplying + '\'' +
                ", origin='" + origin + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}


