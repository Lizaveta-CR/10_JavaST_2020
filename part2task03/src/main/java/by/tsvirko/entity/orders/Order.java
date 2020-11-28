package by.tsvirko.entity.orders;

import java.util.*;

public class Order {
    private String id;
    private Date date;
    private Person person;
    private Set<Product> product;

    public Order() {
        product = new HashSet<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", person=" + person +
                ", product=" + product +
                '}';
    }
}
