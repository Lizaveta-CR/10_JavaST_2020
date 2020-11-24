package by.tsvirko.entity;

public class VisualParameters {
    private String stem_color;
    private String leaf_color;
    private int size;

    public VisualParameters() {
    }

    public void setStem_color(String stem_color) {
        this.stem_color = stem_color;
    }

    public void setLeaf_color(String leaf_color) {
        this.leaf_color = leaf_color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "stem_color='" + stem_color + '\'' +
                ", leaf_color='" + leaf_color + '\'' +
                ", size=" + size +
                '}';
    }
}
