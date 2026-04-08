package org.example;

import java.util.*;

public class BankingSystem{
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> transactionHistory = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequests = new LinkedList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runTask6();


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
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter username: ");
                String name = scanner.nextLine();
                System.out.print("Initial balance: ");
                double bal = scanner.nextDouble();
                String accNum = "ACC" + (int) (Math.random() * 1000);
                accountRequests.add(new BankAccount(accNum, name, bal));
                System.out.println("Request submitted to Admin queue.");
            }
            case 2 -> {
                BankAccount account = findAccount();
                if (account != null) {
                    System.out.print("Deposit amount: ");
                    double amount = scanner.nextDouble();
                    account.balance += amount;
                    transactionHistory.push("Deposit " + amount + " to " + account.username);
                    System.out.println("New balance: " + account.balance);
                }
            }
            case 3 -> {
                BankAccount account = findAccount();
                if (account != null) {
                    System.out.print("Withdraw amount: ");
                    double amount = scanner.nextDouble();
                    if (account.balance >= amount) {
                        account.balance -= amount;
                        transactionHistory.push("Withdraw " + amount + " from " + account.username);
                        System.out.println("New balance: " + account.balance);
                    } else {
                        System.out.println("Insufficient funds!");
                    }
                }
            }
            case 4 -> {
                System.out.print("Enter bill name (e.g., Electricity): ");
                String bill = scanner.nextLine();
                billQueue.add(bill);
                transactionHistory.push("Bill added: " + bill);
                System.out.println("Bill added to queue.");
            }
            case 5 -> {
                if (!transactionHistory.isEmpty()) {
                    System.out.println("Undo → " + transactionHistory.pop() + " removed");
                } else {
                    System.out.println("No transactions to undo.");
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
        System.out.println("\n--- ADMIN AREA ---");
        System.out.println("1. Process Account Requests (Queue -> LinkedList)");
        System.out.println("2. Process Bill Payments (FIFO)");
        System.out.println("3. View All Active Accounts");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                while (!accountRequests.isEmpty()) {
                    BankAccount req = accountRequests.poll();
                    accounts.add(req);
                    System.out.println("Approved account for: " + req.username);
                }
            }
            case 2 -> {
                if (!billQueue.isEmpty()) {
                    System.out.println("Processing: " + billQueue.poll());
                } else {
                    System.out.println("No bills to pay.");
                }
            }
            case 3 -> {
                System.out.println("Active Accounts:");
                for (int i = 0; i < accounts.size(); i++) {
                    System.out.println((i + 1) + ". " + accounts.get(i));
                }
            }
        }
    }


    static void runTask6() {
        System.out.println("Initializing predefined accounts (Array Task 6)...");
        BankAccount[] fixedAccounts = new BankAccount[3];
        fixedAccounts[0] = new BankAccount("101", "Ali", 150000);
        fixedAccounts[1] = new BankAccount("102", "Sara", 220000);
        fixedAccounts[2] = new BankAccount("103", "Ivan", 50000);

        Collections.addAll(accounts, fixedAccounts);
    }

    static BankAccount findAccount() {
        System.out.print("Enter username: ");
        String name = scanner.next();
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) return acc;
        }
        System.out.println("Account not found!");
        return null;
    }
}