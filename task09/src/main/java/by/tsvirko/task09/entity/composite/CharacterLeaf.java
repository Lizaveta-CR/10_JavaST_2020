package by.tsvirko.task09.entity.composite;

/**
 * Leaf class (has no childes), which represent Character.
 */
public class CharacterLeaf implements Component<String> {

    private char character;

    public CharacterLeaf(char character) {
        this.character = character;
    }

    public void add(Component c) {
        throw new UnsupportedOperationException();
    }

    public Object getChild(int i) {
        if (i == 0) {
            return character;
        }
        throw new UnsupportedOperationException();
    }

    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    public String collect() {
        return Character.toString(character);
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "CharacterLeaf{" +
                "character=" + character +
                '}';
    }
}
