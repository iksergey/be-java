package org.demo.summary05_20240621.code.client;

import org.demo.summary05_20240621.code.core.infrastructure.ContactBook;
import org.demo.summary05_20240621.code.core.models.Contact;

public class Program {
    public static void main(String[] args) {
        // 0x12345
        Contact contact = new Contact("Вася", "Пупкин");
        Contact contact2 = new Contact("Маша", "Пупкина");

        ContactBook facebook = new ContactBook();
        ContactBook google = new ContactBook();
        System.out.println(facebook.add(contact));
        System.out.println(google.add(contact));
        System.out.println(google.add(contact2));

        System.out.println("facebook " + facebook.getAllContacts());
        System.out.println("google " + google.getAllContacts());

        facebook.getContactByIndex(0).firstName = "John";

        System.out.println("facebook " + facebook.getAllContacts());
        System.out.println("google " + google.getAllContacts());

        google.remove(new Contact("Маша", "Пупкина"));
        System.out.println("google " + google.getAllContacts());

        // System.out.println(cb.add(contact2));

        // System.out.println(cb.size());

        // System.out.println(cb.remove(new Contact("Раз", "Три")));
        // System.out.println(cb.size());
    }
}
