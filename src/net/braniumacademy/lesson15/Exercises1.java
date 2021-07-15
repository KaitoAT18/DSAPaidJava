package net.braniumacademy.lesson15;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises1 {
    private static final int MAX = 90;
    private static long[] fibo = new long[MAX + 1];

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.printf("Top-down: F%d = %d\n", n, fibonacci(n));
        System.out.printf("Bottom-up: F%d = %d\n", n, fibonacciV2(n));
    }

    // top-down
    private static long fibonacci(int n) {
        if (n < 2) {
            return fibo[n] = n;
        }
        if (fibo[n] == 0) {
            fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return fibo[n];
    }

    // bottom-up
    private static long fibonacciV2(int n) {
        long f0 = 0;
        long f1 = 1;
        long fn = n < 2 ? n : 0;
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
