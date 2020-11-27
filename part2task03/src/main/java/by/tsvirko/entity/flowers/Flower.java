package by.tsvirko.entity.flowers;

import java.util.*;

public class Flower {
    private String id;
    private String name;
    private Soil soil;
    private Set<String> multiplying;
    private String origin;
    private VisualParameters parameters;

    public Flower() {
        this.parameters = new VisualParameters();
        multiplying = new HashSet<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public void setMultiplying(Set<String> multiplying) {
        this.multiplying = multiplying;
    }

    public void setParameters(VisualParameters parameters) {
        this.parameters = parameters;
    }

    public void removeMultiplying() {
        multiplying.clear();
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Set<String> getMultiplying() {
        return multiplying;
    }

    public VisualParameters getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", soil=" + soil.value() +
                ", multiplying=" + multiplying +
                ", origin='" + origin + '\'' +
                ", parameters=" + parameters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Objects.equals(id, flower.id) &&
                Objects.equals(name, flower.name) &&
                soil == flower.soil &&
                Objects.equals(multiplying, flower.multiplying) &&
                Objects.equals(origin, flower.origin) &&
                Objects.equals(parameters, flower.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, soil, multiplying, origin, parameters);
    }
}


