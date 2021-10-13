package net.braniumacademy.lesson15;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises2 {
    private static long[] fa = new long[20 + 1];

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    // top-down
    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (fa[n] == 0) {
            fa[n] = n * factorial(n - 1);
        }
        return fa[n];
    }

    // bottom-up
    private static long factorialBT(int n) {
        long fn = 1;
        for (int i = 1; i <= n; i++) {
            fn *= i; // tính lần lượt các k! với 0 < k <= n
        }
        return fn; // kết quả
    }
}
