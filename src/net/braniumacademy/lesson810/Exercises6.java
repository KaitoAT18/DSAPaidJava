package net.braniumacademy.lesson810;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            var n = input.nextInt();
            var l = input.nextInt();
            var k = input.nextInt();
            var arr = new Double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextDouble();
            }
            System.out.printf("Test %d:\n", test++);
            try { // sắp xếp giảm dần các giá trị số thực
                Arrays.sort(arr, l, k, (o1, o2) -> Double.compare(o2, o1));
                printResult(arr);
            } catch (IllegalArgumentException iaex) {
                System.out.println("IllegalArgumentException");
            } catch (ArrayIndexOutOfBoundsException aiex) {
                System.out.println("ArrayIndexOutOfBoundsException");
            }
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
