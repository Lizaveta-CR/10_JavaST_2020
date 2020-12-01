package by.tsvirko.entity.orders;

import java.util.Objects;

public class Producer {
    private String name;
    private String country;
//    private List<ProductItem> productItems;

    public Producer() {
//        productItems = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(name, producer.name) &&
                Objects.equals(country, producer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
