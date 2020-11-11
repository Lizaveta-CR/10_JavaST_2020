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

    public String collect() {
        String text = "";
        String delimiter = "";
        int size = components.size();
        for (int i = 0; i < size; i++) {
            Component component = components.get(i);
            String collectText = component.collect();
            if (component instanceof LexemeLeaf) {
                delimiter = Lexeme.LEXEME_DELIMITER;
            }
            if (component instanceof Sentence) {
                delimiter = Paragraph.PARAGRAPH_DELIMITER;
            }
//            if (component instanceof Paragraph) {
//                delimiter = Paragraph.PARAGRAPH_DELIMITER;
//            }
            text = text.concat(delimiter);
            text = text.concat(collectText);
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
