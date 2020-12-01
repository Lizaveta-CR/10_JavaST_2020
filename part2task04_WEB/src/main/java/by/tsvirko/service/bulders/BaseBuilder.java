package by.tsvirko.service.bulders;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseBuilder<T> {
    protected Set<T> items;

    public BaseBuilder() {
        this.items = new HashSet<>();
    }

    public Set<T> getItems() {
        return items;
    }

    public abstract void build();
}
