package by.tsvirko.entity.orders;

public class Address {
    private String country;
    private String city;
    private String street;
    private int apartment_number;
    private int house_number;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setApartment_number(int apartment_number) {
        this.apartment_number = apartment_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", apartment_number=" + apartment_number +
                ", house_number=" + house_number +
                '}';
    }
}
