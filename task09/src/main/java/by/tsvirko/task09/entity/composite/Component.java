package by.tsvirko.task09.entity.composite;

public interface Component {
    void add(Component c);

    Object getChild(int i);

    void remove(Component c);

    String collect();

    int getSize();
}
