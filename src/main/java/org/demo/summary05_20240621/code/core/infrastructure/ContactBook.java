package org.demo.summary05_20240621.code.core.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.demo.summary05_20240621.code.core.models.Contact;

public class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<>();
    }

    public boolean add(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact.clone());
            return true;
        }
        return false;
    }

    public boolean remove(Contact contact) {
        if (contacts.indexOf(contact) != -1) {
            contacts.remove(contact.clone());
            return true;
        }
        return false;
    }

    public boolean contains(Contact contact) {
        return contacts.contains(contact);
    }

    public List<Contact> getAllContacts() {
        ArrayList<Contact> cont = new ArrayList<>();
        for (Contact contact : contacts) {
            cont.add(contact.clone());
        }
        return cont;
    }

    public Contact getContactByIndex(int index) {
        return contacts.get(index);
    }

    public int size() {
        return contacts.size();
    }

}
