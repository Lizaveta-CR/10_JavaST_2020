package by.tsvirko.task09.entity.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Composite implements Component {
    private static final Logger logger = LogManager.getLogger(Composite.class);

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
            if (component instanceof CharacterComp) {
                delimiter = Lexeme.LEXEME_DELIMITER;
            }
            if (component instanceof Sentence) {
                collectText = collectText.replaceFirst("(?: )+", "");
                if (i != 0) {
                    delimiter = Paragraph.PARAGRAPH_DELIMITER;
                }
            }

            if (component instanceof Paragraph) {
                collectText = collectText.replaceFirst("", "\t\t");
            }
            text = text.concat(delimiter);
            text = text.concat(collectText);
        }
        logger.info("Text was collected");
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

    public static void main(String[] args) {
        String text = " kkkkk";
        text = text.replaceFirst("(?: )+", "");
        System.out.println(text);
    }
}
