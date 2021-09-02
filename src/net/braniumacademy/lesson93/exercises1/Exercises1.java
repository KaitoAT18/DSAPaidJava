package net.braniumacademy.lesson93.exercises1;

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
            quickSort(arr, 0, n - 1);
            var result = findX(arr, 0, n - 1, x);
            System.out.printf("Test %d: ", testCount++);
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    private static void quickSort(float[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    private static int partition(float[] arr, int left, int right) {
        var pivot = arr[right];
        var i = left;
        for (int j = left; j <= right; j++) {
            if (arr[j] < pivot) {
                var tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        var tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        return i;
    }

    private static boolean findX(float[] arr, int left, int right, float x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) { // tìm thấy x trong mảng
                return true;
            }
            if (arr[mid] < x) { // tìm phía bên phải
                return findX(arr, mid + 1, right, x);
            } else { // tìm phía trái
                return findX(arr, left, mid - 1, x);
            }
        }
        return false;
    }
}
