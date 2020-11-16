package by.tsvirko.task09.entity.composite;


public interface Component<T> {
    void add(Component c);

    Object getChild(int i);

    void remove(Component c);

    T collect();

    int getSize();
}
