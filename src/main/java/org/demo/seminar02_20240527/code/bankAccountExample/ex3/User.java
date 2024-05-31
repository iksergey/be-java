package org.demo.seminar02_20240527.code.bankAccountExample.ex3;

public class User {
    private String firstName;
    private String lastName;
    private Address userAddress;

    public User(String firstName, String lastName, Address userAddress) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Имя и фамилия не должны быть пустыми.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
    }

    public String getFullName() {
        return "Полное имя: " + firstName + " " + lastName + ", Адрес: " + userAddress.getFullAddress();
    }

    public void setAddress(Address newAddress) {
        this.userAddress = newAddress;
    }

    public Address getAddress() {
        return userAddress;
    }
}
