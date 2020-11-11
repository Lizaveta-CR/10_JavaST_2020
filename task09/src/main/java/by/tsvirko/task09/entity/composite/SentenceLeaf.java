package by.tsvirko.task09.entity.composite;

public class SentenceLeaf implements Component {
    String sentence;

    public SentenceLeaf(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public Object getChild(int i) {
        if (i == 0) {
            return sentence;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String collect() {
        return sentence;
    }

    @Override
    public String toString() {
        return "SentenceLeaf{" +
                "sentence='" + sentence + '\'' +
                '}';
    }
}
