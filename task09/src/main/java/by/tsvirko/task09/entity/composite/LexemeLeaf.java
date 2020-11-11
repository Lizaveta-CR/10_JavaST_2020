package by.tsvirko.task09.entity.composite;

public class LexemeLeaf implements Component {
    String lexeme;

    public LexemeLeaf(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public Object getChild(int i) {
        if (i == 0) {
            return lexeme;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String collect() {
        return lexeme;
    }

    @Override
    public String toString() {
        return "LexemeLeaf{" +
                "lexeme='" + lexeme + '\'' +
                '}';
    }
}
