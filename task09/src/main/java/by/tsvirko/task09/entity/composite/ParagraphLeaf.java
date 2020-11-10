package by.tsvirko.task09.entity.composite;

public class ParagraphLeaf implements Component {
    private String paragraph;

    public ParagraphLeaf(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void add(Component c) {
    }

    @Override
    public Object getChild(int i) {
        if (i == 0) {
            return paragraph;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String collect() {
        return paragraph;
    }

    @Override
    public String toString() {
        return "ParagraphLeaf{" +
                "paragraph='" + paragraph + '\'' +
                '}';
    }
}
