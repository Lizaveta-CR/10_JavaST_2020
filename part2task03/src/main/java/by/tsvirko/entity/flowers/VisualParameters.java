package by.tsvirko.entity.flowers;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisualParameters that = (VisualParameters) o;
        return size == that.size &&
                Objects.equals(stem_color, that.stem_color) &&
                Objects.equals(leaf_color, that.leaf_color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stem_color, leaf_color, size);
    }
}
