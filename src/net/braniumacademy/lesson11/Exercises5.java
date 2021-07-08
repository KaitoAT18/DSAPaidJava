package net.braniumacademy.lesson11;

import java.util.Arrays;
import java.util.Scanner;

public class Exercises5 {
    public static void main(String[] args) {
        int t; // số bộ test
        int n; // số phần tử của từng bộ test
        int x; // giá trị cần xóa
        int[] arr;
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        while (t > 0) {
            n = input.nextInt();
            x = input.nextInt();
            arr = new int[n]; // chừa ra một chỗ để chèn phần tử mới
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            result(arr, x);
            t--;
        }
    }

    private static void showResult(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void result(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                for (int j = i; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                n--;
                i--;
            }
        }
        showResult(arr, n);
    }
}
