package org.bank;

public class Transaction {

    private final String date;
    private final int amount;
    private final int balance;

    public Transaction(String date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String getFormattedTransaction() {
        return String.format("%s | %d | %d", date, amount, balance);
    }

    public int getAmount() {
        return amount;
    }
}
