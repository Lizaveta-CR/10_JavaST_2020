package by.tsvirko.task09.entity.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component {
    private List<Component> components = new ArrayList<Component>();

    public void add(Component c) {
    }

    public Object getChild(int i) {
        return null;
    }

    public void remove(Component c) {
    }

    public String collect() {
        return null;
    }
}
