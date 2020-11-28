package by.tsvirko.entity.orders;

import java.util.Objects;

public class Person {
    private String login;
    private String email;
    private long telephone;
    private Address address;
//    private List<Order> orders;

    public Person() {
        address = new Address();
//        orders = new ArrayList<>();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public long getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return telephone == person.telephone &&
                Objects.equals(login, person.login) &&
                Objects.equals(email, person.email) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, telephone, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                " login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", address=" + address +
                '}';
    }
}
