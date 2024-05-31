package org.demo.seminar02_20240527.code.bankAccountExample.ex1;

public class Program {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        System.out.println("Owner: " + account.getOwner());
        System.out.println("Balance: " + account.getBalance());

        account.deposit(500.0);
        account.withdraw(200.0);
        account.addInterest(5.0);

        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
