package net.braniumacademy.lesson811;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            int n = input.nextInt();
            var vector = new Vector<Integer>();
            for (int i = 0; i < n; i++) {
                vector.add(input.nextInt());
            }
            vector.sort((o1, o2) -> o2.intValue() - o1.intValue());
            System.out.printf("Test %d:\n", test++);
            printResult(vector);
            t--;
        }
    }

    private static <T> void printResult(Vector<T> numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
