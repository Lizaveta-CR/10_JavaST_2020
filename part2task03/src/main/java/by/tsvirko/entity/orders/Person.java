package by.tsvirko.entity.orders;

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
