package org.demo.seminar07_20240612.code.contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private List<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void createContact(Contact contact) {
        contact.setId(nextId++);
        contacts.add(contact);
    }

    @Override
    public List<Contact> readAllContacts() {
        return contacts;
    }

    @Override
    public Contact readContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public void updateContact(int id, Contact contact) {
        Contact existingContact = readContact(id);
        if (existingContact != null) {
            existingContact.setName(contact.getName());
            existingContact.setPhoneNumber(contact.getPhoneNumber());
            existingContact.setEmail(contact.getEmail());
        }
    }

    @Override
    public void deleteContact(int id) {
        contacts.removeIf(contact -> contact.getId() == id);
    }
}
