package by.tsvirko.entity.orders;

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

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
