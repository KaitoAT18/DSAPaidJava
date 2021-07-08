package net.braniumacademy.lesson11;

import java.util.Scanner;

public class Exercises2 {
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
        boolean isSymmetry = true;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                isSymmetry = false;
                break;
            }
        }
        if (isSymmetry) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
