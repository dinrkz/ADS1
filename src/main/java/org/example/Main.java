//Part 1. Recursion with Numbers
//Task 1. Print Digits of a Number
import java.util.Scanner;
public static void horizontalline(int n) {
        if(n<10){
            System.out.println(n);
        }else{
            horizontalline(n/10) ;
            System.out.println((n%10));
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        horizontalline(number);
    }



//Task 2. Average of Elements
/*public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int totalSum = calculateSum(sc, n);
        double average = (double) totalSum / n;
        System.out.println(average);
    }
    public static int calculateSum(Scanner sc, int n) {
        if (n <= 0) {
            return 0;
        }
        int currentNumber = sc.nextInt();
        return currentNumber + calculateSum(sc, n - 1);
    }
}*/



//Task 3. Prime Number Check
/*public String isPrime(int n, int i) {
    if (n <= 2) return (n == 2) ? "Prime" : "Composite";
    if (n % i == 0) return "Composite";
    if (i * i > n) return "Prime";
    return isPrime(n, i + 1);
}*/



//Task 4. Factorial
/*public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=factorial(n);
        System.out.println(a);
    }
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return  n * factorial(n-1);
    }
}*/



//Task 5. Fibonacci Number
/*public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fib(n));

    }
    public static int fib(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}*/


//Task 6. Power Function
/*public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(pow(a,b));
    }
    public static int pow(int a,int b){
        if(b==0){
            return 1;
        }
        return a*pow(a,b-1);
    }
}*/



//Task 7. Reverse Output
/*public void reverseOutput(Scanner sc, int n) {
    if (n == 0) return;
    int current = sc.nextInt();
    reverseOutput(sc, n - 1);
    System.out.print(current + " ");
}



//Task 8. Check Digits
public String isAllDigits(String s) {
    if (s.isEmpty()) return "Yes";
    if (!Character.isDigit(s.charAt(0))) return "No";
    return isAllDigits(s.substring(1));
}


//Task 9. Count Characters
public int countChars(String s) {
    if (s.isEmpty()) return 0;
    return 1 + countChars(s.substring(1));
}


//Task 10. Greatest Common Divisor (GCD)
public int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

        void main() {
        }*/