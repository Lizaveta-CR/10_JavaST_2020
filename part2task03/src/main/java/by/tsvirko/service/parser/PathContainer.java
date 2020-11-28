package by.tsvirko.service.parser;

public enum PathContainer {
    FLOWERS_XML("flowers.xml"),
    FLOWERS_XSD("flowers.xsd"),
    ORDERS_XML("orders.xml"),
    ORDERS_XSD("orders.xsd");

    private String value;

    PathContainer(String value) {
        this.value = value;
    }

    public String getField() {
        return value;
    }
}
