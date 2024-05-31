package org.demo.seminar02_20240527.code.bankAccountExample.ex3;

public class Address {
    private String city;
    private String country;
    private String zipCode;
    private String street;
    private String house;

    public Address(String city, String country, String zipCode, String street, String house) {
        if (city.isEmpty() || country.isEmpty() || zipCode.isEmpty() || street.isEmpty() || house.isEmpty()) {
            throw new IllegalArgumentException("Все поля адреса должны быть заполнены.");
        }
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.street = street;
        this.house = house;
    }

    public String getFullAddress() {
        return street + ", " + house + ", " + city + ", " + country + ", " + zipCode;
    }
}
