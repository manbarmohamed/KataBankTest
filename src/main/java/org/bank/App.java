package org.bank;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StatementPrinter printer = new DisplayStatementPrinter();
        Account account = new Account(printer);

        account.deposit(1000, "10-01-2012");
        account.deposit(2000, "13-01-2012");
        account.withdraw(500, "14-01-2012");

        account.printStatement();
    }
}
