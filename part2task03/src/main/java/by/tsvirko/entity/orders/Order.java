package by.tsvirko.entity.orders;

import java.util.*;

public class Order {
    private String id;
    private Date date;
    private Person person;
    private Set<Product> products;

    public Order() {
        products = new HashSet<>();
        person = new Person();
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

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setProduct(Product product) {
        products.add(product);
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Person getPerson() {
        return person;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(date, order.date) &&
                Objects.equals(person, order.person) &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, person, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", person=" + person +
                ", product=" + products +
                '}';
    }
}
