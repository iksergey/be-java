package org.demo.summary05_20240621.code.core.models;

public class Contact {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullname() {
        return firstName + " " + lastName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Contact clone() {
        return new Contact(this.firstName, this.lastName);
    }

    @Override
    public boolean equals(Object obj) {
        Contact c = (Contact) obj;
        return c.firstName.equals(this.firstName)
                && c.lastName.equals(this.lastName);
    }

    @Override
    public String toString() {

        return getFullname();
    }
}
