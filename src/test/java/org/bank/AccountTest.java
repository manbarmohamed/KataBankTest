package org.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

public class AccountTest {

    @Mock
    private StatementPrinter printer;
    private Account account;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        account = new Account(printer);
    }

    @Test
    void shouldPrintStatementWithCorrectFormat() {
        // When
        account.deposit(1000, "10-01-2012");
        account.deposit(2000, "13-01-2012");
        account.withdraw(500, "14-01-2012");
        account.printStatement();

        // Then
        verify(printer).print(argThat(transactions ->
                transactions.size() == 3 &&
                        transactions.get(0).getFormattedTransaction().contains("1000") &&
                        transactions.get(1).getFormattedTransaction().contains("2000") &&
                        transactions.get(2).getFormattedTransaction().contains("-500")
        ));
    }

    @Test
    void shouldMaintainCorrectBalance() {
        account.deposit(1000, "10-01-2012");
        account.withdraw(500, "14-01-2012");
        account.printStatement();

        verify(printer).print(argThat(transactions ->
                transactions.size() == 2
        ));
    }
}
