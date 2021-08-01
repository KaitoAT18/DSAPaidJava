package net.braniumacademy.lesson86;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see  <a href="https://braniumacademy.net/">Branium</a>
 */

public class Exercises1 {
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
            MergeSort.mergeSort(arr, 0, arr.length - 1);
            System.out.printf("Test %d:\n", test++);
            printResult(arr);
            t--;
        }
    }

    private static void printResult(int[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
