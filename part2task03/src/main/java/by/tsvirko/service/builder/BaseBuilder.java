package by.tsvirko.service.builder;

import by.tsvirko.entity.Flower;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseBuilder {
    protected Set<Flower> flowers;

    public BaseBuilder() {
        this.flowers = new HashSet<>();
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public abstract void buildFlowers(String fileName);
}
