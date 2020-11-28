package by.tsvirko.entity.orders;

import java.math.BigDecimal;

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

    @Override
    public String toString() {
        return "ProductItem{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                '}';
    }
}
