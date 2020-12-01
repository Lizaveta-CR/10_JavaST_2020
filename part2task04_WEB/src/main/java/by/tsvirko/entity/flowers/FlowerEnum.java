package by.tsvirko.entity.flowers;

public enum FlowerEnum {
    FLOWERS("flowers"),
    WILD_GROWING("wild_growing"),
    CULTIVATED("cultivated"),
    ID("id"),
    SOIL("soil"),
    NAME("name"),
    ORIGIN("origin"),
    MULTIPLYING("multiplying"),
    LEAF_COLOR("leaf_color"),
    STEM_COLOR("stem_color"),
    SIZE("size"),
    TEMPERATURE("temperature"),
    LIGHT("light"),
    WATERING("watering"),
    LIFE_TERM("life_term"),
    FIRST_WATERING("first_watering"),
    VISUAL_PARAMETERS("visual_parameters"),
    GROWING_TIPS("growing_tips");
    private String field;

    FlowerEnum(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
