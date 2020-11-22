package by.tsvirko.task09.entity;

import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;

/**
 * Singleton class, stores text
 */
public class TextStorage {
    private static TextStorage instance;
    private Composite text = new Text();

    public static TextStorage getInstance() {
        return (instance == null) ? instance = new TextStorage() : instance;
    }

    public void setComponent(Component component) {
        text.add(component);
    }

    public int size() {
        return text.getSize();
    }

    public Component getComponent(int childIndex) {
        return (Component) text.getChild(childIndex);
    }
}
