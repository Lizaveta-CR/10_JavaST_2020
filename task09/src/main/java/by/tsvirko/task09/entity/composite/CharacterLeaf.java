package by.tsvirko.task09.entity.composite;

public class CharacterLeaf implements Component {
    private char character;

    public void add(Component c) {
//просто лог о ничего неделании
    }

    public Object getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public void remove(Component c) {

    }

    public String collect() {
        throw new UnsupportedOperationException();
    }
}
