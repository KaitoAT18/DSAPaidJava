package net.braniumacademy.lesson82;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises1 {
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = n - 1; j >= i + 1; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    T tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            int n = input.nextInt();
            var arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            bubbleSort(arr);
            System.out.printf("Test %d:\n", test++);
            printResult(arr);
            t--;
        }
    }

    private static <T> void printResult(T[] words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
