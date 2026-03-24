package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Task 1: Print Digits (5481) ---");
        printDigits(5481);

        System.out.println("\n--- Task 2: Average (4 elements: 3 2 4 1) ---");
        int[] arr = {3, 2, 4, 1};
        System.out.println(findSum(arr, 4) / 4.0);

        System.out.println("\n--- Task 3: Prime Check (7 and 10) ---");
        System.out.println("7 is " + (isPrime(7, 2) ? "Prime" : "Composite"));
        System.out.println("10 is " + (isPrime(10, 2) ? "Prime" : "Composite"));

        System.out.println("\n--- Task 4: Factorial (5) ---");
        System.out.println(factorial(5));

        System.out.println("\n--- Task 5: Fibonacci (5 and 17) ---");
        System.out.println("5-th: " + fibonacci(5));
        System.out.println("17-th: " + fibonacci(17));

        System.out.println("\n--- Task 6: Power (2^10) ---");
        System.out.println(power(2, 10));

        System.out.println("\n--- Task 7: Reverse Output (Enter 4 numbers, e.g., 1 4 6 2) ---");
        System.out.println("Enter n and then n numbers:");
        int n = sc.nextInt();
        reverseInput(sc, n);
        System.out.println();

        System.out.println("\n--- Task 8: Check Digits (123456 and 123a12) ---");
        System.out.println(isAllDigits("123456"));
        System.out.println(isAllDigits("123a12"));

        System.out.println("\n--- Task 9: Count Characters (hello) ---");
        System.out.println(countChars("hello"));

        System.out.println("\n--- Task 10: GCD (32 48) ---");
        System.out.println(gcd(32, 48));
    }

    // Task 1: Print Digits
    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    // Task 2: Sum for Average
    public static double findSum(int[] arr, int n) {
        if (n <= 0) return 0;
        return findSum(arr, n - 1) + arr[n - 1];
    }

    // Task 3: Prime Check
    public static boolean isPrime(int n, int i) {
        if (n <= 2) return n == 2;
        if (n % i == 0) return false;
        if (i * i > n) return true;
        return isPrime(n, i + 1);
    }

    // Task 4: Factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Task 5: Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Task 6: Power
    public static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    // Task 7: Reverse Output
    public static void reverseInput(Scanner sc, int n) {
        if (n == 0) return;
        int num = sc.nextInt();
        reverseInput(sc, n - 1);
        System.out.print(num + " ");
    }

    // Task 8: Check Digits
    public static String isAllDigits(String s) {
        if (s.isEmpty()) return "Yes";
        if (!Character.isDigit(s.charAt(0))) return "No";
        return isAllDigits(s.substring(1));
    }

    // Task 9: Count Characters
    public static int countChars(String s) {
        if (s.isEmpty()) return 0;
        return 1 + countChars(s.substring(1));
    }

    // Task 10: GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}