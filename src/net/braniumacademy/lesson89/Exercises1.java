package net.braniumacademy.lesson89;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see  <a href="https://braniumacademy.net/">...</a>
 */

public class Exercises1 {
    // thuật toán couting sort
    public static void countingSort(int[] input, int exp) {
        int n = input.length;
        int k = 9;
        int[] count = new int[k + 1];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            int j = (input[i] / exp) % 10;
            count[j]++;
        }
        // sắp xếp tăng dần
        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }
        // đưa các phần tử vào đúng vị trí của nó
        for (int i = n - 1; i >= 0; i--) {
            int j = (input[i] / exp) % 10;
            count[j]--;
            output[count[j]] = input[i];
        }
        // sao chép các phần tử trong mảng output vào mảng gốc input
        for (int i = 0; i < n; i++) {
            input[i] = output[i];
        }
    }

    // thuật toán radix sort
    public static void radixSort(int[] arr) {
        int max = findMax(arr);
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(arr, i);
        }
    }

    // thuật toán tìm max trong mảng
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (var e : arr) {
            if (e > max) {
                max = e;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            int n = input.nextInt();
            var arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            radixSort(arr);
            System.out.printf("Test %d:\n", test++);
            showElements(arr);
            t--;
        }
    }

    private static void showElements(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
