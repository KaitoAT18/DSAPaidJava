package net.braniumacademy.lesson811;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            int n = input.nextInt();
            var arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(input.nextInt());
            }
            arr.sort(null);
            System.out.printf("Test %d:\n", test++);
            printResult(arr);
            t--;
        }
    }

    private static <T> void printResult(List<T> numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
