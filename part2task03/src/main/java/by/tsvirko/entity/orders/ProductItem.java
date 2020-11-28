package by.tsvirko.entity.orders;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductItem {
    private String type;
    private BigDecimal price;
    private Producer producer;

    public ProductItem() {
        producer = new Producer();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Producer getProducer() {
        return producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductItem that = (ProductItem) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(price, that.price) &&
                Objects.equals(producer, that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, producer);
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                '}';
    }
}
