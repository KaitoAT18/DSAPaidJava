package net.braniumacademy.lesson810;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises2 {
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
            Arrays.sort(arr, (o1, o2) -> o2.intValue() - o1.intValue());
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
