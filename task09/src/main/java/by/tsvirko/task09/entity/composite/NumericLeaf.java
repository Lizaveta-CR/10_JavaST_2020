package by.tsvirko.task09.entity.composite;

public class NumericLeaf implements Component<Integer> {

    private int value;

    public NumericLeaf(int value) {
        this.value = value;
    }

    public void add(Component c) {
        throw new UnsupportedOperationException();
    }

    public Object getChild(int i) {
        if (i == 0) {
            return value;
        }
        throw new UnsupportedOperationException();
    }

    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    public Integer collect() {
        return value;
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "NumericLeaf{" +
                "value=" + value +
                '}';
    }
}
