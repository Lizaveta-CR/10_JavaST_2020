package by.tsvirko.entity.orders;

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
}
