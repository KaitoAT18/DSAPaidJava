package net.braniumacademy.lesson88;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises5 {
    public static char[] countingSort(char[] arr) {
        int n = arr.length;
        int k = max(arr);
        int[] count = new int[k + 1];
        char[] output = new char[n];
        for (int i = 0; i < n; i++) {
            int j = arr[i];
            count[j]++;
        }
        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int j = arr[i];
            count[j]--;
            output[count[j]] = arr[i];
        }
        return output;
    }

    private static int max(char[] arr) {
        char maxValue = arr[0];
        for (char c : arr) {
            if (c > maxValue) {
                maxValue = c;
            }
        }
        return maxValue;
    }

    private static void printResult(char[] arr) {
        for (var e : arr) {
            System.out.print(e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = Integer.parseInt(input.nextLine());
        while (t > 0) {
            var str = input.nextLine();
            var words = str.toCharArray();
            words = countingSort(words);
            printResult(words);
            t--;
        }
    }
}
