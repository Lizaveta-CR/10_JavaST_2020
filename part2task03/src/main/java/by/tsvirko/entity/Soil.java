package by.tsvirko.entity;

public enum Soil {
    GROUND("ground"),
    PODZOLIC("podzolic"),
    SOD_PODZOLIC("sod-podzolic");

    private final String value;

    Soil(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static Soil getSoil(String value) {
        for (Soil currentEnum : Soil.values()) {
            if (currentEnum.value.equals(value)) {
                return currentEnum;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
