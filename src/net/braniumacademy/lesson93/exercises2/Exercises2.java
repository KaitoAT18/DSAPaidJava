package net.braniumacademy.lesson93.exercises2;

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
            quickSort(arr, 0, n - 1);
            var result = countX(arr, x);
            System.out.printf("Test %d: \n%d\n", testCount++, result);
        }
        scanner.close();
    }

    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    private static int partition(int[] arr, int left, int right) {
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

    /**
     * Phương thức đếm số lần xuất hiện của giá trị x trong mảng
     *
     * @param arr mảng đích
     * @param x   giá trị cần tìm
     * @return số lần x xuất hiện trong mảng
     */
    private static int countX(int[] arr, int x) {
        int counter = 0;
        // tìm vị trí trái cùng xuất hiện x
        int startPos = leftMostX(arr, 0, arr.length - 1, x);
        if (startPos == -1) { // không tìm thấy x
            return counter;
        }
        // tìm vị trí phải củng xuất hiện x
        int endPos = rightMostX(arr, 0, arr.length - 1, x);
        return endPos - startPos + 1;
    }

    private static int leftMostX(int[] arr, int left, int right, int x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || arr[mid - 1] < x && arr[mid] == x) {
                return mid;
            }
            if (arr[mid] <= x) { // tìm phía bên phải
                return leftMostX(arr, mid + 1, right, x);
            } else { // tìm phía trái
                return leftMostX(arr, left, mid - 1, x);
            }
        }
        return -1;
    }

    private static int rightMostX(int[] arr, int left, int right, int x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == arr.length - 1 || x < arr[mid + 1] && arr[mid] == x) {
                return mid;
            }
            if (arr[mid] <= x) { // tìm phía bên phải
                return rightMostX(arr, mid + 1, right, x);
            } else { // tìm phía trái
                return rightMostX(arr, left, mid - 1, x);
            }
        }
        return -1;
    }
}