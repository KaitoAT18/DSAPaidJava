package net.braniumacademy.lesson810;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            var n = input.nextInt();
            var l = input.nextInt();
            var k = input.nextInt();
            var arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            System.out.printf("Test %d:\n", test++);
            try {
                Arrays.sort(arr, l, k);
                printResult(arr);
            } catch (IllegalArgumentException iaex) {
                System.out.println("IllegalArgumentException");
            } catch (ArrayIndexOutOfBoundsException aiex) {
                System.out.println("ArrayIndexOutOfBoundsException");
            }
            t--;
        }
    }

    private static <T> void printResult(T[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
