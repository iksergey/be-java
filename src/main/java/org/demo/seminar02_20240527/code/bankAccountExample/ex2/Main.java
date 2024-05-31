package org.demo.seminar02_20240527.code.bankAccountExample.ex2;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Иван", "Иванов", "ул. Пушкина, д. 10");
        BankAccount account1 = new BankAccount(user1, 1000);

        account1.deposit(500);
        account1.withdraw(200);
        account1.addInterest(5);

        System.out.println(account1.getBalanceWithOwner());

        user1.setAddress("ул. Лермонтова, д. 20");
        System.out.println("Новый адрес: " + user1.getAddress());

        // Дополнительные проверки
        User user2 = new User("Анна", "Сидорова", "ул. Чехова, д. 15");
        BankAccount account2 = new BankAccount(user2, 2000);

        account2.deposit(-100); // Проверка на отрицательный депозит
        account2.withdraw(2500); // Проверка на снятие больше, чем баланс
        account2.addInterest(-3); // Проверка на отрицательную процентную ставку
    }
}
