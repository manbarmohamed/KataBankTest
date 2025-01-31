package org.bank;

import java.util.Collections;
import java.util.List;

public class DisplayStatementPrinter implements StatementPrinter {
    @Override
    public void print(List<Transaction> transactions) {
        System.out.println("DATE | AMOUNT | BALANCE");
        Collections.reverse(transactions);
        transactions.forEach(t -> System.out.println(t.getFormattedTransaction()));
    }
}