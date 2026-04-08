package org.example;
import java.util.*;

class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return username + " (№" + accountNumber + ") – Balance: " + balance;
    }
}

class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }
}


class MyStack {
    private String[] arr;
    private int capacity;
    private int top;

    public MyStack(int cap) {
        capacity = cap;
        arr = new String[capacity];
        top = -1;
    }

    public void push(String x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    public String pop() {
        if (top == -1) {
            return "No history";
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class MyQueue {
    private Node front, rear;

    public MyQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(Object data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public Object dequeue() {
        if (this.front == null) return null;
        Node temp = this.front;
        this.front = this.front.next;
        if (this.front == null) this.rear = null;
        return temp.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}