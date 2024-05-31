package org.demo.seminar02_20240527.code.bankAccountExample.ex2;

public class User {
    private String firstName;
    private String lastName;
    private String address;

    public User(String firstName, String lastName, String address) {
        if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty()) {
            throw new IllegalArgumentException("Имя, фамилия и адрес не должны быть пустыми.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setAddress(String newAddress) {
        if (!newAddress.isEmpty()) {
            this.address = newAddress;
        } else {
            System.out.println("Новый адрес не должен быть пустым.");
        }
    }

    public String getAddress() {
        return address;
    }
}
