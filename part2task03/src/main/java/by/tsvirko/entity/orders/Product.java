package by.tsvirko.entity.orders;

import java.util.Objects;

public class Product {
    private int amount;
    private ProductItem productItem;

    public Product() {
        productItem = new ProductItem();
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }

    public int getAmount() {
        return amount;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount &&
                Objects.equals(productItem, product.productItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, productItem);
    }

    @Override
    public String toString() {
        return "Product{" +
                "amount=" + amount +
                ", productItem=" + productItem +
                '}';
    }
}
