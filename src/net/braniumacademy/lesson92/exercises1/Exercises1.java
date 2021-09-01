package net.braniumacademy.lesson92.exercises1;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var t = scanner.nextInt(); // số bộ test t
        var testCount = 1;
        while (t-- > 0) {
            var n = scanner.nextInt();
            var x = scanner.nextFloat();
            var arr = new float[n];
            for (int i = 0; i < n; i++) { // đọc các phần tử của mảng
                arr[i] = scanner.nextFloat();
            }
            var result = findX(arr, x);
            System.out.printf("Test %d: ", testCount++);
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    /**
     * Phương thức tìm giá trị x trong mảng
     *
     * @param arr mảng đích
     * @param x   giá trị cần tìm
     * @return true nếu tìm thấy x trong mảng và flase trong trường hợp ngược lại
     */
    private static boolean findX(float[] arr, float x) {
        for (var e : arr) {
            if (e == x) {
                return true;
            }
        }
        return false;
    }
}
