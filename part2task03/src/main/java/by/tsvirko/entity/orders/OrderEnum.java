package by.tsvirko.entity.orders;

public enum OrderEnum {
    ORDERS("orders"),
    ORDER("order"),
    PERSON("person"),
    EMAIL("email"),
    TELEPHONE("telephone"),
    ADDRESS("address"),
    COUNTRY("country"),
    CITY("city"),
    STREET("street"),
    APARTAMENT_NUMBER("apartment_number"),
    HOUSE_NUMBER("house_number"),
    ADDRESS_ID("address_id"),
    PERSON_ID("person_id"),
    LOGIN("login"),
    PRODUCTS("products"),
    AMOUNT("amount"),
    PRODUCT("product"),
    TYPE("type"),
    PRICE("price"),
    PRODUCER("producer"),
    PRODUCER_NAME("producer_name"),
    PRODUCER_COUNTRY("producer_country"),
    ORDER_ID("order_id"),
    ORDER_DATE("order_date");

    private String field;

    OrderEnum(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
