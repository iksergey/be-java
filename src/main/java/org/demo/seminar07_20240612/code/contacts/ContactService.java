package org.demo.seminar07_20240612.code.contacts;

import java.util.List;

public interface ContactService {
    void createContact(Contact contact);

    List<Contact> readAllContacts();

    Contact readContact(int id);

    void updateContact(int id, Contact contact);

    void deleteContact(int id);
}
