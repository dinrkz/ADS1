//Part 1. Recursion with Numbers
//Task 1. Print Digits of a Number
package org.example;
class Main {
    public static void horizontalline(int n) {
        if(n<10){
            return ;
        }else{
            int a=n/10;
            int b=n%10;
            System.out.println(b);
        }
    }
}