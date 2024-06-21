package org.demo.summary05_20240621.code.core.mvp;

import org.demo.summary05_20240621.code.core.infrastructure.ContactBook;
import org.demo.summary05_20240621.code.core.models.Contact;

import java.io.*;

public class Model {

    ContactBook currentBook;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentBook = new ContactBook();
        currentIndex = 0;
        this.path = path;
    }

    public Contact currentContact() {
        if (currentIndex >= 0) {
            return currentBook.getContact(currentIndex);
        } else {
            return null;
        }
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String fname = reader.readLine();
            while (fname != null) {
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                this.currentBook.add(new Contact(firstName, lastName));
                fname = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    public void save() {

        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBook.size(); i++) {
                Contact contact = currentBook.getContact(i);
                writer.append(String.format("%s\n", contact.getFirstName()));
                writer.append(String.format("%s\n", contact.getLastName()));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ContactBook currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}
