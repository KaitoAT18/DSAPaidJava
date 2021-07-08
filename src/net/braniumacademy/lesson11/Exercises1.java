package net.braniumacademy.lesson11;

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        int t;
        int n;
        int[] arr;
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        while (t > 0) {
            n = input.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            result(arr);
            t--;
        }
    }

    private static void result(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
