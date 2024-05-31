package org.demo.seminar02_20240527.code.bankAccountExample.ex2;

public class BankAccount {
    private User user;
    private double balance;

    public BankAccount(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Сумма депозита должна быть положительной.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Недостаточно средств на счете.");
            }
        } else {
            System.out.println("Сумма снятия должна быть положительной.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceWithOwner() {
        return "Баланс счета " + user.getFullName() + ": " + balance;
    }

    public void addInterest(double rate) {
        if (rate > 0) {
            balance += balance * rate / 100;
        } else {
            System.out.println("Процентная ставка должна быть положительной.");
        }
    }
}
