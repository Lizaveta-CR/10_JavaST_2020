package by.tsvirko.entity.flowers;

public enum FlowerEnum {
    FLOWERS("flowers"),
    WILD_GROWING_FLOWER("wild_growing"),
    CULTIVATED_FLOWER("cultivated"),
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
    VISUAL_PARAMETERS("visual_parameters"),
    LIFE_TERM("life_term"),
    GROWING_TIPS("growing_tips"),
    FIRST_WATERING("first_watering");
    private String field;

    FlowerEnum(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
