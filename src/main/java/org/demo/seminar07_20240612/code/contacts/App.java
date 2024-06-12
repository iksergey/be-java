package org.demo.seminar07_20240612.code.contacts;

import java.util.List;
import java.util.Scanner;

public class App {
    private static ContactService contactService = new ContactServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            System.out.println("1. Создать контакт");
            System.out.println("2. Показать все контакты");
            System.out.println("3. Показать контакт");
            System.out.println("4. Обновить контакт");
            System.out.println("5. Удалить контакт");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createContact();
                    break;
                case 2:
                    readAllContacts();
                    break;
                case 3:
                    readContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void createContact() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        contactService.createContact(contact);
        System.out.println("Контакт создан.");
    }

    private static void readAllContacts() {
        List<Contact> contacts = contactService.readAllContacts();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void readContact() {
        System.out.print("Введите id контакта: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Contact contact = contactService.readContact(id);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    private static void updateContact() {
        System.out.print("Введите id контакта: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Contact existingContact = contactService.readContact(id);
        if (existingContact != null) {
            System.out.print("Введите новое имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите новый номер телефона: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Введите новый email: ");
            String email = scanner.nextLine();
            Contact updatedContact = new Contact();
            updatedContact.setName(name);
            updatedContact.setPhoneNumber(phoneNumber);
            updatedContact.setEmail(email);
            contactService.updateContact(id, updatedContact);
            System.out.println("Контакт обновлен.");
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    private static void deleteContact() {
        System.out.print("Введите id контакта: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        contactService.deleteContact(id);
        System.out.println("Контакт удален.");
    }
}
