package org.demo.seminar02_20240527.code.bankAccountExample.ex3;

public class Program {
    public static void main(String[] args) {
        Address address1 = new Address("Москва", "Россия", "101000", "ул. Пушкина", "10");
        User user1 = new User("Иван", "Иванов", address1);
        BankAccount account1 = new BankAccount(user1, 1000);

        account1.deposit(500);
        account1.withdraw(200);
        account1.addInterest(5);

        System.out.println(account1.getBalanceWithOwner());

        Address address2 = new Address("Санкт-Петербург", "Россия", "190000", "ул. Лермонтова", "20");
        user1.setAddress(address2);
        System.out.println("Новый адрес: " + user1.getAddress().getFullAddress());

        // Дополнительные проверки
        Address address3 = new Address("Казань", "Россия", "420000", "ул. Чехова", "15");
        User user2 = new User("Анна", "Сидорова", address3);
        BankAccount account2 = new BankAccount(user2, 2000);

        account2.deposit(-100); // Проверка на отрицательный депозит
        account2.withdraw(2500); // Проверка на снятие больше, чем баланс
        account2.addInterest(-3); // Проверка на отрицательную процентную ставку
    }
}
