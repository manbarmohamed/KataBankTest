package org.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;
    private StatementPrinter printer;

    public Account(StatementPrinter printer) {
        this.printer = printer;
    }

    public void deposit(int amount, String date) {
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    public void withdraw(int amount, String date) {
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    public void printStatement() {
        printer.print(transactions);
    }
}
