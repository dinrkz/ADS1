package org.example;
import java.util.Scanner;

public class BankingSystem {
    static MyQueue accountRequests = new MyQueue();
    static MyQueue billQueue = new MyQueue();
    static MyStack transactionHistory = new MyStack(100);
    static BankAccount[] accounts = new BankAccount[100];
    static int accountCount = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initAccounts();

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1 – Enter Bank (Operations)");
            System.out.println("2 – Enter ATM (Balance & Withdraw)");
            System.out.println("3 – Admin Area (Process Queues)");
            System.out.println("4 – Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void bankMenu() {
        System.out.println("\n--- BANK MENU ---");
        System.out.println("1. Request Account Opening");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Pay a Bill");
        System.out.println("5. Undo Last Action");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter username: ");
                String name = scanner.nextLine();
                System.out.print("Initial balance: ");
                double bal = scanner.nextDouble();
                String accNum = "ACC" + (int) (Math.random() * 1000);
                accountRequests.enqueue(new BankAccount(accNum, name, bal));
                System.out.println("Request added to Queue.");
            }
            case 2 -> {
                BankAccount acc = findAccount();
                if (acc != null) {
                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    acc.balance += amt;
                    transactionHistory.push("Deposit " + amt + " for " + acc.username);
                }
            }
            case 5 -> {
                if (!transactionHistory.isEmpty()) {
                    System.out.println("Undo: " + transactionHistory.pop());
                } else {
                    System.out.println("History empty.");
                }
            }
        }
    }

    static void atmMenu() {
        System.out.println("\n--- ATM MENU ---");
        BankAccount account = findAccount();
        if (account != null) {
            System.out.println("1. Check Balance");
            System.out.println("2. Quick Withdraw 5000");
            int choice = scanner.nextInt();
            if (choice == 1) System.out.println("Balance: " + account.balance);
            else if (choice == 2) {
                account.balance -= 5000;
                System.out.println("Done. New balance: " + account.balance);
            }
        }
    }

    static void adminMenu() {
        System.out.println("\n--- ADMIN ---");
        System.out.println("1. Process Account Requests");
        System.out.println("2. View All Accounts");
        int choice = scanner.nextInt();

        if (choice == 1) {
            while (!accountRequests.isEmpty()) {
                BankAccount b = (BankAccount) accountRequests.dequeue();
                accounts[accountCount++] = b;
                System.out.println("Account created for " + b.username);
            }
        } else if (choice == 2) {
            for (int i = 0; i < accountCount; i++) {
                System.out.println(accounts[i]);
            }
        }
    }

    static void initAccounts() {
        accounts[accountCount++] = new BankAccount("101", "Ali", 150000);
        accounts[accountCount++] = new BankAccount("102", "Sara", 220000);
    }


    static BankAccount findAccount() {
        System.out.print("Username: ");
        String name = scanner.next();
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].username.equalsIgnoreCase(name)) return accounts[i];
        }
        return null;
    }
}