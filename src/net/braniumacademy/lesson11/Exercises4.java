package net.braniumacademy.lesson11;

import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        int t; // số bộ test
        int n; // số phần tử của từng bộ test
        int k; // vị trí cần chèn
        int x; // giá trị cần chèn
        int[] arr;
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        while (t > 0) {
            n = input.nextInt();
            k = input.nextInt();
            x = input.nextInt();
            arr = new int[n + 1]; // chừa ra một chỗ để chèn phần tử mới
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            result(arr, k, x);
            showResult(arr);
            t--;
        }
    }

    private static void showResult(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void result(int[] arr, int k, int x) {
        if (k < 0) {
            k = 0;
        } else if (k > arr.length - 1) {
            k = arr.length - 1;
        }
        for (int i = arr.length - 1; i > k; i--) {
            arr[i] = arr[i - 1];
        }
        arr[k] = x;
    }
}
