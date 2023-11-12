package lab06;

import java.util.Scanner;

public class AccountTest{

    public static void printBalances(Account acc1, Account acc2){
        System.out.printf("account1 balance: $%.2f%n", acc1.getBalance());
        System.out.printf("account2 balance: $%.2f\n", acc2.getBalance());
    }
    public static void main(String[] args) {
        Account account1 = new Account(50.00);
        Account account2 = new Account(8.93);
        // System.out.println(account1.getBalance());
        // System.out.println(account2.getBalance());
        printBalances(account1, account2);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount to credit to account1");
        double credit = input.nextDouble();
        account1.credit(credit);
        System.out.println("Enter amount to credit to account2");
        credit = input.nextDouble();
        account2.credit(credit);
        printBalances(account1, account2);

        System.out.println("Enter amount to debit to account1");
        double debit = input.nextDouble();
        account1.debit(debit);
        System.out.println("Enter amount to debit to account2");
        debit = input.nextDouble();
        account2.debit(debit);
        printBalances(account1, account2);
        System.out.printf("Total balance of all accounts is: %.2f", Account.getTotal());
        input.close();
    }
}