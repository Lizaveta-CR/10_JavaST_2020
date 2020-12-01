package by.tsvirko.entity.orders;

import java.util.Objects;

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

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getApartment_number() {
        return apartment_number;
    }

    public int getHouse_number() {
        return house_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return apartment_number == address.apartment_number &&
                house_number == address.house_number &&
                Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, apartment_number, house_number);
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
