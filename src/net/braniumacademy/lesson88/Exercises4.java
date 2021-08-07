package net.braniumacademy.lesson88;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises4 {
    public static int[] countingSort(int[] arr) {
        int n = arr.length;
        int k = max(arr);
        int[] count = new int[k + 1];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            int j = arr[i];
            count[j]++;
        }
        for (int i = k - 1; i > 0; i--) { // change this to sorting desc
            count[i] += count[i + 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int j = arr[i];
            count[j]--;
            output[count[j]] = arr[i];
            showElements(output);
        }
        return output;
    }

    private static int max(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
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
            System.out.printf("Test %d:\n", test++);
            countingSort(arr);
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
