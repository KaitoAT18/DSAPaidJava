package net.braniumacademy.lesson82;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises5 {
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
            System.out.printf("Test %d: \n", test++);
            bubbleSortOpt(arr);
            t--;
        }
    }

    public static void bubbleSortOpt(int[] arr) {
        boolean isSwapped;
        int i = arr.length - 1;
        while (i > 0) {
            isSwapped = false;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSwapped = true;
                    printResult(arr);
                }
            }
            if (!isSwapped) {
                break;
            } else {
                i--;
            }
        }
    }

    private static void printResult(int[] words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
