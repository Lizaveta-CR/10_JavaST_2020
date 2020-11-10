package by.tsvirko.task09.entity.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Composite implements Component {
    private List<Component> components = new ArrayList<Component>();

    public void add(Component c) {
        components.add(c);
    }

    public Object getChild(int i) {
        return components.get(i);
    }

    public void remove(Component c) {
        components.remove(c);
    }

    public int size() {
        return components.size();
    }

    public String collect() {
        String text = "";
        int size = components.size();
        for (int i = 0; i < size; i++) {
            Component component = components.get(i);
            text = text.concat(component.collect());
            text = text.concat(Paragraph.PARAGRAPH_DELIMITER);
        }
        return text;
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}
