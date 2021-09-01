package net.braniumacademy.lesson92.exercises2;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var t = scanner.nextInt(); // số bộ test t
        var testCount = 1;
        while (t-- > 0) {
            var n = scanner.nextInt();
            var x = scanner.nextInt();
            var arr = new int[n];
            for (int i = 0; i < n; i++) { // đọc các phần tử của mảng
                arr[i] = scanner.nextInt();
            }
            var result = countX(arr, x);
            System.out.printf("Test %d: \n%d\n", testCount++, result);
        }
        scanner.close();
    }

    /**
     * Phương thức đếm số lần xuất hiện của giá trị x trong mảng
     *
     * @param arr mảng đích
     * @param x   giá trị cần tìm
     * @return số lần x xuất hiện trong mảng
     */
    private static int countX(int[] arr, float x) {
        int counter = 0;
        for (var e : arr) {
            if (e == x) {
                counter++;
            }
        }
        return counter;
    }
}
